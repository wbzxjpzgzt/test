package com.baizhi.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Menu;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMenu {
	@Autowired
	private MenuDAO md;
	@Test
	public void testMenu(){
		Menu menu = new Menu(null,"日志","icon-tip","log.jsp",6,null);
		//md.updateMenu(menu);
		List<Menu> list=null;
		list = md.queryAllMenu();
		for (Menu m : list) {
			System.out.println(m);
		}
		md.addMenu(menu);
		System.out.println(menu.getMenuid());
		list = md.queryByParentId(6);
		for (Menu m : list) {
			System.out.println(m);
		}
		//md.deleteMenu(14);
	}
	@Autowired
	private AdminDAO ad;
	@Test
	public void testAdmin(){
		//Admin admin = ad.queryByName("haha");
		
		Admin admin = ad.queryByNameAndPassword("haha", "222");
		System.out.println(admin);
	}
}
