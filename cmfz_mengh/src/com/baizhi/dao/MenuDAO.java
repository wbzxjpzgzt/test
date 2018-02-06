package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Menu;

public interface MenuDAO {
	void deleteMenu(Integer menuid);
	Integer addMenu(Menu menu);
	void updateMenu(Menu menu);
	List<Menu> queryByParentId(Integer parent_id);
	List<Menu> queryAllMenu();
	
}
