package com.baizhi.controller.app;

import java.util.Map;

public interface CodeService {

	public void sendCode(String phone);
	
	public Map<String,String> checkCode(String phone,String code);
	
}

