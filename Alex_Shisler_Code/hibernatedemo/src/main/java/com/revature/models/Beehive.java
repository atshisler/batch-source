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
public class Beehive {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "beehiveSequence")
	@SequenceGenerator(name="beehiveSequence", allocationSize=1, sequenceName= "SQ_BEEHIVE_PK")
	@Column(name="BEEHIVE_ID")
	private int id;
	private int weight;
	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beehive(int id, int weight) {
		super();
		this.id = id;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}
	 
}
