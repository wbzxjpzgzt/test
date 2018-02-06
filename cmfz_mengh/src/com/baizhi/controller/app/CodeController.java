package com.baizhi.controller.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/identify")
@Controller
public class CodeController {
	
	@Autowired
	private CodeService codeService;
	
	@RequestMapping("/obtain")
	public @ResponseBody void getCodes(String phone){
		phone="15993560503";
		codeService.sendCode(phone);
	}
	
	@RequestMapping("/check")
	public @ResponseBody Map<String,String> checkCode(String phone,String code){
		Map<String, String> map = codeService.checkCode(phone, code);
		return map;
	}
}
