package com.test.java.view;

import java.util.Scanner;

// 메뉴 삭제 화면을 보여주는 class
public class MenuRemoveView {
    /**
     * 삭제할 메뉴 이름을 입력받는 메서드
     * 
     * @return 삭제할 메뉴 이름
     */
    public static String findMenuName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 어떤 메뉴를 삭제하시겠습니까? : ");
        return scan.nextLine();
    }

    /**
     * 삭제할 메뉴의 이름을 입력받는 메서드
     * 
     * @return 삭제할 메뉴의 이름
     */
    public static String getMenuName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 메뉴 이름 : ");
        return scan.nextLine();
    }

    /**
     * 삭제를 확인하는 입력을 받는 메서드
     * 
     * @return 삭제를 확인하는 입력값 ("y" 또는 "n")
     */
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
