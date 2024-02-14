package com.test.java.repository;

import com.test.java.model.Menu;
/**
 * Menu의 데이터를 조회하는 기능의 클래스입니다.
 */
public class MenuRepository {


	/**
	 * 회원ID를 기준으로 메뉴리스트에서 해당하는 객체를 찾는 메서드입니다.
	 * @return 일치하는 객체를 찾으면 해당 객체를 반환하고, 일치하는 객체를 찾지 못한 경우 null을 반환합니다.
	 */
	public static String findOneByUserId() {
		
		for(Menu m : Data.menuList) {
			
		}
		return null;
	}

}
