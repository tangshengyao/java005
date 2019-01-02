package com.offcn.dao;

import java.util.List;

import com.offcn.po.Stu;

public interface StuDao {

	//读取后台全部的学生信息
	public List<Stu> getAll();
	//保存学生成绩到数据库
	public void save(Stu stu);
}
