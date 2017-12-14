package com.xiaomishop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaomishop.dao.AdminDao;

@Service
public class AdminService {
	@Resource
	private AdminDao adminDao;
	
	public List findAllProduct(){
		return adminDao.findAllProduct();
	}
}
