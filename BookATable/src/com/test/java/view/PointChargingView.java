package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Member;

public class PointChargingView {
	

	public static ArrayList<String> getInput() {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> tmp = new ArrayList<String>();
		
		System.out.print("포인트 충전금액: ");
		tmp.add(Integer.toString(scan.nextInt())); // 정수를 문자열로 변환하여 추가
		
		scan.nextLine();
		
		System.out.print("비밀번호 입력: ");
		tmp.add(scan.nextLine());
		
		return tmp;
	}
		
	}

