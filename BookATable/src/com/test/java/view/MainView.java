package com.test.java.view;

import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;

public class MainView {

	/**
	 * 로고 출력
	 */
	public static void logo() {
		System.out.println();
		// TODO 로고 출력화면 만들기 
		try {
		    String asciiArt;
			asciiArt = FigletFont.convertOneLine("BookATable");
		    System.out.println(asciiArt);
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 선택화면 출력
	 * 
	 */
	public static void show() {
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("┌──────────────┐\t┌──────────────┐\t┌───────────────┐\t┌───────────────┐");
		System.out.println("|  1. 회원 가입   |\t|   2. 로그인    |\t|   3. 계정 찾기   |\t|  4. 음식점 검색  |");
		System.out.println("└──────────────┘\t└──────────────┘\t└───────────────┘\t└───────────────┘");
		System.out.println();
	}
	
	public static void adminPage() {
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("┌──────────────┐\t┌──────────────┐\t┌───────────────┐\t┌───────────────┐");
		System.out.println("|  1. 회원 관리   |\t| 2. 문의사항관리  |\t| 3. 리뷰삭제요청  |\t|   4. 로그아웃   |");
		System.out.println("└──────────────┘\t└──────────────┘\t└───────────────┘\t└───────────────┘");
		System.out.println();
	}

	public static void userPage() {
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("┌──────────────┐\t┌──────────────┐\t┌───────────────┐\t┌───────────────┐");
		System.out.println("|  1. My page   |\t|  2. 로그아웃    |\t|   3. 문의 사항   |\t|  4. 음식점 검색  |");
		System.out.println("└──────────────┘\t└──────────────┘\t└───────────────┘\t└───────────────┘");
		System.out.println();
		
	}

	public static void businessUserPage() {
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("┌──────────────┐\t┌──────────────┐\t┌───────────────┐\t┌───────────────┐");
		System.out.println("|  1. My page   |\t|  2. 로그아웃    |\t|   3. 문의 사항   |\t|  4. 음식점 검색  |");
		System.out.println("└──────────────┘\t└──────────────┘\t└───────────────┘\t└───────────────┘");
		System.out.println();
		
	}
	

	/**
	 * 선택한 인덱스 반환
	 */
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = 0;
		System.out.print("선택(번호): ");
		
		temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}


	

}
