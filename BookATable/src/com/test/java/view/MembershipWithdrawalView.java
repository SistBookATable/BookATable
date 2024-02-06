package com.test.java.view;

import java.util.Scanner;

public class MembershipWithdrawalView {
	
	public void showdrawalLogo() {
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                         회원 탈퇴                       <");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	
	public void inputInfo() {
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("-                    회원탈퇴를 위해 비밀번호를 입력해주세요:                   -");
		System.out.println();
		System.out.println("==========================================================================================");
	}
	
	public void inputPw() {
		System.out.println("비밀번호 입력: ");
	}
	
	public String get() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();	//**
		
		return input;
	}
	
}
