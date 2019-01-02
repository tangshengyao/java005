package com.offcn.service;

import java.util.List;

import com.offcn.po.Stu;

public interface StuService {

	public List<Stu> getAll();
	
	public void save(Stu stu);
}
