package com.test.java.view;

import java.util.Scanner;

/**
 * 운영 정보 관리 선택 화면을 출력하는 클래스
 */
public class OperationalInfoManagementView {
    
    /**
     * 선택 옵션을 보여주는 메서드
     */
    public void showChoice() {
        System.out.println("==========================================================================================");
        System.out.println();
        System.out.println("■            1. 운영시간 관리         \t■");
        System.out.println("■            2. 메뉴 관리           \t■");
        System.out.println("■            3. 테이블 관리          \t■");
        System.out.println("■            0. 이전 화면           \t■");
        System.out.println();
        System.out.println("==========================================================================================");
        System.out.println();
        System.out.print("선택(번호) : ");
    }
    
    /**
     * 사용자의 선택을 입력받는 메서드
     * 
     * @return 사용자가 선택한 번호
     */
    public static int get() {
        Scanner scan = new Scanner(System.in);
        int temp = scan.nextInt();
        scan.nextLine();
        
        return temp;
    }

}
