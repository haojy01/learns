package com.helios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = { "index.html", "/" })
	public ModelAndView toIndex() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	public static void main(String[] args) {
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
	}
}
