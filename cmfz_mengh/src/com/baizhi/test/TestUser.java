package com.baizhi.test;


import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {


	@Autowired
	private UserDAO ud;
	@Test
	public void testUser(){
		User user =new User(5,"4447","15993560503","haha.jpg","悟能","八戒","男","北京","温柔代表丑","仁波切","1","WWEE",null);
		//ud.addUser(user);
		//Integer count = ud.queryCountUser();
		//System.out.println(count);
		//User us = ud.queryOneUser(1);
		//System.out.println(us);
		//ud.updateUser(user);
		List<User> list = ud.queryPage(0, 5);
		for (User u : list) {
			System.out.println(u);
		}
		//System.out.println(user);
		//ud.updateUser(user);
	}
	
}
