package com.test.java.repository;

import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.view.SignOutUserManagementView;

/**
 * 음식점 정보를 조회하고 추가/삭제하는 기능을 담당하는 클래스입니다. 
 */
public class StoreRepository {
	/**
	 * 사업자등록번호로 음식점 정보를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 음식점 정보를 반환합니다. 없으면 null을 반환합니다.
	 */
	public static Store findOneByLicenseNumber(String lisenceNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(lisenceNumber)) {
				return s;
			}
		}
		return null;
	}

	/**
	 * 음식점 이름으로 정보를 조회하는 메서드입니다.
	 * @param storeName 음식점 이름
	 * @return 음식점 이름에 해당하는 음식점 정보를 반환합니다. 없으면 null 을 반환합니다.
	 */
	public static Store findOneByName(String storeName) {
		for(Store s : Data.storeList) {
			if(s.getStoreName().equals(storeName)) {
				return s;
			}
		}
		return null;
	}

	/**
	 * 사업자등록번호로 음식점 이름을 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 음식점 이름을 반환합니다. 없으면 null 을 반환합니다.
	 */
	public static String findNameOneByLicenseNumber(String lisenceNumber) {
		for(Store s : Data.storeList) {
			if(s.getLicenseNumber().equals(lisenceNumber)) {
				return s.getStoreName();
			}
		}
		return null;
	}
	

	/**
	 * 음식점 정보를 추가하는 메서드입니다.
	 * @param licenseNumber 사업자등록번호
	 * @param storeName 음식점 이름
	 * @param storeTelNumber 음식점 전화번호
	 * @param address 음식점 주소
	 * @param menuCategory 음식 분야
	 */
	public static void add(String licenseNumber, String storeName, String storeTelNumber, String address,
			String menuCategory) {
		Store tmp = new Store(licenseNumber, storeName, storeTelNumber, address, menuCategory);
		Data.storeList.add(tmp);
		
	}

	/**
	 * 음식점 정보를 삭제하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 */
	public static void delete(String lisenceNumber) {
		Iterator it = Data.storeList.iterator();
		
		while(it.hasNext()) {
			Store s = (Store)it.next();

			if(s.getLicenseNumber().equals(lisenceNumber)) {
				it.remove();
			}	
		}
		
	}
	
}
