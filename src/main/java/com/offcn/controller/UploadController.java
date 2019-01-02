package com.offcn.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.offcn.po.Stu;
import com.offcn.service.StuService;

@Controller
public class UploadController {
	
	@Autowired
	StuService service;

	@RequestMapping("/uploadController")
	public String uploadExcel(@RequestParam("uploadfile")MultipartFile file,HttpServletRequest request,Model model){
		//获取服务器的真实路径
		String path=request.getServletContext().getRealPath("upload");
		//创建file对象
		File file1 = new File(path);
		//判断上传文件目录是否存在
		if(!file1.exists()){
			//创建upload目录
			file1.mkdir();
		}
		//获取原始上传文件名称
		String filename = file.getOriginalFilename();
		
		//创建保存文件file对象
		File file2 = new File(path, filename);
		
		//把上传的文件保存到指定目录
		try {
			file.transferTo(file2);
			//读取excel
			
			Workbook workbook = WorkbookFactory.create(file2);
			Sheet sheet = workbook.getSheetAt(0);
			
			int rownum = sheet.getPhysicalNumberOfRows();
			for(int i=1;i<rownum;i++){
				Row row = sheet.getRow(i);
				String name=row.getCell(0).getStringCellValue();
				float score=(float) row.getCell(1).getNumericCellValue();
				
				Stu stu = new Stu();
				stu.setName(name);
				stu.setScore(score);
				
				service.save(stu);
			}
			
			workbook.close();
			
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "uploadsuccess";
		
	}
}
