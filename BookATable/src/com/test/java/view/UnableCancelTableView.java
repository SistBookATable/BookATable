package com.test.java.view;

import java.util.Scanner;

/**
 * 예약 불가 테이블 해제 화면을 출력하는 클래스
 */
public class UnableCancelTableView {
    
    /**
     * 테이블 정원을 입력받는 메서드
     * 
     * @return 입력된 테이블 정원
     */
    public static int getTableCapacity() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("1. 어떤 크기의 테이블을 예약 불가해지하시겠습니까? : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                validInput = true;
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // 잘못된 입력을 버림
            }
        }
        return temp;
    }

}
