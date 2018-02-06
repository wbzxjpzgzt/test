package com.baizhi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.LogDAO;
import com.baizhi.entity.Log;
import com.baizhi.entity.PageLog;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,
readOnly=false,rollbackFor=Exception.class,timeout=20)
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDAO ld;
	@Override
	public void logAppend(Log log) {
		// TODO Auto-generated method stub
		ld.logAppend(log);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public PageLog logByPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageLog pagelog = new PageLog();
		
		pagelog.setRows(ld.logByPage((page-1)*rows, rows));
		pagelog.setTotal(ld.logCount());
		
		return pagelog;
	}



}
