package com.baizhi.service;



import com.baizhi.entity.Log;
import com.baizhi.entity.PageLog;


public interface LogService {
	void logAppend(Log log);
	PageLog logByPage(Integer start,Integer end);
	
}
