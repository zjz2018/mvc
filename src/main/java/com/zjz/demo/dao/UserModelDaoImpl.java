package com.zjz.demo.dao;

import com.zjz.demo.model.UserModel;

public class UserModelDaoImpl implements UserModelDao {
	

	public UserModel getUserModelById(Integer id) {
		UserModel model=new UserModel();
		model.setUsername("kk");
		model.setId(12);
		model.setPassword("psw0001");
		return model;
	}

}
