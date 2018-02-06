package com.baizhi.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Menu;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPoi {


	@Autowired
	private MenuDAO ad;
	@Test
	public void testpoi() throws Exception{
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet = workbook.createSheet();
		
		
		//HSSFCell cell = row.createCell(0);
		//cell.setCellValue("哈哈");
		Field[] fields = Menu.class.getDeclaredFields();
		List<Menu> list = ad.queryAllMenu();
		for (int i = 0; i <list.size(); i++) {
			HSSFRow rows = sheet.createRow(i+1);
			for (int j = 0; j < fields.length; i++) {
				HSSFCell cells = rows.createCell(j);
				fields[j].setAccessible(true);
				System.out.println(fields[j].get(list.get(i)));
				cells.setCellValue(fields[j].get(list.get(i)).toString());
			}
		}
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				
				fields[i].setAccessible(true);
				cell.setCellValue(fields[i].getName());
				
				//System.out.println(fields[i].getName());
			}
		
		File file=new File("f://hilo.xls");
		workbook.write(new FileOutputStream(file));
	}
}
