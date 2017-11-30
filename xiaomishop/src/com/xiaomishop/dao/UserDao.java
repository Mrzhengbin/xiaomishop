package com.xiaomishop.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaomishop.entity.User;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;
	
	/** 添加用户信息*/
	public void insert(User user){
		try{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
//		Session session = sessionFactory.getCurrentSession();
//		if(session.createQuery("from user u where u.loginname ="+user.getUserName()).uniqueResult()!=null){
//			return false;
//		}else{
//			session.save(user);
//			return true;
//		}
	}
	
	public User selectByUsername(String name,String password){
		String hql = "from User where name ="+name;
		return (User)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
//		User u=this.sessionFactory.getCurrentSession().get(User.class, username);]
		
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		User u = session.get(User.class, username);
//		return u;
	}
}
