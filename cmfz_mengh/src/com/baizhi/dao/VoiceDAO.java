package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Voice;

public interface VoiceDAO {
	List<Voice> queryAllVoice();
	List<Voice> queryByPage(@Param("start")Integer start,
							@Param("end")Integer end);
	Integer queryVoiceCount();
}
