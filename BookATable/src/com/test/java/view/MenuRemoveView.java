package com.test.java.view;

import java.util.Scanner;

public class MenuRemoveView {
	
	public static String findMenuName() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("1. 어떤 메뉴를 삭제하시겠습니까? : ");
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
	
	public static String removeCheck() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp="";
	      System.out.print("2. 삭제하시겠습니까? (y/n) : ");
	      tmp = scan.nextLine();
	      return tmp;
	   }

}
