package com.spring.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements I_UserService{

	@Override
	public boolean checkUser(String userName, String userPsw) {
		if (userName != null && userName.length() > 0 
				&& userPsw != null && userPsw.length() > 0) {
			return true;
		}else {
			throw new IllegalArgumentException("账号密码不能有一个为空");  
		}
	}
	
}
