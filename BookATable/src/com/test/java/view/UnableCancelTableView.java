package com.test.java.view;

import java.util.Scanner;

public class UnableCancelTableView {
	
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
