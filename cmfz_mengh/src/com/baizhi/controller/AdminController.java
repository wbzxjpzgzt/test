package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.CodeUtil;
import util.ImageUtil;
import util.MD5Util;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService asi;
	@RequestMapping("/queryname")
	public String validateAdmin(String adminname,HttpServletResponse response) throws Exception{
		Admin admin = asi.queryByName(adminname);
		PrintWriter writer=response.getWriter();
		if(admin==null){
			writer.print("N");
			return null;
		}else {
			writer.print("Y");
			return null;
		}
	}
	@RequestMapping("/querynamepassword")
	public String findByAdminName(String adminname,String password,HttpServletResponse response,HttpServletRequest request) throws Exception{
		System.out.println(adminname+"-------"+password);
		Admin admin = asi.queryByName(adminname);
		System.out.println(admin);
		String salt = admin.getSalt();
		System.out.println(salt);
		String pwd=salt+password;
		System.out.println(pwd);
		String md5 = MD5Util.md5(pwd);
		System.out.println(md5);
		PrintWriter writer=response.getWriter();
		if(admin.getPassword().equals(md5)==false){
			System.out.println(admin.getPassword().equals(md5));
			writer.print("N");
			return null;
		}else {
			//String path=request.getSession().getServletContext().getContextPath();
			return "redirect:/back/main.jsp";
		}
		
	}
	@RequestMapping("/getcode")
	public String image(HttpServletResponse response,HttpSession session){
		String code = ImageUtil.getCode();
		BufferedImage image = ImageUtil.createImage(code);
		session.setAttribute("code", code);
		try {
			ServletOutputStream stream = response.getOutputStream();
			ImageIO.write(image, "png", stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/validatecode")
	public String validateCode(String code,HttpServletResponse response,HttpSession session) throws Exception{
		String string = (String)session.getAttribute("code");
		PrintWriter writer = response.getWriter();
		if(code.equalsIgnoreCase(string)){
			writer.print("Y");
			
		}else{
			writer.print("N");
		}
		return null;
	}
	@RequestMapping("/login")
	public String login(Admin admin,HttpSession session){
		//获得主体
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminname(),admin.getPassword());
		try {
			
			subject.login(token);
			session.setAttribute("admin", admin);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/back/main.jsp";
	}
}