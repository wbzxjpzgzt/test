package com.baizhi.test;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import util.MD5Util;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.RoundPicDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.RoundPicture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Testroundpic {


	@Autowired
	private RoundPicDAO rpd;
	@Test
	public void testRoundPic(){
		/*List<RoundPicture> list = rpd.queryByPage(0, 2);
		Integer count = rpd.queryCount();
		System.out.println(count);
		for (RoundPicture r : list) {
			System.out.println(r);
		}
		//String uuid = UUID.randomUUID().toString();
		//System.out.println("+++++"+uuid+"++++++");
		Date date =new Date();
		RoundPicture roundpic = new RoundPicture("5f7146f0-4466-4199-82c7-3547346c9c45","4.gif","西藏喇嘛","展示中",date);
		//rpd.addPic(roundpic);
		RoundPicture q = rpd.queryByRpicid("5f7146f0-4466-4199-82c7-3547346c9c45");
		System.out.println(q);
		//rpd.deletePic("haha");
		rpd.updatePic(roundpic);*/
		
		//查询
		/*String salt = admin.getSalt();
		String pwd2="6666"+salt;
		String md5 = MD5Util.md5(pwd2);
		Admin admin2 = ad.queryByNameAndPassword("haha", md5);
		System.out.println(admin2);*/
	}
}
