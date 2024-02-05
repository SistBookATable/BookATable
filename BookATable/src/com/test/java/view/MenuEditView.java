package com.test.java.view;

import java.util.Scanner;

public class MenuEditView {
	
	
	public static String findMenuName() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("1. 어떤 메뉴를 수정하시겠습니까? : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }
	
	public static String getMenuName() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("1. 메뉴 이름 : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }
	
	public static int getMenuPrice() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp=0;
	      System.out.print("2. 메뉴 가격 : ");
	      temp = scan.nextInt();
	      return temp;
	   }

<<<<<<< HEAD
}
=======
}
>>>>>>> f9ba0fb460eabfde7008cc9d6edc291ba70b23bc
