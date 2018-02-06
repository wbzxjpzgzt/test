package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.baizhi.entity.RoundPicture;

public interface RoundPicDAO {
	List<RoundPicture> queryByPage(@Param("start")Integer start,
									@Param("end")Integer end);
	Integer queryCount();
	void addPic(RoundPicture rp);
	void deletePic(String rpicid);
	RoundPicture queryByRpicid(String rpicid);
	void updatePic(RoundPicture rp);
}
