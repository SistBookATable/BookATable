package com.test.java.view;

import java.util.Scanner;

import com.test.java.model.Bookmark;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class MoveStorePageView {
	
	
	
	public static String getStoreName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";

		while (true) {
			System.out.print("상세페이지 보기를 원하는 상호명을 입력해주세요: ");
			tmp = scan.nextLine();
			
			break;
		}
		return tmp;
	}
	
	
	public void showStorePage(Store store) {
		System.out.println();
		System.out.println(); 
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.printf("				%s			 \n", store.getStoreName()); 
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.printf("■           전화번호 :	%s	   		\n", store.getStoreTelNumber());
		System.out.printf("■           주소 :		%s   		\n", store.getAddress());
		System.out.printf("■           음식분류 :	%s	   		\n", store.getMenuCategory());
		System.out.printf("■           메뉴 :		%s  		\n", store.getmenuName());
		System.out.printf("■           테이블 :	%s	   		\n", store.getTablecount());
//		System.out.printf("■           평점 :		%1.f	   		\n", store.getScore());
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		

   
			}
			
		}
		

