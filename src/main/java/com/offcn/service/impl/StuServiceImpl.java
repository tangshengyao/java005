package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.StuDao;
import com.offcn.po.Stu;
import com.offcn.service.StuService;
@Service
public class StuServiceImpl implements StuService {

	@Autowired
	StuDao stuDao;
	@Override
	public List<Stu> getAll() {
		
		return stuDao.getAll();
	}
	@Override
	public void save(Stu stu) {
		
		stuDao.save(stu);
	}

}
