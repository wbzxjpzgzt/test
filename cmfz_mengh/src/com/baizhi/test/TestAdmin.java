package com.baizhi.test;


import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import util.MD5Util;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAdmin {


	@Autowired
	private AdminDAO ad;
	@Test
	public void testAdmin(){
		Admin admin = ad.queryByName("haha");
		/*String uuid = UUID.randomUUID().toString();
		System.out.println("+++++"+uuid+"++++++");*/
		String salt=MD5Util.getSalt(4);
		System.out.println(salt);
		String pwd=salt+"6666";
		System.out.println(pwd);
		String md5 = MD5Util.md5(pwd);
		System.out.println("----------"+md5+"---------");
		
		
		//查询
		/*String salt = admin.getSalt();
		String pwd2="6666"+salt;
		String md5 = MD5Util.md5(pwd2);
		Admin admin2 = ad.queryByNameAndPassword("haha", md5);
		System.out.println(admin2);*/
	}
}
