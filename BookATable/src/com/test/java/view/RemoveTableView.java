package com.test.java.view;

import java.util.Scanner;

/**
 * 테이블 삭제 화면을 보여주는 클래스
 */
public class RemoveTableView {
    
    /**
     * 삭제할 테이블의 정원을 입력 받는 메서드
     * 
     * @return 삭제할 테이블의 정원
     */
    public static int findTableCapacity() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("1. 어떤 크기의 테이블을 삭제하시겠습니까? : ");
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
    
    /**
     * 삭제를 확인하는 메서드
     * 
     * @return 삭제를 원하면 1, 아니면 2
     */
    public static int removeCheck() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("2. 전체 삭제를 원하면 1을, 아니면 2를 입력하세요 : ");
            if (scan.hasNextInt()) {
                temp = scan.nextInt();
                if (temp == 1 || temp == 2) {
                    validInput = true;
                } else {
                    System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
                }
            } else {
                System.out.println("숫자를 입력하세요.");
                scan.next(); // discard invalid input
            }
        }
        return temp;
    }
    
    /**
     * 삭제할 테이블의 개수를 입력 받는 메서드
     * 
     * @return 삭제할 테이블의 개수
     */
    public static int getRemoveTableNum() {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("3. 몇 개를 삭제하시겠습니까? : ");
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
