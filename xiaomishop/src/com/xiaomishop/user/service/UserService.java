package com.xiaomishop.user.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaomishop.dao.UserDao;
import com.xiaomishop.entity.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;

	public void regist(User user) {
		userDao.insert(user);
	}

	public User login(String name,String password) {
		return userDao.selectByUsername(name, password);
	}
}
