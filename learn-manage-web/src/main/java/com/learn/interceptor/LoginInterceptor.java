package com.learn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.learn.manage.pojo.LTeacher;
import com.learn.manage.service.TeacherService;
import com.learn.manage.util.CookieUtils;
import com.learn.manage.util.LearnResult;



/**
 * 判断教师是否登录的拦截器
 * <p>Title:LoginInterceptor</p>
 * <p>Description:</p>
 * @author sky
 * @version V1.0
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private TeacherService teacherService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//执行handler(方法)之前，先执行此方法
		//1.从cookie中取token信息
		String token = CookieUtils.getCookieValue(request, "TOKEN");
		//2.如果取不到token，跳转到sso的登录页面，需要把当前请求的url作为参数传递给sso，sso登录成功之后跳转回请求的页面
		if (StringUtils.isBlank(token)) {
			//跳转到登录页面
			response.sendRedirect("http://localhost:8082/page/login");
			//拦截
			return false;
		}
		//3.取到token，调用sso系统的服务判断用户是否登录
		LearnResult result = teacherService.getTeacherByToken(token);
		//4.如果用户未登录,即没取到用户信息，跳转到sso的登录页面
		if (result.getStatus()!=200) {
			response.sendRedirect("http://localhost:8082/page/login");
			return false;
		}
		//5.如果取到用户信息,则放行
		//把用户信息放到request中
		LTeacher lTeacher=(LTeacher)result.getData();
		if(lTeacher.gettName()==null || lTeacher.gettName()=="") {
			response.sendRedirect("http://localhost:8082/page/login");
			return false;
		}
		request.setAttribute("teacher", lTeacher);
		//返回值true:放行 返回false:拦截
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//handler执行之后,modelAndView返回之前
		//应用场景从modelandview出发，将公用的模型数据(比如菜单的导航)传到视图，也可以统一制定视图
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//modelAndView返回之后,异常处理
		
	}

	
}
