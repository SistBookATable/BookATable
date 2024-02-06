package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Menu;
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
   
   public void title() {
	   System.out.println("=================================================================================================================");
	   System.out.println("\t\t\t\t\t\t음식점 리스트\t\t\t\t\t\t\t\t\t\t");
	   System.out.println("=================================================================================================================");
   }
   
   public void showMenu(Menu menu) {
      System.out.println("=================================================================================================================");
      System.out.println("\t\t\t\t\t\t메뉴 리스트\t\t\t\t\t\t\t\t\t\t");
      System.out.println("=================================================================================================================");
      System.out.printf("\t사업자번호\t\t메뉴\t\t가격\n");
      System.out.printf("%18s\t%s\t%d\n", menu.getLicenseNumber(), menu.getMenuName(), menu.getPrice());
   }
   public void show(Store store, int index) {
      System.out.println("=================================================================================================================");
      System.out.println("\t\t\t\t\t\t음식점 리스트\t\t\t\t\t\t\t\t\t\t");
      System.out.println("=================================================================================================================");
      System.out.printf("No\t사업자번호\t\t\t상호명\t\t전화번호\t\t음식분류\t\t주소\t\t\t평점\t역과의 거리\t리뷰 갯수\n");
      System.out.printf("%d%15s%20s\t%12s%8s\t%5s\t%3.1f\t%5d\n",index ,store.getLicenseNumber(), store.getStoreName(), store.getStoreTelNumber(), store.getMenuCategory(), store.getAddress(), store.getScore(), store.getDistanceFrom());
      System.out.println();
      
   }
   
   public boolean showMenu(ArrayList<Menu> menuList) {

      boolean success = true;

      if(menuList.size() == 0) {
         System.out.println("음식점이 없습니다.");
         success = false;
      } else {
         for(Menu menu : menuList) {
            showMenu(menu);
         }
//         return success;
      }
      View.pause();
      return success;
   }

   public boolean show(ArrayList<Store> storeList) {

      boolean success = true;

      if(storeList.size() == 0) {
         System.out.println("음식점이 없습니다.");
         success = false;
      }
      else {
    	  for (int i=0; i<storeList.size(); i++) {
              show(storeList.get(i), i+1);
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

   public String getStoreName() {
      Scanner sc = new Scanner(System.in);
      System.out.print("상호명을 입력해주세요: ");
      String temp = sc.nextLine();
      return temp;
   }

   public String getmenuName() {
      Scanner sc = new Scanner(System.in);
      System.out.println("메뉴명을 입력해주세요: ");
      String temp = sc.nextLine();
      return temp;
   }

   public void showSelectBox() {
      System.out.println("1. 별점 내림차순 정렬");
      System.out.println("2. 역으로부터 거리 오름차순");
      System.out.println("3. 리뷰 갯수 내림차순");
      System.out.println("4. 상세페이지");
      System.out.println("0. 이전 화면");
      System.out.print("선택(번호) : ");
   }
   
   public void bookmarkNreservation() {
	   System.out.println("1. 예약하기");
	   System.out.println("2. 즐겨찾기 등록");
	   System.out.println("3. 즐겨찾기 삭제");
	   System.out.println("4. 즐겨찾기 조회");
	   System.out.println("0. 이전 화면");
	   System.out.print("선택(번호) : ");
   }
   
   public void reservationNumber() {
	   System.out.println("예약할 음식점 선택(번호): ");
   }
   
//   public int reservationNumber() {
//	   Scanner sc = new Scanner(System.in);
//	   System.out.println("예약할 음식점 선택(번호): ");
//	   int choice = sc.nextInt();
//	   return choice;
//   }
}