package com.offcn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.po.Stu;
import com.offcn.service.StuService;
/*
 * 新增注释，测试
 */
@Controller
public class DownloadExcelController {

	@Autowired
	StuService service;
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response){
		List<Stu> list = service.getAll();
		
		String path=request.getServletContext().getRealPath("download");
		
		File file1 = new File(path);
		if(!file1.exists()){
			
			file1.mkdir();
		}
		
		String filename="demo1.xlsx";
		File file2 = new File(file1, filename);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("学生成绩表");
		int num=0;
		for(Stu stu:list){
			XSSFRow row = sheet.createRow(num);
			row.createCell(0).setCellValue(stu.getId());
			row.createCell(1).setCellValue(stu.getName());
			row.createCell(2).setCellValue(stu.getScore());
			num++;
		}
		try {
			workbook.write(new FileOutputStream(file2));
			
			//设置响应头,通知浏览器服务器端要传输的文件类型
			response.setContentType("application/x-xls;charset=GBK");
			//设置要传输的文件名称，以及提示浏览器下载
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			//设置文件长度
			response.setContentLength((int)file2.length());
			//获取输出流
			ServletOutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(file2);
			
			byte[] buf=new byte[4096];
			int len=-1;
			
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
