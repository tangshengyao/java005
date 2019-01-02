package com.offcn.dao;

import java.util.List;

import com.offcn.po.Mobile;

public interface MobileDao {
 public void save(Mobile m);
 public void saves(List<Mobile> list);
 public Mobile findMobile(String mobilenumber);
}
