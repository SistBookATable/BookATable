package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.UserInfo;

public class UserInfoView {

	public String inputPw(String pw) {
		Scanner scan=new Scanner(System.in);
		System.out.print("본인 확인 위한 비밀번호 입력 : ");
		return scan.nextLine();
	}
	
	public void show(UserInfo userInfo) {
		
		
		
	}
	
}
