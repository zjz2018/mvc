package com.zjz.demo.service;

import org.springframework.stereotype.Service;

import com.zjz.demo.model.UserModel;

@Service
public interface UserModelService {
	public UserModel getUserModelById(Integer id);

}
