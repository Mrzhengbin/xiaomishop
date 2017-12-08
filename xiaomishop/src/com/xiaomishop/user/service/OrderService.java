package com.xiaomishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaomishop.dao.OrderDao;
import com.xiaomishop.entity.CartItem;
import com.xiaomishop.entity.OrderItem;

@Service
public class OrderService {
	@Resource
	private OrderDao orderDao;
	
	public void insertOrder(OrderItem o){
		orderDao.InsertOrder(o);
	}
	
	public List findByUserId(int userid){
		return orderDao.findByUserId(userid);
	}
	
	public void deleteOrder(int id){
		orderDao.deleteOrder(id);
	}
	
	public OrderItem findById(int id){
		return orderDao.findById(id);
	}
	
	public void addaddress(String address,int id){
		orderDao.addaddress(address, id);
	}
}
