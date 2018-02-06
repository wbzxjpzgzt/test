package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.baizhi.entity.PageLog;
import com.baizhi.service.LogService;
import com.baizhi.service.LogServiceImpl;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	private LogService lsi;
	
	@RequestMapping("/printlog")
	@ResponseBody
	public PageLog printLog(Integer page,Integer rows){
		PageLog pagelog = lsi.logByPage(page, rows);
		return pagelog;
	}

}
