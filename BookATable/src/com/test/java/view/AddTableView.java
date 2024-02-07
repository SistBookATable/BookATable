package com.test.java.view;

import java.util.Scanner;

public class AddTableView {
    
    public static int getTableCapacity() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("1. 테이블 사이즈 (숫자 1~10 사이) : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                if (temp >= 1 && temp <= 10) {
                    validInput = true;
                } else {
                    System.out.println("유효하지 않은 입력입니다. 다시 시도하세요.");
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
    
    public static int getTableNum() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("2. 테이블 개수 (정수) : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                if (temp >= 1) {
                    validInput = true;
                } else {
                    System.out.println("유효하지 않은 입력입니다. 다시 시도하세요.");
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
}