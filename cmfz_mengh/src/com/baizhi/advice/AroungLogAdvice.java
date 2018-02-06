package com.baizhi.advice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import util.ContextUtil;

import com.baizhi.annotation.Detail;
import com.baizhi.annotation.Type;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;

import com.baizhi.service.LogService;


public class AroungLogAdvice implements MethodInterceptor{
	@Autowired
	private LogService ls;
	public LogService getLs() {
		return ls;
	}
	public void setLs(LogService ls) {
		this.ls = ls;
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		HttpSession session  = ContextUtil.getSession();
		//System.out.println("你好啊");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null){
			mi.proceed();
			admin = (Admin) session.getAttribute("admin");
			if(admin==null){
				return mi.proceed();
			}
		}
		System.out.println(admin.getAdminname());
		StringBuilder sb=new StringBuilder(admin.getAdminname());
		sb.append("在");
		//什么时间
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		sb.append(format);
		/*
		 * 干什么事
		 * 获得对应的方法名
		 * 
		 * 用户：licy在xxx进行了登录 
		 * 
		 * */
		 //切入点获得方法的签名  主要为了获得当前方法对象
		
		 //通过注解反射获得方法
		 Method method = mi.getMethod();
		 
		 
		 System.out.println(method.getName());
		 //查询所有的用户
		 Detail detail = method.getAnnotation(Detail.class);
		 System.out.println("detail"+detail);
		 //获得时间的类型
		 Type type = method.getAnnotation(Type.class);
		 System.out.println("type"+type);
		 
		 
		 
		 //用户:licy在XX中查询了所有用户操作
		 if(type==null||detail==null){
			 try {
				//放行方法
				return mi.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else{
			 
			 //拼接
			 sb.append(detail.toString()).append("的操作");
			 Log log = new Log(UUID.randomUUID().toString(),admin.getAdminname(),new Date(),detail.value(),type.value());
			 //存入数据库
			 //ls.logAppend(log);
			 
		 }
		 System.out.println(sb.toString());
		 try {
				return mi.proceed();
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("切面异常");
			}
		 
	}
}
