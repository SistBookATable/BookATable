package com.test.java.controller;

import com.test.java.model.UserInfo;
import com.test.java.view.UserInfoView;

public class UserInfoController {
	
	
	private UserInfoView userInfoView;
	private UserInfo userInfo;
	
	public UserInfoController(UserInfoView userInfoView,UserInfo userInfo) {
		this.userInfo=userInfo;
		this.userInfoView=userInfoView;
	}
	
	public void changePw(String pw) {
		
	}
	
	public void changePhoneNumber(String phoneNumber) {
			
		}
	
	public void changeAccount(String account) {
		
	}
	
	

}
