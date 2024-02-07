package com.test.java.view;

import java.util.Scanner;

public class MenuRemoveView {

    public static String findMenuName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 어떤 메뉴를 삭제하시겠습니까? : ");
        return scan.nextLine();
    }

    public static String getMenuName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 메뉴 이름 : ");
        return scan.nextLine();
    }

    public static String removeCheck() {
        Scanner scan = new Scanner(System.in);
        String tmp = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("2. 삭제하시겠습니까? (y/n) : ");
            tmp = scan.nextLine();
            if (tmp.equals("y") || tmp.equals("n")) {
                validInput = true;
            } else {
                System.out.println("잘못된 입력입니다. 'y' 또는 'n'을 입력하세요.");
            }
        }
        return tmp;
    }
}
