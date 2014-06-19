package com.zjz.demo.dao;

import org.springframework.stereotype.Repository;

import com.zjz.demo.model.UserModel;

@Repository
public interface UserModelDao {
	public UserModel getUserModelById(Integer id);

}
