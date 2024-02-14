package com.test.java.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.java.model.Reservation;

/**
 * 예약 정보를 조회하고 검색하는 기능을 담당하는 클래스입니다.
 */

public class ReservationRepository {

	/**
	 * 사용자 ID 로 예약 정보를 조회하는 메서드입니다.
	 * @param id 사용자 ID
	 * @return 사용자 ID에 해당하는 예약 정보를 반환합니다. 없으면 null을 반환합니다.
	 */
	public static Reservation findOneById(String id) {

		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				return r;
			}
		}
		return null;
	}
	
	/**
	 * 사용자 ID로 예약 정보를 모두 조회하는 메서드입니다.
	 * @param id 사용자 ID
	 * @return 사용자 ID에 해당하는 모든 예약 정보를 ArrayList로 반환합니다.
	 */
	public static ArrayList<Reservation> findAllById(String id) {

		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				tmp.add(r);
			}
		}
		return tmp;
	}
	
	/**
	 * 예약 번호를 기반으로 메뉴별 예약 횟수를 조회하는 메서드입니다.
	 * @param reservationNumber 예약번호
	 * @return 예약 번호에 해당하는 메뉴별 예약 횟수를 반환합니다.
	 */

	public static HashMap<String, Integer> findMenuCountByReservationNumber(int reservationNumber) {
		
		HashMap<String, Integer> tmp = new HashMap<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getReservationNumber()==reservationNumber) {
				if(r.getState().equals("노쇼") || r.getState().equals("취소")) {
					continue;
				}
				for(String name : r.getMenulist()) {
					if(tmp.containsKey(name)) {
						tmp.put(name,	tmp.get(name)+1);	
					}
					else {
						tmp.put(name,1);
					}
				}
			}
		}
		
		return tmp;
	}
	
	/**
	 * 사업자등록번호와 오늘 날짜를 기반으로 메뉴별 예약 횟수를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @param today 오늘 날짜
	 * @param menuCount 메뉴별 예약 횟수를 저장
	 */
	public static void findMenuCount(String lisenceNumber, String today, HashMap<String, Integer> menuCount) {
		
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getReservationDate().equals(today)) {
				if(r.getState().equals("노쇼") || r.getState().equals("취소")) {
					continue;
				}
				for(String name : r.getMenulist()) {
					if(menuCount.containsKey(name)) {
						menuCount.put(name,	menuCount.get(name)+1);	
					}
					else {
						menuCount.put(name,1);
					}
				}
			}
		}
		
	}

	/**
	 * 사업자등록번호와 상태에 따른 예약 횟수를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @param state 예약 상태
	 * @return 사업자등록번호와 상태에 따른 예약 횟수를 반환합니다.
	 */
	public static HashMap<String, Integer> findAllCountByState(String lisenceNumber, String state) {
		HashMap<String, Integer> tmp = new HashMap<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber))
			{
				if(r.getState().equals(state)) {
					String userid = r.getUserId();
					if(tmp.containsKey(userid)) {
						tmp.put(r.getUserId(), tmp.get(userid) + 1);	
					}
					else {
						tmp.put(userid, 1);
					}
				}
			
			}
		}
		
		return tmp;
	}

	/**
	 * 사업자 등록 번호와 사용자 ID에 따른 메뉴별 예약 횟수를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @param ID 사용자 ID
	 * @return 사업자등록번호와 사용자 ID에 따른 메뉴별 예약 횟수를 반환합니다. 
	 */
	public static HashMap<String, Integer> findMenuByUserId(String lisenceNumber, String key) {
		HashMap<String, Integer> tmp = new HashMap<>();
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getUserId().equals(key) &&r.getState().equals("방문")) {
				for(String menu : r.getMenulist()) {
					if(tmp.containsKey(menu)) {
						tmp.put(menu, tmp.get(menu)+1);
					}
					else {
						tmp.put(menu, 1);
					}
				}
			}
		}
		
		
		return tmp;
	}

	/**
	 * 사업자등록번호에 해당하는 모든 예약 정보를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 모든 예약 정보를 ArrayListe로 반환합니다.
	 */
	public static ArrayList<Reservation> findAllByLisenceNumber(String lisenceNumber) {
		
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	/**
	 * 사업자등록번호와 상태에 해당하는 모든 예약 정보를 조회하는 메서드입니다. 
	 * @param lisenceNumber 사업자등록번호
	 * @param state 예약 상태
	 * @return 사업자 등록번호와 상태에 해당하는 모든 예약 정보를 ArrayList로 반환합니다.
	 */
	public static ArrayList<Reservation> findAllByLisenceNumberState(String lisenceNumber, String string) {
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getState().equals(string)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	/**
	 * 오늘 날짜에 해당하는 예약 정보를 조회하는 메서드입니다.
	 * @param lisence 사업자등록번호
	 * @param today 오늘 날짜
	 * @return 오늘 날짜에 해당하는 예약 정보를 반환합니다. 없으면 null을 반환합니다.
	 */
	public static Reservation findOneByToday(String lisence, String today) {
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisence) && r.getReservationDate().equals(today) && r.getState().equals("예약")) {
				return r;
			}
		}
		
		return null;
	}

	/**
	 * 예약 번호와 사용자 ID에 해당하는 예약 정보를 조회하는 메서드입니다
	 * 
	 * @param reservationNumber 예약 번호
	 * @param id 사용자 ID
	 * @return 에약 번호와 사용자 ID에 해당하는 예약 정보를 반환합니다. 없으면 null을 반환합니다.
	 */
	public static Reservation findOneByReservationNumber(int reservationNumber, String id) {
		for(Reservation r : Data.reservationList) {
			
			if(r.getReservationNumber() == reservationNumber && r.getUserId().equals(id)) {
				return r;
			}
		}
		return null;
	}
	
}
