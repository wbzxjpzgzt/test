package util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.baizhi.annotation.Comment;



public class PoiUtil {
	//导出
	public static Workbook exportExcel(List data, Class clasz)
			throws IllegalArgumentException, IllegalAccessException,
			FileNotFoundException, IOException, Exception {
		// 創建Excel表格對象
		HSSFWorkbook wk = new HSSFWorkbook();

		HSSFSheet sheet = wk.createSheet();

		// 表头
		HSSFRow row0 = sheet.createRow(0);
		//获得当前属性的所有属性
		Field[] fields = clasz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Comment comment=fields[i].getAnnotation(Comment.class);
			HSSFCell cell = row0.createCell(i);
			if(comment!=null){
				cell.setCellValue(fields[i].getName());
			}
			
		}

		// 填充表格数据
		for (int i = 1; i < data.size() + 1; i++) {
			HSSFRow row = sheet.createRow(i);
			Object obj = data.get(i - 1);
			for (int j = 0; j < fields.length; j++) {
				
				//Comment comment=fields[j].getAnnotation(Comment.class);
				Field field = fields[j];
				field.setAccessible(true);
				Comment comment=field.getAnnotation(Comment.class);
				if(comment!=null){
					HSSFCell cell = row.createCell(j);
					//判断 如果类型是基本或String类型，则直接通过属性对象的方法 获得当前对象的此属性的值 赋值给单元格
					if(field.getType()==Date.class||field.getType()==String.class||field.getType()==Integer.class){
						Object object=field.get(obj);
						cell.setCellValue(object.toString());
					}else{
						//否则调用对象属性的getName()方法
                        //获得对象属性的无参的getName()方法
                        Method method = field.getType().getDeclaredMethod("getName");
                        //调用当前属性对象的getName()方法
                        Object o = method.invoke(field.get(obj));
                        //将返回值写入单元格
                        cell.setCellValue(o.toString());
						
					}
				}
				//Object object = field.get(obj);
				//Object object = field.get(obj);
			}
		}

		return wk;
	}
	//导入
	public static List importExcel(InputStream in, Class clasz)
			throws IOException, InstantiationException, IllegalAccessException {
		HSSFWorkbook wk = new HSSFWorkbook(in);

		HSSFSheet sheet = wk.getSheetAt(0);
		Field[] fields = clasz.getDeclaredFields();

		ArrayList<Object> list = new ArrayList<Object>();
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			HSSFRow row = sheet.getRow(i);
			Object instance = clasz.newInstance();
			for (int j = 0; j < fields.length; j++) {
				HSSFCell cell = row.getCell(j);
				Field field = fields[j];
				field.setAccessible(true);
				if (field.getType() == Integer.class) {

					field.set(instance, new Integer(cell.toString()));
				} else {
					field.set(instance, cell.toString());
				}
			}
			list.add(instance);
		}
		wk.close();
		return list;

	}


}