package com.test.java;

import com.test.java.controller.MainController;
/**
 * Main 클래스는 프로그램의 진입점이며, MainController.java를 호출합니다.
 */
public class Main {
	 /**
     * 프로그램 실행을 위한 메인 메서드입니다.
     */
	public static void main(String[] args) {

		MainController.load();
		MainController.start();  
		
		
	}
}


