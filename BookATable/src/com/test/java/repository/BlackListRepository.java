package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.BlackList;
/**
 * blacklist를 조회하고 새로운 blacklist를 추가하는 클래스입니다.
 */
public class BlackListRepository {

	/**
	 * 사업자등록번호와 사용자 ID로 블랙리스트를 조회하는 메서드입니다.
	 * 
	 * @param lisenceNumber 사업자등록번호
	 * @param key           사용자 ID
	 * @return 블랙리스트에 해당하는 정보가 있다면 true, 없다면 false를 반환합니다.
	 */
	public static boolean findOne(String lisenceNumber, String key) {

		for (BlackList b : Data.blackListList) {
			if (b.getLicenseNumber().equals(lisenceNumber) && b.getUserId().equals(key)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 사업자등록번호와 사용자 ID를 기반으로 블랙리스트에 새로운 항목을 추가합니다.
	 * 
	 * @param licenseNumber 사업자등록번호
	 * @param userId        사용자 ID
	 */
	public static void addOne(String licenseNumber, String userId) {
		BlackList tmp = new BlackList(licenseNumber, userId);
		Data.blackListList.add(tmp);
	}

	/**
	 * 사업자등록번호와 사용자 ID에 해당하는 모든 블랙리스트 항목을 조회합니다.
	 * 
	 * @param lisenceNumber 사업자등록번호
	 * @param key           사용자 ID
	 * @return 블랙리스트에 해당하는 모든 항목을 담은 ArrayList를 반환합니다.
	 */
	public static ArrayList<BlackList> findAll(String lisenceNumber, String key) {

		return Data.blackListList;
	}
}
