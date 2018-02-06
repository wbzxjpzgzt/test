package com.baizhi.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.MD5Util;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.RoundPicDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.RoundPicture;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class,timeout=20)
public class RoundPicServiceImpl implements RoundPicService {

	
	
	
	@Autowired
	private RoundPicDAO rpd;
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<RoundPicture> findByPage(Integer start, Integer end) {
		// TODO Auto-generated method stub
		List<RoundPicture> list = rpd.queryByPage(start, end);
		return list;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Integer findCount() {
		// TODO Auto-generated method stub
		Integer count=rpd.queryCount();
		return count;
	}

	@Override
	public void insertPic(RoundPicture rp) {
		// TODO Auto-generated method stub
		
			rpd.addPic(rp);
		
	}

	@Override
	public void removePic(String rpicid) {
		// TODO Auto-generated method stub
		rpd.deletePic(rpicid);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public RoundPicture findByRpicid(String rpicid) {
		// TODO Auto-generated method stub
		RoundPicture pic = rpd.queryByRpicid(rpicid);
		return pic;
	}

	@Override
	public void modifyPic(RoundPicture rp) {
		// TODO Auto-generated method stub
		
		rpd.updatePic(rp);
	}



}
