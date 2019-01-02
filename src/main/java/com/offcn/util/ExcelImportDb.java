package com.offcn.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.Mobile;
import com.offcn.service.MobileService;

public class ExcelImportDb {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		
		MobileService service = context.getBean(MobileService.class);
		Workbook workbook=WorkbookFactory.create(new File("d:\\chart\\Mobile.xls"));
		
		//获取excel工作薄包含的工作表数量
		int numsheet = workbook.getNumberOfSheets();
		//System.out.println("工作表数量:"+numsheet);
		
		for(int i=0;i<numsheet;i++){
			
			Sheet sheet = workbook.getSheetAt(i);
			//获取指定工作表包含的有数据行数
			int numrow = sheet.getPhysicalNumberOfRows();
			List<Mobile> list=new ArrayList();
			for(int j=1;j<numrow;j++){
				Row row = sheet.getRow(j);
				//获取行里面包含的单元格数量
				int numcell = row.getPhysicalNumberOfCells();
				StringBuffer b=new StringBuffer();
				for(int q=0;q<numcell;q++){
					
					Cell cell = row.getCell(q);
					if(cell.getCellTypeEnum()==CellType.STRING){
						b.append(cell.getStringCellValue()+"~");
					}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
						b.append(cell.getNumericCellValue()+"~");
					}
					
				}
				//获取到了一行内容
				String[] ss = b.toString().split("~");
				Mobile m = new Mobile();
				m.setMobilenumber(ss[1]);
				m.setMobilearea(ss[2]);
				m.setMobiletype(ss[3]);
				m.setAreacode(ss[4]);
				m.setPostcode(ss[5]);
				//System.out.println(m);
				//把数据保存到list集合
				list.add(m);
				//保存数据
				//service.save(m);
				
				//判断list集合是否存储了1000条数据
				if(list.size()==1000){
					service.saves(list);
					//清空list
					list.clear();
				}
			}
			
			//循环完成所有行，处理剩余不足1000条保存
			if(list.size()>0){
			service.saves(list);
			//清空list
			list.clear();
			}
		}
		workbook.close();
	}

}
