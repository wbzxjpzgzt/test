package com.baizhi.test;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baizhi.service.ArticleServiceImpl;

public class TestAdvice {
	public static void main(String[] args) {
		//加载工厂
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Object as = (ArticleServiceImpl)context.getBean("articleServiceImpl");
		
	}
}
