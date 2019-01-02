package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.MobileDao;
import com.offcn.po.Mobile;
import com.offcn.service.MobileService;
@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileDao dao;
	@Override
	public void save(Mobile m) {
      //业务逻辑，判断号码是否大于7位，处理
		if(m!=null&&m.getMobilenumber().length()>7){
			String number=m.getMobilenumber().substring(0, 7);
			System.out.println("number:"+number);
			m.setMobilenumber(number);
		}
		dao.save(m);
	}
	@Override
	public void saves(List<Mobile> list) {
		dao.saves(list);
		
	}
	@Override
	public Mobile findMobile(String mobilenumber) {
		// TODO Auto-generated method stub
		return dao.findMobile(mobilenumber);
	}

}
