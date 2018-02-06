package com.baizhi.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import util.PoiUtil;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,
readOnly=false,rollbackFor=Exception.class,timeout=20)
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO ud;
	@Override
	public void addUser(User user) {
		ud.addUser(user);
	}

	@Override
	public void deleteUser(Integer userid) {
		// TODO Auto-generated method stub
		ud.deleteUser(userid);
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> queryPage(Integer start, Integer end) {
		// TODO Auto-generated method stub
		List<User> list = ud.queryPage(start, end);
		return list;
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Integer queryCountUser() {
		// TODO Auto-generated method stub
		Integer count = ud.queryCountUser();
		return count;
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public User queryOneUser(Integer userid) {
		// TODO Auto-generated method stub
		User us = ud.queryOneUser(userid);
		return us;
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ud.updateUser(user);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> list = ud.queryAll();
		return list;
	}

	@Override
	public InputStream exportAllUser() throws Exception {
		// TODO Auto-generated method stub
		Workbook wb = PoiUtil.exportExcel(ud.queryAll(), User.class);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		wb.write(out);
		
		byte[] bytes = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		return in;
	}

	@Override
	public InputStream exportSelf(String users) throws Exception {
		// TODO Auto-generated method stub
		String[] us = users.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for (int i = 0; i < us.length; i++) {
			ids.add(Integer.valueOf(us[i]));
		}
		Workbook wb = PoiUtil.exportExcel(ud.queryBySelf(ids), User.class);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
        wb.write(out);
        byte[] bytes = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        return in;
	}

	@Override
	public void importUser(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		byte[] bytes = file.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		List<User> list = PoiUtil.importExcel(in, User.class);
	        for (User user  :list ) {
	            ud.addUser(user);
	        }
	}

	

	
	
	
}
