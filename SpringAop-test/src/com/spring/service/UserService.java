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
			throw new IllegalArgumentException("�˺����벻����һ��Ϊ��");  
		}
	}
	
}
