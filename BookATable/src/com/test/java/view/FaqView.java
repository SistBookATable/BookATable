package com.test.java.view;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.controller.FaqController;
import com.test.java.model.Faq;
import com.test.java.model.Member;
import com.test.java.repository.Data;

public class FaqView {

	public static void showFaq() {
		System.out.println();
		System.out.println();
//		System.out.println("‖‗▶=¦|⌈⌉⌊⌋—–-−¯");
		System.out.println("‖¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯‖");
		System.out.println("‖			    FAQ                          ‖");
		System.out.println("‖‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‖");
		System.out.println();
		System.out.println("========================================================");
		System.out.println();
		System.out.println("▶		1.[노쇼확정 기준시간]");
		System.out.println("▶		2.[노쇼횟수 누적에 따른 서비스 이용 정지]");
		System.out.println("▶		3.[예약취소 불가 상태와 포인트 환불 불가]");
		System.out.println("▶		4.[특정업체 이용제한]");
		System.out.println("▶		5.[포인트 출금계좌 변경]");
		System.out.println("▶		6.[충전 포인트 환불]");
		System.out.println("▶		0. 이전화면");
		System.out.println();
		System.out.println("========================================================");
		System.out.println();
		System.out.print("선택(번호) : ");
		
	}
	
	public static int getSelectNumber() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}
	

	public static void showFaqBySelectNum(Faq f) {
		System.out.println("showFaqBySelectNum");
		System.out.println(f);
	
	}

	
}
