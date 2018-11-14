package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Bear {
private int id;
private String name;
private Date birthday;
private Cave cave;
private List<Beehive> beehives = new ArrayList<Beehive>();

public Bear() {
	super();
	// TODO Auto-generated constructor stub
}
public Bear(int id, String name, Date birthday, Cave cave) {
	super();
	this.id = id;
	this.name = name;
	this.birthday = birthday;
	this.cave = cave;
}

public List<Beehive> getBeehives() {
	return beehives;
}
public void setBeehives(List<Beehive> beehives) {
	this.beehives = beehives;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public Cave getCave() {
	return cave;
}
public void setCave(Cave cave) {
	this.cave = cave;
}





}
