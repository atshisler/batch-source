package com.revature.model;

import javax.persistence.*;


@Entity
@Table
public class Customer2 {
	@Id	
	@Column(name = "BUYER_ID")
	@SequenceGenerator(name="customerSequence", allocationSize=1, sequenceName="SQ_CUST_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customerSequence")
	private int id;
	@Column(name = "B_NAME")
	private String name;
	@Column(name = "B_PHONENUM")
	private String phoneNum;
	
	
	public Customer2() {
		super();
	}

	
	public Customer2(int id, String name, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
	}


	public Customer2(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Customer2 [id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + "]";
	}
	
	
}
