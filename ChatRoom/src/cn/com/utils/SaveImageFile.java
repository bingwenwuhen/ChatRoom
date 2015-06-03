package cn.com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.com.domain.User;

public class SaveImageFile {

	/**
	 * 保存图片
	 * @param request
	 * @param user
	 * @throws Exception
	 */
	public static void save(HttpServletRequest request,User user) throws Exception{
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setStatus("1");
		user.setCreateDate((new Date()).toString());
		//首先转换request
		MultipartHttpServletRequest rm=(MultipartHttpServletRequest) request;
		//获得文件
		CommonsMultipartFile cfile=(CommonsMultipartFile) rm.getFile("imageUrl");
		//获得文件的字节数据
		byte[] bf=cfile.getBytes();
		String filename="";
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		filename=format.format(new Date());
		Random random=new Random();
		for(int i=0;i<3;i++){
			filename=filename+random.nextInt(9);
		}
		//获得原始文件名
		String orignFilename=cfile.getOriginalFilename();
		String suffix=orignFilename.substring(orignFilename.lastIndexOf("."));
		//获得项目的部署路径
		String path=request.getSession().getServletContext().getRealPath("/");
		//确定文件名与后缀名
		user.setImageUrl(filename+suffix);
		//定义文件的输出流
		OutputStream out=new FileOutputStream(new File(path+"/upload/"+filename+suffix));
		out.write(bf);
		out.flush();
		out.close();
	}
}
