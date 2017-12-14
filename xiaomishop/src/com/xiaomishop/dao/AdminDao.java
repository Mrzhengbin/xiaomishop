package com.xiaomishop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xiaomishop.entity.Product;

@Repository
public class AdminDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public List findAllProduct(){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> querylist = query.list();
		tran.commit();
		session.close();
		return querylist;
	}
	
	
}
