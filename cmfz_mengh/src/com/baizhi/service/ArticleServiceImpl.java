package com.baizhi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;










import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.Jedis;
import util.ContextUtil;
import util.JedisUtil;


import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.entity.PageArticle;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,
readOnly=false,rollbackFor=Exception.class,timeout=20)
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDAO ad;
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public PageArticle queryPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageArticle pageArticle = new PageArticle();
		pageArticle.setRows(ad.queryPage((page-1)*rows, rows));
		pageArticle.setTotal(ad.queryCountArticle());
		return pageArticle;
	}

	

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Object queryArtClicks(String artname) {
		// TODO Auto-generated method stub
		//获得Jedis连接
		Jedis jedis = JedisUtil.getJedis();
		
		
		//Integer clicks = ad.queryOneArticle(artid).getClicks();
		//String cli=clicks.toString();
		//原有点击量的查询  参数 key 参数2 value
		Double zscore=jedis.zscore("article",artname);
		/*
		 * 点击量+1
		 * 
		 * */
		if(zscore!=null){
			Integer i=zscore.intValue();
			AtomicInteger a = new AtomicInteger(i);
			
			//统计点击量
			a.addAndGet(1);
			System.out.println("点击量"+a);
			//参数1: key  参数2: 点击量  参数3: 文章id  value
			jedis.zadd("article", a.intValue(),artname);
		}else if(zscore==null){
			jedis.zadd("article", 1, artname);
		}
		//存储redis key id score :点击量 值 ：artname
		
		//return ad.selectByPrimaryKey(id);
		return null;
	}

	@Override
	public Object rank() {
		// TODO Auto-generated method stub
		Jedis jedis = JedisUtil.getJedis();
		
		
		List<Article> Articles = ad.queryAllArticle();
		for (Article art : Articles) {
			jedis.zadd("article", art.getClicks(), art.getArtname());
		}	
		
		//LinkedList<Article> articles = new LinkedList<Article>();
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		
		List<String> names=new ArrayList<String>();
		List<String> counts=new ArrayList<String>();
		
		//获得redis中前十条数据，并反向排序，从小到大
		
		Set<String> zrange = jedis.zrevrange("article", 0, 9);
		
		//对value进行遍历
		for (String artname : zrange) {
			//获得文章名
			names.add(artname);
			//获得分数-----点击量
			Double zrank=jedis.zscore("article", artname);
			//获得点击量
			Integer value = zrank.intValue();
			counts.add(value.toString());
		}
		map.put("names", names);
		map.put("data", counts);
		return map;
	}
	//生成静态页面
	@Override
	public String createOneArticle(Integer artid) throws IOException, TemplateException {
		//获得配置新西
		Configuration cfg = new Configuration();
		//设置ftl文件位置
		cfg.setDirectoryForTemplateLoading(new File(
				"D:\\Mybatis\\cmfz_mengh\\src\\com\\baizhi\\ftl"));
		//设置文件编码
		cfg.setDefaultEncoding("utf-8");
		//获得模板
		Template template = cfg.getTemplate("article.ftl");
		//设置数据
		Map data = new HashMap();
		
		Article article = ad.queryOneArticle(artid);
		
		data.put("article", article);
		
		//设置输出路径
		//D:\Mybatis\cmfz_mengh\WebRoot\html
		//D:\apache-tomcat-7.0.79\webapps\cmfz_mengh
		System.out.println(ContextUtil.getSession().getServletContext().getRealPath("/html"));
		//D:\apache-tomcat-7.0.79\webapps\cmfz_mengh\html
		String path = ContextUtil.getSession().getServletContext().getRealPath("/html");
		
		Writer out = new OutputStreamWriter(new FileOutputStream(new File(path +"/"+ artid + ".html")), "UTF-8");
		template.process(data, out);
		//释放资源
		out.flush();
		out.close();
		String realpath="/html/"+artid+".html";

		return realpath;
		
	}



	@Override
	public void insertArticle(Article article) {
		// TODO Auto-generated method stub
		ad.insertArticle(article);
		System.out.println(article);
	}
	
	
}
