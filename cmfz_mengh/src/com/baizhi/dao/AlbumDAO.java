package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Album;

public interface AlbumDAO {
	List<Album> queryAllAlbum();
	List<Album> queryByPage(@Param("start")Integer start,
							@Param("end")Integer end);
	Integer queryAlbumCount();
}
