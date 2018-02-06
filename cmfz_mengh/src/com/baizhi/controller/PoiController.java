package com.baizhi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.MD5Util;
import util.PoiUtil;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;

@Controller
@RequestMapping("/excel")
public class PoiController {
	@Autowired
	private UserService usi;
	@RequestMapping("/exportall")
	
	public String exportAll(HttpServletResponse response) throws Exception{
		
			
				response.setHeader("content-disposition","attachment;filename=usermessage.xls");
		        IOUtils.copy(usi.exportAllUser(),response.getOutputStream());
				return null;
				
			
	}
	@RequestMapping("/importuser")
	@ResponseBody
	public String importUser(MultipartFile file) throws Exception{
        try {
        	usi.importUser(file);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	@RequestMapping("/exportSelUsers")
    public String exportSelUsers(String users, HttpServletResponse response) throws Exception{
        response.setHeader("content-disposition","attachment;filename=usermessage.xls");
        IOUtils.copy(usi.exportSelf(users),response.getOutputStream());
        return null;
    }
    @RequestMapping("/downModel")
    public String downUserModel(HttpSession session, HttpServletResponse response) throws Exception{
        String realPath = session.getServletContext().getRealPath("/back/model");
        FileInputStream in = new FileInputStream(realPath+ File.separator+"usermodel.xls");
        response.setHeader("content-disposition","attachment;filename=usermodel.xls");
        IOUtils.copy(in,response.getOutputStream());
        return null;
    }
}

