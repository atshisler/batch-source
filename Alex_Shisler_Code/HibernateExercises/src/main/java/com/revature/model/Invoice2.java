package com.revature.model;



import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class Invoice2 {
	@Id
	@Column(name = "INVOICE_ID")
	@SequenceGenerator(name="invoiceSequence", allocationSize=1, sequenceName="SQ_INV_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="invoiceSequence")
	private int id;
	
	@Column(name = "I_DATE")
	private Date date;
	
	@Column(name = "I_AMOUNT")
	private double amount;
	
	
	public Invoice2() {
		super();
	}
	public Invoice2(int id, Date date, double amount) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
	}
	public Invoice2(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Invoice2 [id=" + id + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
}
