package com.baizhi.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.springframework.data.redis.connection.ClusterCommandExecutor.MulitNodeResult;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.RoundPicture;

public interface RoundPicService {
	List<RoundPicture> findByPage(Integer start,Integer end);
	Integer findCount();
	void insertPic(RoundPicture rp);
	void removePic(String rpicid);
	RoundPicture findByRpicid(String rpicid);
	void modifyPic(RoundPicture rp);
	
}
