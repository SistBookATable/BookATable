package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class BookmarkHistoryView {

	public static ArrayList<Store> storeList = new ArrayList<>();

	public static void showBookmarkHistory(String name, String storeName, String storeTelNumber, String MenuName) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 즐겨찾기		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		
		String header = String.format("%10s%10s%10s", "[상호명]","[전화번호]","[메뉴]");
		System.out.println(header);
		
		String body = String.format("%10s%10s%10s", storeName, storeTelNumber, MenuName);
		System.out.println(body);
		
	}

	public static void showSelectBox(){
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("■           1. 상세페이지 이동		   ■");
		System.out.println("■           2. 즐겨찾기 삭제		   ■");
		System.out.println("■           0. 이전 화면			   ■");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		
		System.out.print("선택(번호) : ");
	}

	public static int get() {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}

	


}
