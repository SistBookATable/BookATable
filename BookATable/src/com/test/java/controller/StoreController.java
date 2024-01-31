package com.test.java.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.test.java.model.Store;
import com.test.java.view.StoreView;

public class StoreController {

	private ArrayList<Store> storeList = new ArrayList<>();

	public void run() {
		StoreView storeView = new StoreView();

		while(true) {
			storeView.searchMenu();

			int choice = StoreView.get();

			switch(choice) {
			case 0:
				System.out.println("이전 화면으로 이동합니다.");
				break;
			case 1:
				try {
					String storeName = StoreView.getStoreName();
					searchStoreName(storeName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					
				} catch (Exception e) {
					System.out.println("StoreController.run");
					e.printStackTrace();
				}
				
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}
		}
	}
	private void searchStoreName(String keyword) throws IOException {

		
		for(Store store : storeList) {
			if(store.getStoreName().equals(keyword)) {
				System.out.println(store);
			}
		}
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\wonhyuk\\BookATable\\dat\\resturant.txt"));

		System.out.println("상호명을 입력해주세요: ");
		String storeName = reader.readLine();

		String line = "";
		while((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
//			if (storeName.equals(parts[0])) {
//				
//				System.out.println("상호명: " + parts[0]);
//				System.out.println("음식분류: " + parts[1]);
//				System.out.println("주소: " + parts[2]);
//				System.out.println("테이블: " + Integer.parseInt(parts[3]));
//				System.out.println("평균평점: " + Double.parseDouble(parts[4]));
//				System.out.println("즐겨찾기 여부: " + Boolean.parseBoolean(parts[5]));
//				return; 
//			}

		}
		System.out.println("일치하는 음식점을 찾을 수 없습니다.");

	}

	private void searchMenuName() {
		
		
	}


}