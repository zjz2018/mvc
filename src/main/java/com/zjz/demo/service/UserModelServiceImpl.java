package com.zjz.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjz.demo.dao.UserModelDao;
import com.zjz.demo.model.UserModel;

public class UserModelServiceImpl implements UserModelService {
	@Autowired
	private UserModelDao userModelDao;

	@Override
	public UserModel getUserModelById(Integer id) {
		UserModel m = userModelDao.getUserModelById(id);
		return m;
	}

}
