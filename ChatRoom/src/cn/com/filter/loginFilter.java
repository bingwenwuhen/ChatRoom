package cn.com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.domain.User;
import cn.com.utils.SessionUtils;

public class loginFilter implements Filter {
	
	private List list;
	
	public void init(FilterConfig config) throws ServletException {
		list=new ArrayList();
		list.add("/user/toLogin.do");
		list.add("/user/toRegister.do");
		list.add("/user/login.do");
		list.add("/user/register.do");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String path=req.getServletPath();
		System.out.println(path);
		if(list!=null&&list.contains(path)){
			chain.doFilter(req, res);
			return;
		}
		User user=SessionUtils.getSysUserFromSession(req);
		if(user!=null){
			chain.doFilter(req, res);
		}else{
			res.sendRedirect(req.getContextPath());
		}
	}

	public void destroy() {
		
	}
}
