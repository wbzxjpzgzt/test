package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDAO {
	void addUser(User user);
	void deleteUser(Integer userid);
	List<User> queryPage(@Param("start")Integer start,
						@Param("end")	Integer end);
	Integer queryCountUser();
	User queryOneUser(Integer userid);
	void updateUser(User user);
	List<User> queryAll();
	List<User> queryBySelf(@Param("ids")List<Integer> ids);
	
}
