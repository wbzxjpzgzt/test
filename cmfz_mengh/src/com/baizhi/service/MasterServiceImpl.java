package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.MasterDAO;
import com.baizhi.entity.Master;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,
readOnly=false,rollbackFor=Exception.class,timeout=20)
public class MasterServiceImpl implements MasterService {
	@Autowired
	private MasterDAO md;
	@Override
	public List<Master> queryPage(Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer queryCountMaster() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Master queryOneMaster(String mid) {
		// TODO Auto-generated method stub
		Master master = md.queryOneMaster(mid);
		return master;
	}

}
