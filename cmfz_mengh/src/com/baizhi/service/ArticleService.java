package com.baizhi.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Article;
import com.baizhi.entity.Master;
import com.baizhi.entity.PageArticle;
import com.baizhi.entity.User;

import freemarker.template.TemplateException;

public interface ArticleService {
	
	
	PageArticle queryPage(Integer start,
							Integer end);
	
	Object queryArtClicks(String artname);
	String createOneArticle(Integer id) throws IOException, TemplateException;
	Object rank();
	void insertArticle(Article article);
	
}
