package com.test.java.view;

import java.util.Scanner;

public class View {
	public static void pause() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
		System.out.println();
		
	}
	public static int getSelectType() {
		try {
			Scanner scan = new Scanner(System.in);
			int tmp = scan.nextInt();
			scan.nextLine();
			return tmp;
		} catch (Exception e) {
			return -1;
		}
	}
}
