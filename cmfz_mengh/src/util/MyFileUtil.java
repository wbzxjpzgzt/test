package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUtil {
	private static Logger log = Logger.getLogger(MyFileUtil.class);

	@Test
	public void getFile() {
		List<File> file = getFile("D:\\apache-tomcat-6.0.41\\webapps\\a");
		System.out.println("+++++++++++++++++++");
		System.out.println(file.isEmpty());
		for (File f : file) {
			System.out.println("------------------------------------");
			System.out.println(f.getName());
		}
	}

	/**
	 * 上传 input �?file的name 上传位置的文件夹名字
	 */
	public static String upload(MultipartFile file, String foldName,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		if (file.isEmpty()) {
			try {
				throw new FileNotFoundException("请先添加要上传的图片");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 获得文件的原生名
			String filename = file.getOriginalFilename();
			log.info("文件原生名 "+ filename);
			String path = null;
			try {
				// 获得服务器webapps下upload文件夹路�?
				String realPath = req.getSession().getServletContext()
						.getRealPath("/");
				// 获得项目�?
				String appName = req.getContextPath().substring(1);
				// 获得webapps路径
				String webapp = realPath.substring(0,
						realPath.lastIndexOf(appName));
				// 创建upload文件�?
				File file2 = new File(webapp + File.separator + foldName);
				if (!file2.exists()) {
					// 如果不存在，创建目录及子目录
					file2.mkdirs();
				}
				// 文件名处�?时间�?UUID+原声�?
				String extension = FilenameUtils.getExtension(file
						.getOriginalFilename());
				String newName = new SimpleDateFormat("yyyyMMddHHmmssSSS")
						.format(new Date())
						+ UUID.randomUUID().toString().replace("-", "")
						+ "."
						+ extension;

				log.info("文件后缀名：" + extension);
				/**
				 * 上传 file2 �?��路径 webapps下的upload文件�?newName 处理后的文件�?
				 */
				file.transferTo(new File(file2, newName));

				// 将图片的路径存库
				String url = req.getScheme() + "://" + req.getServerName()
						+ ":" + req.getServerPort() + "/" + foldName + "/"
						+ newName;
				return url;

			} catch (Exception e) {
				throw new RuntimeException("上传失败[" + e.getMessage() + "]");
			}
		}
		return null;
	}

	/**
	 * 下载 参数 文件路径 文件类型 文件名字
	 */
	public static void download(File file, String name, String type,
			HttpServletResponse res) {
		OutputStream os = null;
		try {
			// 准备输出�?
			os = res.getOutputStream();
			// 设置下载响应类型
			res.setContentType(type);
			// 设置响应头
			res.setHeader("content-disposition", "attachment; fileName="
					+ new String((name).getBytes(), "ISO-8859-1"));
			//
			// int len = 0;
			// byte[] b = new byte[(int) file4.length()];
			// //
			// while(true){
			// len = fis.read();
			// if(len == -1)break;
			// os.write(b, 0, len);
			// }
			FileUtils.copyFile(file, os);// 下载
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除某个文件夹下及子文件夹下的所有文�?
	 * 

	 */
	public static void deleteDir(String path) {
		File file = new File(path);
		// log.info("-----"+file.getAbsolutePath());
		if (!file.isDirectory()) {
			// 如果是文件直接删�?
			file.delete();
		} else if (file.isDirectory()) {
			// 如果是目录，迭代删除
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				// log.info("文件�? + list[i]);
				File file2 = new File(path + File.separator + list[i]);
				if (!file2.isDirectory()) {
					file2.delete();
				} else if (file2.isDirectory()) {
					deleteDir(path + File.separator + list[i]);
				}
			}
		}
	}

	/**
	 * 获得文件夹下的所有文�?
	 */
	public static List<File> getFile(String path) {
		List<File> files = new ArrayList<File>();

		File file = new File(path);
		log.info("-----" + file.getAbsolutePath());
		if (!file.isDirectory()) {
			// 如果是文件直接删�?
			files.add(file);
		} else if (file.isDirectory()) {
			// 如果是目录，迭代删除
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				File file2 = new File(path + File.separator + list[i]);
				if (!file2.isDirectory()) {
					files.add(file2);
				} else if (file2.isDirectory()) {
					getFile(path + File.separator + list[i]);
				}
			}
		}
		return files;
	}
}
