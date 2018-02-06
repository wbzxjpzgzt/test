package com.baizhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import com.baizhi.service.MenuServiceImpl;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService msi;
	List<Menu> list=null;
	@RequestMapping("/queryall")
	@ResponseBody
	public List<Menu> findAllMenu(){
		
		list = msi.findAllMenu();
		return list;
	}
}
