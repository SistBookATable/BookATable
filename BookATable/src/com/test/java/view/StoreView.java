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
		System.out.println("\t\t\t\t\t\t\t\t음식점 리스트\t\t\t\t\t\t\t\t\t\t\t\t");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.printf("사업자번호\t\t\t상호명\t\t\t전화번호\t\t\t음식분류\t\t\t주소\t\t\t평점\t\t\t\n");
		System.out.printf("%5d%5d%5d%5d%5d%5d\n",store.getLicenseNumber(), store.getStoreName(), store.getStoreTelNumber(), store.getMenuCategory(), store.getAddress(), store.getScore(), store.getDistanceFrom());
		
	}

	public boolean show(ArrayList<Store> storeList) {

		boolean success = true;

		if(storeList.size() == 0) {
			System.out.println("찾으시는 음식점이 없음");
			success = false;
		}
		else {
			for(Store store : storeList) {
				show(store);
			}
		}

		View.pause();
		return success;
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