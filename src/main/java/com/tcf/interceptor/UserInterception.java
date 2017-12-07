package com.tcf.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tcf.entity.SmbmsUser;

public class UserInterception extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		HttpSession session = request.getSession();
		SmbmsUser user = (SmbmsUser) session.getAttribute("user");
		if(user == null && !checkInterceptor(url)){
			response.sendRedirect("error.jsp");
			return false;
		}
		return true;
	}
	public boolean checkInterceptor(String url){
		List<String> actionNames = new ArrayList<String>();
		actionNames.add("login");
		boolean flag = false;
		for(String actionName:actionNames){
			if(url.contains(actionName)){
				flag = true;
			}
		}
		return flag;
	}
	
}
