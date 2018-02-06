package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Menu;

public interface MenuService {
	void removeMenu(Integer menuid);
	Integer insertMenu(Menu menu);
	void modifyMenu(Menu menu);
	List<Menu> findByParentId(Integer parent_id);
	List<Menu> findAllMenu();
}
