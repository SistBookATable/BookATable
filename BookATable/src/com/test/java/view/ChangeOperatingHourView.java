package com.test.java.view;

import java.util.Scanner;

// 운영 시간 변경 화면을 보여주는 class
public class ChangeOperatingHourView {

    /**
     * 수정할 요일을 입력받는 메서드
     * 
     * @return 입력받은 요일
     */
    public static String getDay() {
        Scanner scan = new Scanner(System.in);
        System.out.print("1. 수정할 요일 : ");
        String day = scan.nextLine();
        scan.close();
        return day;
    }

    /**
     * 영업 시작 시각을 입력받는 메서드
     * 
     * @return 입력받은 영업 시작 시각
     */
    public static String getOpen() {
        Scanner scan = new Scanner(System.in);
        System.out.print("2. 영업 시작 시각 등록(0000) : ");
        String open = scan.nextLine();
        scan.close();
        return open;
    }

    /**
     * 영업 종료 시각을 입력받는 메서드
     * 
     * @return 입력받은 영업 종료 시각
     */
    public static String getClose() {
        Scanner scan = new Scanner(System.in);
        System.out.print("3. 영업 종료 시각 등록(0000) : ");
        String close = scan.nextLine();
        scan.close();
        return close;
    }
}
