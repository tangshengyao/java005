package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.Pie;
import com.offcn.po.Stu;
import com.offcn.service.StuService;

@Controller
public class StuController {

	@Autowired
	StuService service;
	
	@RequestMapping("/getall")
	@ResponseBody
	public List<Stu> getall(){
		
		return service.getAll();
	}
	
	@RequestMapping("/getallpie")
	@ResponseBody
	public List<Pie> getallPie(){
		List<Stu> list = service.getAll();
		List<Pie> listpie=new ArrayList<Pie>();
		for (Stu stu : list) {
			Pie p = new Pie();
			p.setName(stu.getName());
			p.setValue(stu.getScore());
			
			listpie.add(p);
		}
		
		return listpie;
	}
}
