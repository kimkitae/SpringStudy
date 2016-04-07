package com.test.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class sessioncheck  extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		try {
			//logininfo 세션값이 널일경우
			if(request.getSession().getAttribute("logininfo") == null ){
					//로그인페이지로 redirect
				System.out.println("세션 없음");
					response.sendRedirect("/controller/signin");	
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//널이 아니면 정상적으로 컨트롤러 호출
		System.out.println("세션 정상적");
		return true;
	}
}




