package com.test.java.view;

import java.util.Scanner;

public class RemoveTableView {
	
	public static int findTableCapacity() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("1. 어떤 크기의 테이블을 삭제하시겠습니까? : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                validInput = true;
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
    
    public static int removeCheck() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("2. 전체 삭제를 원하면 1을, 아니면 2를 입력하세요 : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                if (temp == 1 || temp == 2) {
                    validInput = true;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
    
    public static int getRemoveTableNum() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("3. 몇 개를 삭제하시겠습니까? : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                validInput = true;
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }

}
