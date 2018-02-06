package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.MD5Util;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Resources;
import com.baizhi.entity.Role;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,
readOnly=false,rollbackFor=Exception.class,timeout=20)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO ad;
	@Transactional(propagation=Propagation.SUPPORTS)
	public Admin queryByName(String adminname) {
		// TODO Auto-generated method stub
		Admin admin = ad.queryByName(adminname);
		return admin;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Admin queryByNameAndPassword(String adminname, String password) {
		// TODO Auto-generated method stub
		
		String md5 = MD5Util.md5(password);
		Admin admin = ad.queryByNameAndPassword(adminname, md5);
		return admin;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Role> queryRoleByName(String adminname) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Resources> querySourceByName(String adminname) {
		// TODO Auto-generated method stub
		return null;
	}

}
