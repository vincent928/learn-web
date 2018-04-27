package com.learn.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String toLogin() {
		return "redirect:/page/login";
	}
	
	@RequestMapping("/page/login")
	public String showIndex() {
		return "login";
	}
	@RequestMapping("/demo/{url}")
	public String showDemo(@PathVariable String url) {
		return url;
	}
	
	@RequestMapping("/teacher/{_URL}")
	public String showPage(@PathVariable String _URL) {
		return _URL;
	}
	
	@RequestMapping("/student/{_URL}")
	public String showStudent(@PathVariable String _URL) {
		return _URL;
	}
	
	
}
