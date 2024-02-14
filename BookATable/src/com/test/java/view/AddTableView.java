package com.test.java.view;

import java.util.Scanner;

/**
 * 테이블 등록 화면을 보여주는 클래스입니다.
 */
//테이블 등록 화면을 보여주는 class
public class AddTableView {
	
	/**
     * 테이블 정원을 입력받는 메서드입니다.
     *
     * @return 입력받은 테이블 정원
     */
    // 테이블 정원을 입력받는 메서드
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
        scan.close();
        return temp;
    }
    
    /**
     * 테이블 개수를 입력받는 메서드입니다.
     *
     * @return 입력받은 테이블 개수
     */
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
        scan.close();
        return temp;
    }
}