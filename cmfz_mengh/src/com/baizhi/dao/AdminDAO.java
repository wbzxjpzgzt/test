package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Resources;
import com.baizhi.entity.Role;

public interface AdminDAO {
	Admin queryByName(String adminname);
	Admin queryByNameAndPassword(@Param("adminname")String adminname,
								 @Param("password")String password);
	List<Role> queryRoleByName(String adminname);
	List<Resources> querySourceByName(String adminname);
	
}
