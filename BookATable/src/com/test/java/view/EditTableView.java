package com.test.java.view;

import java.util.Scanner;

public class EditTableView {
	
	
	public static int getTableCapacity() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp=0;
	      System.out.print("1. 수정할 테이블 사이즈 (숫자) : ");
	      temp = scan.nextInt();
	      return temp;
	   }
	
	public static int getTableNum() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp=0;
	      System.out.print("2. 수정할 테이블 개수 (숫자) : ");
	      temp = scan.nextInt();
	      return temp;
	   }
}