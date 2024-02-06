package com.test.java.view;

import java.util.Scanner;

public class RemoveTableView {
	
	public static int findTableCapacity() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp = 0;
	      System.out.print("1. 어떤 크기의 테이블을 삭제하시겠습니까? : ");
	      temp = scan.nextInt();
	      return temp;
	   }
	

	
	public static int removeCheck() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp=0;
	      System.out.print("2. 전체 삭제를 원하면 1을, 아니면 2를 입력하세요 : ");
	      temp = scan.nextInt();
	      return temp;
	   }
	
	public static int getRemoveTableNum() {
	      
	      Scanner scan = new Scanner(System.in);
	      int temp=0;
	      System.out.print("3. 몇 개를 삭제하시겠습니까? : ");
	      temp = scan.nextInt();
	      return temp;
	   }

}
