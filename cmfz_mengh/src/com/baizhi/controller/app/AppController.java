package com.baizhi.controller.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Article;
import com.baizhi.entity.PageArticle;
import com.baizhi.entity.RoundPicture;
import com.baizhi.service.ArticleService;
import com.baizhi.service.ArticleServiceImpl;
import com.baizhi.service.MenuService;
import com.baizhi.service.MenuServiceImpl;
import com.baizhi.service.RoundPicService;
import com.baizhi.service.RoundPicServiceImpl;

@Controller
@RequestMapping("/")
public class AppController {
	
	/*
	 * 
	 * 首页
	 * 
	 * */
	//轮播图service
	@Autowired
	private RoundPicService rps;
	//专辑service
	
	//文章的service
	@Autowired
	private ArticleService asi;
	//菜单的service
	@Autowired
	private MenuService msi;
	@RequestMapping("/first_page")
	@ResponseBody
	public Object firstPage(String uid,String type,String sub_type){
		//ExecutorService cachepool = Executors.newCachedThreadPool();
		//返回的APP字符串，其中是图片集合{header:[{}{}{}{}{}]}
		HashMap<String, Object> m = new HashMap<String, Object>();
		
		if("all".equals(type)){
			//图片集合{ header:[{}{}{}{}] }中的{}
			ArrayList<HashMap> lunbo = new ArrayList<HashMap>();
			m.put("header", lunbo);
			
			
			//调用service查询出5张图片
			List<RoundPicture> list = rps.findByPage(0, 5);
			//将图片对象转成字符串形式(只为传输数据)格式{thumbnail:v,desc:v,....}
			HashMap<String, Object> mDTO = new HashMap<String,Object>();
			for (RoundPicture rp : list) {
				mDTO.put("thumbnail", "http://www.qq1234.org/uploads"+rp.getPicname());
				mDTO.put("desc", rp.getPicdiscribe());
				mDTO.put("id", rp.getRpicid());
				lunbo.add(mDTO);
			}
			
		}else{
			
			//菜单列表
			ArrayList<HashMap> zuopin = new ArrayList<HashMap>();
			m.put("body",zuopin);
			if("si".equals(type)){
				
				if("ssyj".equals(sub_type)){
					//专辑（上师言教）
					//调用service查询出所有专辑
					//List<Album> list = rps.findAllAlbum();
					//将图片对象转成字符串形式(只为传输数据)格式{thumbnail:v,desc:v,....}
					/*HashMap<String, Object> aDTO = new HashMap<String,Object>();
					for (Album rp : list) {
						aDTO.put("thumbnail", "http://wenwen.soso.com/p/20111105/"+rp.getPicname());
						aDTO.put("title", rp.getPicdiscribe());
						aDTO.put("author", rp.getRpicid());
						aDTO.put("type", "0");
						aDTO.put("set_count", rp.getRpicid());
						aDTO.put("create_date", rp.getRpicid());
						zuopin.add(aDTO);
					}*/
				}else if("xmfy".equals(sub_type)){
					//文章（显密法要）
					PageArticle article = asi.queryPage(0, 5);
					List<Article> list = article.getRows();
					HashMap<String, Object> wDTO = new HashMap<String,Object>();
					for (Article art : list) {
						wDTO.put("thumbnail","http://wenwen.soso.com/p/20111105/"+art.getArtpic());
						wDTO.put("title",art.getArtname());
						wDTO.put("author",art.getMid());
						wDTO.put("type","0");
						wDTO.put("set_count",art.getClicks());
						wDTO.put("creat_date",art.getArttime());					
						zuopin.add(wDTO);
					}
				
				}
			}
		}
		return m;
	}
	
}
