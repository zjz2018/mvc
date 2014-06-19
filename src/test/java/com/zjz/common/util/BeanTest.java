package com.zjz.common.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjz.demo.model.UserModel;
import com.zjz.demo.service.UserModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class BeanTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserModelService userModelService;
	

	@Test
	public void beanTest(){
		UserModel m=userModelService.getUserModelById(1);
		Assert.assertEquals("kk", m.getUsername());
	}
}
