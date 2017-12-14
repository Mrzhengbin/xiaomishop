package com.xiaomishop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xiaomishop.entity.OrderItem;
import com.xiaomishop.entity.Product;

@Repository
public class OrderDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public List findByUserId(int userid){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from OrderItem where userid="+userid);
		List<OrderItem> querylist = query.list();
		tran.commit();
		session.close();
		return querylist;
	}
	
	public void InsertOrder(OrderItem o){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(o);
		tran.commit();
//		System.out.println("2");
		session.close();
	}
	
	public void deleteOrder(int id){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("delete from OrderItem where id="+id);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public OrderItem findById(int id){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from OrderItem where id="+id);
		OrderItem o = (OrderItem) query.uniqueResult();
		tran.commit();
		session.close();
		return o;
	}
	
	public void addaddress(String address,int id){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("update OrderItem set address = "+address+" where id="+id);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public List findAllOrder(){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from OrderItem");
		List<OrderItem> querylist = query.list();
		tran.commit();
		session.close();
		return querylist;
	}
}
