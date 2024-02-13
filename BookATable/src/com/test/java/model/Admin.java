package com.test.java.model;
/**
 * Admin은 관리자를 나타내는 클래스입니다.
 * Member 클래스를 상속받습니다.
 */
public class Admin extends Member{
	
	 /**
     * 관리자의 레벨을 나타내는 정적 변수입니다.
     */
	private int userType = 3; //[1,2,3: 관리자]
	/**
     * 관리자의 아이디를 나타내는 정적 변수입니다.
     */
	private String id; 
	/**
     * 관리자의 비밀번호를 나타내는 정적 변수입니다.
     */
	private String pw;
	
	/**
     * Admin 클래스의 생성자입니다.
     * @param userType 사용자 유형 (3: 관리자)
     * @param id 아이디
     * @param pw 비밀번호
     */
	public Admin(int userType, String id, String pw) {
		super();
		this.userType = userType;
		this.id = id;
		this.pw = pw;
	}
	
	/**
     * 사용자 유형을 반환합니다.
     * @return 사용자 유형 (1: 일반회원, 2: 업체회원, 3: 관리자)
     */
	public int getUserType() {
		return userType;
	}
	
	
	/**
     * 아이디를 반환합니다.
     * @return 아이디
     */
	public String getId() {
		return id;
	}
	
	
	/**
     * 비밀번호를 반환합니다.
     * @return 비밀번호
     */
	public String getPw() {
		return pw;
	}
	
	
	/**
     * 객체의 정보를 문자열로 반환합니다.
     * @return 객체 정보 문자열
     */
	@Override
	public String toString() {
		return "Admin [userType=" + userType + ", id=" + id + ", pw=" + pw + "]";
	}

	/**
     * 관리자의 이름을 반환합니다.
     * @return 관리자 이름
     */
	@Override
	public String getName() {
		return "관리자";
	}

	/**
     * 전화번호를 반환합니다.
     * 관리자는 등록된 전화번호가 없으므로 null을 반환합니다.
     * @return null
     */
	@Override
	public String getPhoneNumber() {
		return null;
	}

	
	/**
     * 회원가입 날짜를 반환합니다.
     * 관리자는 프로그램 생성시 생성된 계정이 존재하므로 회원가입 날짜는 null을 반환합니다.
     * @return null
     */
	@Override
	public String getSignIn() {
		return null;
	}

	/**
     * 계좌번호를 반환합니다.
     * 관리자는 등록된 계좌번호가 없으므로 null을 반환합니다.
     * @return null
     */
	@Override
	public String getAccount() {
		return null;
	}

	/**
     * 회원 탈퇴 날짜를 반환합니다.
     * 관리자는 회원탈퇴 기능이 없으므로 null을 반환합니다.
     * @return null
     */
	@Override
	public String getSignOut() {
		return "null";
	}

	/**
     * 출력 메서드입니다.
     */
	@Override
	public void print() {
	}

	/**
     * 회원가입 정보를 출력하는 메서드입니다.
     */
	@Override
	public void printSignIn() {
	}

	 /**
     * 예약 수를 반환합니다. 관리자 계정으로 예약 기능을 실행하지 않으므로 0을 반환합니다.
     * @return 0
     */
	@Override
	public int getReservationCount() {
		return 0;
	}

	/**
     * 노쇼 수를 반환합니다. 관리자 계정으로 계약 기능을 실행하지 않으므로 0을 반환합니다.
     * @return 노쇼 수
     */
	@Override
	public int getNoshowCount() {
		return 0;
	} 

}
