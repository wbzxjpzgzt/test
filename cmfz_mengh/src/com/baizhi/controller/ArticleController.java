package com.baizhi.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import util.ContextUtil;

import com.baizhi.entity.Article;
import com.baizhi.entity.PageArticle;
import com.baizhi.entity.PageLog;
import com.baizhi.service.ArticleService;
import com.baizhi.service.MasterService;

import freemarker.template.TemplateException;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService as;
	@Autowired
	private MasterService ms;
	@RequestMapping("/rank")
	@ResponseBody
	public Object rank(){
		return as.rank();
	}
	@RequestMapping("/queryall")
	@ResponseBody
	public PageArticle queryAllArticle(Integer page,Integer rows){
		PageArticle pagelist = as.queryPage(page, rows);
		return pagelist;
	}
	@RequestMapping("/insertart")
	
	public String insertArticle(Article article) throws IOException, TemplateException{
		if(article.getClicks()==null){
			article.setClicks(0);
		}
		article.setArttime(new Date());
		//查询大师图像
		
		article.setArtpic(ms.queryOneMaster(article.getMid()).getMasterhead());
		
		as.insertArticle(article);
		System.out.println(article.getArtid());
		//D:\apache-tomcat-7.0.79\webapps\cmfz_mengh\html
		System.out.println(ContextUtil.getSession().getServletContext().getRealPath("/html"));
		String path = as.createOneArticle(article.getArtid());
		//  /cmfz_mengh/html44.html
		System.out.println("----"+path);
		return "redirect:"+path;
	}
	
	
}
