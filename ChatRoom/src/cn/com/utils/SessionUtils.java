package cn.com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.com.domain.User;

public class SessionUtils {

	public static User getSysUserFromSession(HttpServletRequest request){
		HttpSession session=request.getSession();
		if(session==null){
			return null;
		}
		User user=(User) session.getAttribute("user");
		return user;
	}
}
