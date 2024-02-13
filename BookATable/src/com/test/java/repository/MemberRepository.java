package com.test.java.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.view.SignOutUserManagementView;

/**
 * Member(User, BusinessUser)에 관련되어 데이터를 조회하거나 삭제하는 기능의 클래스입니다.
 */
public class MemberRepository {

	/**
	 * 회원ID를 기준으로 어레이리스트에서 해당하는 객체를 찾는 메서드입니다.
	 * 
	 * @param id 회원ID
	 * @return 일치하는 객체를 찾으면 해당 객체를 반환하고, 일치하는 객체를 찾지 못한 경우 null을 반환합니다.
	 */
	public static Member findOneById(String id) {
		for (Member m : Data.memberList) {
			if (m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}

	/**
	 * 모든 ArrayList<Member>의 객체를 조회하여 반환합니다.
	 * @return
	 */
	public static ArrayList<Member> findAll() {
		return Data.memberList;
	}

	/**
	 * 회원이름을 기준으로 어레이리스트에서 해당하는 객체를 찾는 메서드입니다.
	 * 
	 * @param name 회원이름
	 * @return 일치하는 객체를 찾으면 true를 반환하고, 일치하는 객체를 찾지 못한 경우 false를 반환합니다.
	 */
	public static boolean isValidName(String name) {

		for (Member m : Data.memberList) {
			if (m.getName().equals(name)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * ID중복확인을 위해 회원ID를 기준으로 어레이리스트에서 해당하는 객체를 찾는 메서드입니다.
	 * 
	 * @param id 회원ID
	 * @return 일치하는 객체를 찾으면 false를 반환하고, 일치하는 객체를 찾지 못한 경우 true를 반환합니다.
	 */
	public static boolean checkDuplicate(String id) {
		for (Member m : Data.memberList) {
			if (m.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 주어진 id와 일치하는 사용자를 삭제하는 기능을 수행하는 메서드입니다.
	 * @param id
	 */
	public static void deleteUser(String id) {
		//모든 멤버를 조회
		Iterator it = Data.memberList.iterator();

		while (it.hasNext()) {
			Member m = (Member) it.next();
			
			//멤버의 getId() 메서드를 호출하여 id와 비교
			if (m.getId().equals(id)) {
				
				//id와 일치하는 멤버를 찾으면, ableToDelete 메서드를 호출하여 삭제 가능 여부를 확인
				if (ableToDelete(m)) {
					it.remove();
					SignOutUserManagementView.deleteSuccessMessage();
				} else {
					SignOutUserManagementView.deleteCancleMessage();
				}
			}
		}
	}

	/**
	 * Member객체를 매개변수로 받아 멤버의 탈퇴일과 현재 날짜를 비교하여 삭제 가능 여부를 판단하는 메서드입니다.
	 * @param m
	 * @return 조건이 참이면 true, 거짓이면 false 반환합니다.
	 */
	private static boolean ableToDelete(Member m) {
		Calendar now = Calendar.getInstance();
		Calendar selected = Calendar.getInstance();
		
		//m.getSignOut()을 통해 멤버의 탈퇴일을 문자열로 가져옴
		//split("-")을 사용하여 년, 월, 일로 분리한 후, 각각 정수로 변환
		int year = Integer.parseInt(m.getSignOut().split("-")[0]);
		int month = Integer.parseInt(m.getSignOut().split("-")[1]);
		int day = Integer.parseInt(m.getSignOut().split("-")[2]);

		selected.set(year, month - 1, day);

		int gap = (int) ((now.getTimeInMillis() - selected.getTimeInMillis()) / 1000 / 3600 / 24);
		
		//현재일 - 탈퇴일 > 30일 초과하면 회원정보 삭제 가능
		if (gap > 30) {
			return true;
		}
		return false;
	}

	/**
	 * 모든 멤버를 조회하는 메서드입니다.
	 * 
	 * @return 탈퇴일자가 null인 경우 Member 개체를 ArrayList에 추가하여 반환합니다.
	 */
	public static ArrayList<Member> findAllUser() {
		ArrayList<Member> tmp = new ArrayList<>();
		for (Member m : Data.memberList) {
			if (m.getSignOut().equals("null")) {
				tmp.add(m);
			}
		}
		return tmp;
	}

	/**
	 * 모든 탈퇴 멤버를 조회하는 메서드입니다.
	 * 
	 * @return 탈퇴일자가 null이 아닌 경우 Member 개체를 ArrayList에 추가하여 반환합니다.
	 */
	public static ArrayList<Member> findAllSingOutUser() {
		ArrayList<Member> tmp = new ArrayList<>();
		for (Member m : Data.memberList) {
			if (!m.getSignOut().equals("null")) {
				tmp.add(m);
			}
		}
		return tmp;
	}

	/**
	 * 모든 업체회원을 조회하는 메서드입니다.
	 * @return getUserType이 2이고, 탈퇴일자가 null인 경우 Member 개체를 BusinessUser로 다운캐스팅하여 ArrayList<BusinessUser>에 추가하여 반환합니다.
	 */
	public static ArrayList<BusinessUser> findAllBusinessUser() {
		ArrayList<BusinessUser> tmp = new ArrayList<>();
		for (Member m : Data.memberList) {
			if (m.getUserType() == 2 && m.getSignOut().equals("null")) {
				tmp.add((BusinessUser) m);
			}
		}
		return tmp;
	}

	/**
	 * 모든 탈퇴한 업체회원을 조회하는 메서드입니다.
	 * @return getUserType이 2이고, 탈퇴일자가 null이 아닌 경우 Member 개체를 BusinessUser로 다운캐스팅하여 ArrayList<BusinessUser>에 추가하여 반환합니다.
	 */
	public static ArrayList<BusinessUser> findAllSingOutBusinessUser() {
		ArrayList<BusinessUser> tmp = new ArrayList<>();
		for (Member m : Data.memberList) {
			if (m.getUserType() == 2 && !m.getSignOut().equals("null")) {
				tmp.add((BusinessUser) m);
			}
		}
		return tmp;

	}

	/**
	 * Data.memberList에 새로운 일반회원 정보를 추가하는 메서드입니다.
	 * @param id
	 * @param pw
	 * @param name
	 * @param phone
	 * @param jumin
	 * @param i
	 * @param j
	 * @param k
	 * @param bank
	 * @param account
	 * @param string
	 * @param now
	 * @param string2
	 */
	public static void add(String id, String pw, String name, String phone, String jumin, int i, int j, int k,
			String bank, String account, String string, String now, String string2) {

		User user = new User(id, pw, name, phone, jumin, i, j, k, bank, account, string, now, string2);
		Data.memberList.add(user);
	}

	/**
	 * Data.memberList에 새로운 업체회원 정보를 추가하는 메서드입니다.
	 * @param userType
	 * @param id
	 * @param pw
	 * @param name
	 * @param licenseNumber
	 * @param phoneNumber
	 * @param bank
	 * @param account
	 * @param now
	 * @param signOut
	 */
	public static void addBusinessUser(int userType, String id, String pw, String name, String licenseNumber,
			String phoneNumber, String bank, String account, String now, String signOut) {

		BusinessUser businessUser = new BusinessUser(2, id, pw, name, licenseNumber, phoneNumber, bank, account, now,
				signOut);
		Data.memberList.add(businessUser);
	}

	/**
	 * 회원이름과 핸드폰번호로 ID를 조회후 반환하는 메서드 입니다.
	 * @param name
	 * @param phoneNumber
	 * @return 주어진 name과 phoneNumber의 항목이 Data.memberList의 개체와 일치하고, 탈퇴회원이 아니면 Id를 반환하고 조건을 만족하지 못하면 null을 반환합니다.
	 */
	public static String findId(String name, String phoneNumber) {
		for (Member selected : Data.memberList) {
			if (selected.getName().equals(name) && selected.getPhoneNumber().equals(phoneNumber)
					&& selected.getSignOut().equals("null")) {
				return selected.getId();
			}
		}
		return null;
	}

	/**
	 * 회원Id와 핸드폰번호로 Pw를 조회후 반환하는 메서드 입니다.
	 * @param id
	 * @param phoneNumber
	 * @return 주어진 id와 phoneNumber의 항목이 Data.memberList 개체와 일치하고, 탈퇴회원이 아니면 pw를 반환하고 조건을 만족하지 못하면 null을 반환합니다.
	 */
	 
	public static String findPw(String id, String phoneNumber) {
		for (Member selected : Data.memberList) {
			if (selected.getId().equals(id) && selected.getPhoneNumber().equals(phoneNumber)
					&& selected.getSignOut().equals("null")) {
				return selected.getPw();
			}
		}
		return null;
	}
}
