package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class,timeout=20)
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO md;
	@Override
	public void removeMenu(Integer menuid) {
		// TODO Auto-generated method stub
		md.deleteMenu(menuid);
	}

	@Override
	public Integer insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		md.updateMenu(menu);
		return menu.getMenuid();
	}

	@Override
	public void modifyMenu(Menu menu) {
		// TODO Auto-generated method stub
		md.updateMenu(menu);
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<Menu> findByParentId(Integer parent_id) {
		// TODO Auto-generated method stub
		List<Menu> list=null;
		list=md.queryByParentId(parent_id);
		return list;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> list=null;
		list=md.queryAllMenu();
		return list;
	}

}
