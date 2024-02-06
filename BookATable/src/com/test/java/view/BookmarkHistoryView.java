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
	
	public void showBookmarkHistory(String name) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 즐겨찾기		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		
		
		String header = String.format("%10s%10s%10s", "[상호명]","[전화번호]","[메뉴]");
		System.out.println(header);
		
		if(Data.bookmarkList.isEmpty()) {
			System.out.println();
			System.out.println("즐겨찾기 내역이 없습니다.");
			System.out.println();
			View.pause();
		} else {
			for(Bookmark b : Data.bookmarkList) {
				Store s = findStoreByLicenseNumber(b.getLicenseNumber());
				String tmp = String.format("%10s%15s%15s",
							 s.getStoreName(),
							 s.getStoreTelNumber(),
							 s.getmenuName());
							System.out.println(tmp);
		
   
        }
			
    }
		
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

		

	private Store findStoreByLicenseNumber(String licenseNumber) {
		for (Store store : storeList) {
			if (store.getLicenseNumber().equals(licenseNumber)) {
				return store;
			}
		}
		return null;
	}
	
		
	
	public static int get() {
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		scan.nextLine();
		return temp;
	}
}

	
