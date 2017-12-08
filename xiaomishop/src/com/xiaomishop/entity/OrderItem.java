package com.xiaomishop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orderitem")
public class OrderItem implements java.io.Serializable{

	private int id;
	private String name;
	private int	price;
	private int count;
	private int userid;
	private int chec;
	private String address;
	
	@Id
	@GeneratedValue(generator="my_gen")
	@GenericGenerator(name="my_gen",strategy="increment")
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getChec() {
		return chec;
	}
	public void setChec(int check) {
		this.chec = check;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
