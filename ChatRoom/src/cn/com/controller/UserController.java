package cn.com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.MultipartStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.com.domain.User;
import cn.com.service.IUserService;
import cn.com.utils.SaveImageFile;
import cn.com.utils.SessionUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/register.do")
	public String register(HttpServletRequest request) throws Exception{
		User user=new User();
		SaveImageFile.save(request, user);
		request.getSession().setAttribute("user", user);
		this.userService.saveUser(user);
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		User user=SessionUtils.getSysUserFromSession(request);
		this.userService.loginout(user);
		request.getSession().removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("/toRegister.do")
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping("/login.do")
	public String login(User user,HttpServletRequest request){
		 User User=this.userService.checkUser(user);
		if(user!=null){
			List<User> list=this.userService.getAllOnLineUser();
			request.setAttribute("OnlineUsers", list);
			request.getSession().setAttribute("user", User);
			request.setAttribute("User", User);
			System.out.println(User.getImageUrl());
			return "/user/main";
		}else{
			return "index";
		}
	}
	
	@RequestMapping("/getOnLineUser.do")
	public @ResponseBody List<User> getData(){
		List<User> list=this.userService.getAllOnLineUser();
		String data="";
		return list;
	}
}
