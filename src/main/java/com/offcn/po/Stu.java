package com.offcn.po;

public class Stu {
private Integer id;
private String name;
private Float score;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Float getScore() {
	return score;
}
public void setScore(Float score) {
	this.score = score;
}
@Override
public String toString() {
	return "Stu [id=" + id + ", name=" + name + ", score=" + score + "]";
}


}
