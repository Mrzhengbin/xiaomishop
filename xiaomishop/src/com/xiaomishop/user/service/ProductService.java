package com.xiaomishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaomishop.dao.ProductDao;
import com.xiaomishop.entity.Product;

@Service
public class ProductService {
	@Resource
	private ProductDao productDao;
	
	public int findCount(){
		return productDao.findCountByPage();
	}
	
	public List<Product> findByPage(int num,int pageSize){
		return productDao.findByPage(num, pageSize);
	}
	
	public Product findById(int id){
		return productDao.findById(id);
	}
	
	public List<Product> findhot(int pageNum, int pageSize){
		return productDao.findhotphone(pageNum, pageSize);
	}
	
	public int findHotCount(){
		return productDao.findHotCount();
	}
}
