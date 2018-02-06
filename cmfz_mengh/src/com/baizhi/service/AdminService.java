package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Resources;
import com.baizhi.entity.Role;

public interface AdminService {
	
	Admin queryByName(String adminname);
	Admin queryByNameAndPassword(String adminname,String password);
	List<Role> queryRoleByName(String adminname);
	List<Resources> querySourceByName(String adminname);
}
