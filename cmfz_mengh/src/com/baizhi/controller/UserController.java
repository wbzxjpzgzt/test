package com.baizhi.controller;




import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.PageUser;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService usi;
	@Autowired
	private PageUser pu;
	
	@RequestMapping("/queryuser")
	@ResponseBody
	//当前页码  page  每页行数  rows
	public PageUser findByPage(Integer page,Integer rows){
		System.out.println(page+"------"+rows);
		Integer start=0;
		Integer end=0;
		if(page==1){
			end=rows;
		}else{
			start=(page-1)*rows;
			end=page*rows;
		}
		List<User> list = usi.queryPage(start, rows);
		pu.setRows(list);
		Integer count = usi.queryCountUser();
		pu.setTotal(count);
		return pu;
	}

}