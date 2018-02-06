package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Master;
import com.baizhi.entity.User;

public interface MasterDAO {
	
	
	List<Master> queryPage(@Param("start")Integer start,
						@Param("end")	Integer end);
	Integer queryCountMaster();
	Master queryOneMaster(String mid);
	
	
	
}
