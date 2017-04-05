package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.I_UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource 
	I_UserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginAction(String userName,String userPsw) {
		boolean checkOK = userService.checkUser(userName,userPsw);
		System.out.println("________________"+checkOK + "___________");
		return "/index.jsp";
	}
}
