
package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Store;

public class StoreView {
	
	public void searchMenu() {
		System.out.println("1. 상호명");
		System.out.println("2. 메뉴명");
		System.out.println("0. 이전 화면");
		StoreView.get();
	}
	
	public String getInput(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt + ": ");
		return sc.nextLine();
	}
	
	public void show(Store store) {
		
	}
	
	public void show(ArrayList<Store> storeList) {
		for(Store store : storeList) {
			show(store);
			System.out.println("----------------");
		}
	}
	
	public static int get() {
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		System.out.println("선택(번호) : ");
		
		temp = sc.nextInt();
		sc.nextLine();
		return temp;
		
	}

	public static String getStoreName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상호명을 입력해주세요: ");
		String temp = sc.nextLine();
		return temp;
	}
}
