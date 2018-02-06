package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Article;
import com.baizhi.entity.Master;
import com.baizhi.entity.User;

public interface ArticleDAO {
	
	
	List<Article> queryPage(@Param("start")Integer start,
						@Param("end")	Integer end);
	Integer queryCountArticle();
	Article queryOneArticle(Integer artid);
	List<Article> queryAllArticle();
	void insertArticle(Article art);
	void updateArticle(Article art);
}
