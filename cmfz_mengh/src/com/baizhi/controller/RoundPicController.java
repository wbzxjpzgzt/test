package com.baizhi.controller;



import java.io.IOException;
import java.util.Date;
import java.util.List;



import java.util.UUID;



import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import com.baizhi.entity.PageRoundPicture;
import com.baizhi.entity.RoundPicture;
import com.baizhi.service.RoundPicService;



@Controller
@RequestMapping("/roundpic")
public class RoundPicController {
	@Autowired
	private RoundPicService rsi;
	@Autowired
	private PageRoundPicture prp;
	
    private final String FILENAME="fdfs_client.conf";

    private StorageClient storageClient=null;

 


    
	
	
	@RequestMapping("/querypic")
	@ResponseBody
	//当前页码  page  每页行数  rows
	public PageRoundPicture findByPage(Integer page,Integer rows){
		System.out.println(page+"------"+rows);
		Integer start=0;
		Integer end=0;
		if(page==1){
			end=rows;
		}else{
			start=(page-1)*rows;
			end=page*rows;
		}
		List<RoundPicture> list = rsi.findByPage(start, rows);
		prp.setRows(list);
		Integer count = rsi.findCount();
		prp.setTotal(count);
		return prp;
	}
	@RequestMapping("/modifypic")
	@ResponseBody
	public String modifyPic(RoundPicture tr){
		try {
			System.out.println(tr);
			rsi.modifyPic(tr);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping("/addpic")
	@ResponseBody
	public String addPic(RoundPicture tr,HttpSession session){
		try {
	    	System.out.println("执行了在方法前");
	        //加载配置文件
	        ClientGlobal.init(FILENAME);
	        //创建追踪客户端
	        TrackerClient trackerClient = new TrackerClient();

	        TrackerServer trackerServer = trackerClient.getConnection();
	        //创建存储服务器客户端
	        storageClient=new StorageClient(trackerServer,null);
	        System.out.println(storageClient);
			//拿到文件对象
			MultipartFile file = tr.getFile();
			byte[] bytes = file.getBytes();
			
			//或取完整名
			String originalFilename = file.getOriginalFilename();
			System.out.println(originalFilename);
			//拿到文件后缀
			String extention = FilenameUtils.getExtension(originalFilename);
			System.out.println("文件后缀名为"+extention);
			System.out.println(storageClient);
			String[] name = storageClient.upload_file(bytes, extention, null);
//			System.out.println(originalFilename);
			
			String uuid = UUID.randomUUID().toString();
			tr.setRpicid(uuid);
			tr.setPictime(new Date());
//			String path=realPath+File.separator+uuid+extension;
//			//图片存放路径
//			//file.transferTo(new File(path));
//			rsi.uploadImag(path, extension);
			
			//拿到项目名+组名+文件地址
			String url = "192.168.174.136/"+name[0]+"/"+name[1];
			tr.setPicname(url);			
			rsi.insertPic(tr);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	@RequestMapping("/delpic")
	@ResponseBody
	public String deletePic(String rpicid){
		
		try {
			rsi.removePic(rpicid);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}