package com.test.java.view;

import java.util.Scanner;
//테이블 삭제 화면 보여주는 class
public class RemoveTableView {
	//테이블 정원 입력 받는 메서드
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
    //삭제 확인 하는 메서드
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
    //삭제 개수 입력 받는 메서드
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
