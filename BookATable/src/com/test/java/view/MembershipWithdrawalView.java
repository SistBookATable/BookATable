package com.test.java.view;

import java.util.Scanner;

public class MembershipWithdrawalView {
	
	public void showdrawalLogo() {
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                         회원 탈퇴                       <");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}
	
	public void inputInfo() {
		System.out.println("====================================================================");
		System.out.println();
		System.out.println("-                    회원탈퇴를 위해 비밀번호를 입력해주세요                   -");
		System.out.println();
		System.out.println("====================================================================");
	}
	
	public void inputPw() {
//		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 입력: ");
//		String inputPassword = sc.nextLine();
//		return inputPassword;
	}
	
	public void withDrawal() {
		System.out.println("회원탈퇴가 완료되었습니다.");
	}
	
	public void noneWithDrawal() {
		System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
	}
	
	public void backPage() {
		System.out.println("┌─────────────────────────────────────┐");
		System.out.println("|     이전 화면으로 돌아가시겠습니까?(Y/N) <");
		System.out.println("└─────────────────────────────────────┘");
		System.out.print("■ 입력 :\t■");
	}
	
	public String get() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();	//**
		
		return input;
	}
	
}
