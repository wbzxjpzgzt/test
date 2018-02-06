package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.baizhi.entity.Master;
import com.baizhi.entity.User;


public interface MasterService {
	
	
	List<Master> queryPage(Integer start,Integer end);
	Integer queryCountMaster();
	Master queryOneMaster(String mid);
	
	
	
}
