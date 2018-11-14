package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Cave {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSequence")
@SequenceGenerator(name = "caveSequence", allocationSize = 1, sequenceName = "SQ_CAVE_PK")
@Column(name = "CAVE_ID")
private int id;
private String name;

public Cave() {
	super();
	// TODO Auto-generated constructor stub
}

public Cave(String name) {
	this.name = name;
}
public Cave(int id, String name) {
	super();
	this.id = id;
	this.name = name;
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

@Override
public String toString() {
	return "Cave [id=" + id + ", name=" + name + "]";
}


}

