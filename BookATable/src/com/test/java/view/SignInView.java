package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInView {

	public static ArrayList<String> getInput() {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> temp = new ArrayList<>();

		System.out.print("이름 : ");
		temp.add(scan.nextLine());
		System.out.print("주민번호 : ");
		temp.add(scan.nextLine());
		System.out.print("전화번호 : ");
		temp.add(scan.nextLine());
		System.out.print("계좌번호 : ");
		temp.add(scan.nextLine());
		System.out.print("ID : ");
		temp.add(scan.nextLine());
		System.out.print("PW : ");
		temp.add(scan.nextLine());
		
		
		return temp;
	}

}
