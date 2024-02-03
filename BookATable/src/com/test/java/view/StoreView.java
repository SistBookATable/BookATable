
package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Store;

public class StoreView {
	
	public void searchMenu() {
		System.out.println("1. 상호명");
		System.out.println("2. 메뉴명");
		System.out.println("0. 이전 화면");
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
		}
	}
	
	public static int get() {
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		//System.out.println("선택(번호) : ");
		
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
	
	public static String getmenuName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴명을 입력해주세요: ");
		String temp = sc.nextLine();
		return temp;
	}

	public void showSelectBox() {
		System.out.println("1. 별점 내림차순 정렬");
		System.out.println("2. 역으로부터 거리 오름차순");
		System.out.println("3. 리뷰 갯수 내림차순");
		System.out.println("0. 이전 화면");
		System.out.print("선택(번호) : ");
		
	}
}
