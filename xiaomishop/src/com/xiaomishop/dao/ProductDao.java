package com.xiaomishop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xiaomishop.entity.Product;

@Repository
public class ProductDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public int findCountByPage(){
//		try{
			
//			String hql = "select count(id) from product";
//			Session session = sessionFactory.openSession();
//			Transaction tx = session.beginTransaction();
//			Query query = session.createQuery(hql);
//			tx.commit();
//			return query.list().size();
			
			Session session = sessionFactory.openSession();
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("from Product");
			List<Product> querylist = query.list();
			tran.commit();
			session.close();
			return querylist.size();
			
//			int count = sessionFactory.getCurrentSession().createQuery(hql).list().size();
//			return count;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	public List<Product> findByPage(int pageNum, int pageSize){
//		int pagepro = (pageNum-1)*pageSize;
//		String hql = "select * from product limit "+pagepro+","+ pageSize;
//		List<Product> list = sessionFactory.getCurrentSession().createQuery(hql).list();
//		return list;
		
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql="from Product";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Product> list = query.list();
		tran.commit();
		session.close();
		return list;
	}
	
	public Product findById(int id){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.id=?");
		query.setParameter(0,id);
		Product p= (Product)query.uniqueResult();
		session.close();
		return p;
	}
	
	public List<Product> findhotphone(int pageNum, int pageSize){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql="from Product p where p.name like '%红米%'";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Product> list = query.list();
		System.out.println("查找红米成功");
		tran.commit();
		session.close();
		return list;
	}
	
	public int findHotCount(){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Product p where p.name like '%红米%'");
		List<Product> querylist = query.list();
		tran.commit();
		session.close();
		return querylist.size();
	}
	
	public void updateProduct(Product p){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("update Product p set p.name=?,p.producttypeid=?,p.description=?,p.price=? where p.id=?");
		query.setParameter(0, p.getName());
		query.setParameter(1, p.getProducttypeid());
		query.setParameter(2, p.getDescription());
		query.setParameter(3, p.getPrice());
		query.setParameter(4, p.getId());
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void deleteProduct(int id){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("delete Product p where p.id ="+id);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void addProduct(Product p){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}
}
