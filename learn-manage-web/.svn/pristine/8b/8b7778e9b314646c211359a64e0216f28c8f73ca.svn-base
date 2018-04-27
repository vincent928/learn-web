package com.learn.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.manage.service.UserService;
import com.learn.manage.util.CookieUtils;
import com.learn.manage.util.LearnResult;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public LearnResult userLogin(String username,String password,String type,
			HttpServletResponse response,HttpServletRequest request) {
		LearnResult result = userService.userLogin(username, password, type);
		//登录成功后写cookie
				if(result.getStatus() == 200) {
					//把token写入cookie
					CookieUtils.setCookie(request, response, "TOKEN", result.getData().toString());
				}
		return result;
	}
}
