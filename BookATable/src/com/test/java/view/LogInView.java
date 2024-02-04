package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class LogInView {

	public static ArrayList<String> getInput() {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> tmp = new ArrayList<String>();
		
		System.out.print("ID: ");
		tmp.add(scan.nextLine());
		
		
		System.out.print("PW: ");
		tmp.add(scan.nextLine());
		
		return tmp;
	}

	public static void showAgain() {
		View.pause();
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("원하시는 항목을 선택하여주세요.");
		System.out.println("1. 다시 로그인");
		System.out.println("2. 메인 페이지");
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("선택(번호): ");
		System.out.println();
	}
	
	public static int get() {
		Scanner scan = new Scanner(System.in);
		int answer = scan.nextInt();
		scan.nextLine();
		return answer;
	}


	

	
	
}
