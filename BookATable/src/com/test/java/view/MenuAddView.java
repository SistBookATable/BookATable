package com.test.java.view;

import java.util.Scanner;
//메뉴 등록 화면 보여주는 class
public class MenuAddView {
    public static String getMenuName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 메뉴 이름 : ");
        return scan.nextLine();
    }
    
    public static int getMenuPrice() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("2. 메뉴 가격 : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                if (temp >= 0) {
                    validInput = true;
                } else {
                    System.out.println("0 이상의 숫자를 입력하세요.");
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
}
