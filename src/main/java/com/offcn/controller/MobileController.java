package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.Mobile;
import com.offcn.service.MobileService;

@Controller
@RequestMapping("mobile")
public class MobileController {
	@Autowired
	private MobileService mobileService;
	@RequestMapping("finds")
	@ResponseBody
	public String finds(String mobilenumber){
		Mobile mobile = mobileService.findMobile(mobilenumber);
		if(mobile!=null){			
			return mobile.getMobiletype()+" "+mobile.getMobilearea() ;
		}
		return "号码在号段库暂时不存在";
		
	}
}
