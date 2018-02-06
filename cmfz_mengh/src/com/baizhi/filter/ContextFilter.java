package com.baizhi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ContextUtil;

public class ContextFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//将req,res 放入当前线程对象中
		ContextUtil.setRequest((HttpServletRequest)req);
		ContextUtil.setResponse((HttpServletResponse)res);
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
