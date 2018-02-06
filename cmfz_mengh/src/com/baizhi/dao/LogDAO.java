package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Log;

public interface LogDAO {
	void logAppend(Log log);
	List<Log> logByPage(Integer start,Integer end);
	Integer logCount();
}
