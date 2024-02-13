package com.test.java.view;

import java.util.Scanner;
//예약 불가해지 화면 출력 class
public class UnableCancelTableView {
	// 테이블 정원 입력 받는 메서드
	public static int getTableCapacity() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("1. 어떤 크기의 테이블을 예약불가해지하시겠습니까? : ");
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
