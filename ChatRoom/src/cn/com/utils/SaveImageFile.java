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
	 * ����ͼƬ
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
		//����ת��request
		MultipartHttpServletRequest rm=(MultipartHttpServletRequest) request;
		//����ļ�
		CommonsMultipartFile cfile=(CommonsMultipartFile) rm.getFile("imageUrl");
		//����ļ����ֽ�����
		byte[] bf=cfile.getBytes();
		String filename="";
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		filename=format.format(new Date());
		Random random=new Random();
		for(int i=0;i<3;i++){
			filename=filename+random.nextInt(9);
		}
		//���ԭʼ�ļ���
		String orignFilename=cfile.getOriginalFilename();
		String suffix=orignFilename.substring(orignFilename.lastIndexOf("."));
		//�����Ŀ�Ĳ���·��
		String path=request.getSession().getServletContext().getRealPath("/");
		//ȷ���ļ������׺��
		user.setImageUrl(filename+suffix);
		//�����ļ��������
		OutputStream out=new FileOutputStream(new File(path+"/upload/"+filename+suffix));
		out.write(bf);
		out.flush();
		out.close();
	}
}
