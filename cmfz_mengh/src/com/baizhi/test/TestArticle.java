package com.baizhi.test;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ArticleDAO;
import com.baizhi.dao.VoiceDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.Voice;
import com.baizhi.service.ArticleServiceImpl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestArticle {


	@Autowired
	private ArticleDAO ad;
	@Autowired
	private VoiceDAO vd;
	@Autowired
	private AlbumDAO ald;
	@Test
	public void testArticle(){
		List<Article> list = ad.queryAllArticle();
		//Article article = ad.queryOneArticle("上师");
		Article a = new Article(null,"上师对弟子的评价和期许","密勒日巴尊者可说是西藏“实践佛法”的代表。","仁波切",new Date(),1,"1","5.jpg",null);
		//ad.insertArticle(a);
		ad.updateArticle(a);
		//System.out.println(article);
		//System.out.println(list);
	}
	@Test
	public void testAlbum(){
		List<Album> list = ald.queryAllAlbum();
		System.out.println(list);
		List<Album> l = ald.queryByPage(0, 5);
		System.out.println(l);
		Integer count = ald.queryAlbumCount();
		System.out.println(count);
	}
	@Test
	public void testVoice(){
		List<Voice> list =vd.queryAllVoice();
		for (Voice v : list) {
			System.out.println(v);
		}
		List<Voice> page = vd.queryByPage(0, 5);
		System.out.println(page);
		Integer count = vd.queryVoiceCount();
		System.out.println(count);
	}
	@Test
	public void testA() throws IOException, TemplateException{
		//获得配置新西
		Configuration cfg = new Configuration();
		//设置ftl文件位置
		cfg.setDirectoryForTemplateLoading(new File(
				"D:\\Mybatis\\cmfz_mengh\\src\\com\\baizhi\\ftl"));
		//设置文件编码
		cfg.setDefaultEncoding("UTF-8");
		//获得模板
		Template template = cfg.getTemplate("article.ftl");
		//设置数据
		Map data = new HashMap();
		
		Article article = ad.queryOneArticle(1);
		
		data.put("article", article);
		
		//设置输出路径
		File f = new File("D:\\Mybatis\\cmfz_mengh\\WebRoot\\html\\"+article.getArtname()+".html");
		String path = f.getAbsolutePath();
		System.out.println(path);
		
		
		FileWriter out = new FileWriter(f);
		
		template.process(data, out);
		
		//释放资源
		out.flush();
		out.close();
		
	}
	@Test
	public void pass(){
		//System.out.println(ArticleServiceImpl.class.getResource("/"));
		
		//System.out.println(ClassLoader.getSystemResource(""));
		//System.out.println(ArticleServiceImpl.class.getClassLoader().getResource("/"));
	}
	
}
