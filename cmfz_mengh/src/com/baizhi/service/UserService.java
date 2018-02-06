package com.baizhi.service;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.annotation.Detail;
import com.baizhi.annotation.Type;
import com.baizhi.entity.User;

public interface UserService {
	@Detail("添加用户")
	@Type("添加")
	void addUser(User user);
	@Detail("删除用户")
	@Type("删除")
	void deleteUser(Integer userid);
	@Detail("分页用户")
	@Type("查询")
	List<User> queryPage(Integer start,Integer end);
	@Detail("查询用户")
	@Type("添加")
	Integer queryCountUser();
	@Detail("查询一个用户")
	@Type("查询")
	User queryOneUser(Integer userid);
	@Detail("修改用户")
	@Type("修改")
	void updateUser(User user);
	@Detail("查询所有用户")
	@Type("查询")
	List<User> queryAll();
	@Detail("导出全部用户")
	@Type("导出")
	InputStream exportAllUser() throws Exception;
	@Detail("导出用户")
	@Type("导出")
	void importUser(MultipartFile file) throws Exception;
	@Detail("自定义导出用户")
	@Type("导出")
	InputStream exportSelf(String users) throws Exception;
}
