package com.test.java.model;

import java.util.Calendar;

/**
 * Member 클래스를 상속받는 User 클래스
 * User의 정보를 담고 있음
 */
public class User extends Member{
	
	private int userType = 1; //[1:일반회원,2,3]
	private String id; 
	private String pw; 
	private String name; 
	private String phoneNumber;
	private String jumin;
	private int reservationCount;
	private int noshowCount;
	private int balance;
	private String bank;
	private String account; 
	private String checkStop;
	private String signIn;  
	private String signOut;
	
	
	/**
	 * User 클래스의 생성자
	 * @param userType			회원타입
	 * @param id				사용자 id
	 * @param pw				사용자 p/w
	 * @param name				사용자 이름
	 * @param phoneNumber		휴대전화 번호
	 * @param jumin				주민 번호
	 * @param bank				은행
	 * @param account			계좌 번호
	 * @param balance			계좌 잔액
	 * @param reservationCount	예약횟수
	 * @param noshowCount		노쇼횟수
	 * @param checkStop			정지 여부
	 * @param signIn			회원 가입
	 * @param signOut			회원 탈퇴
	 */
	public User(int userType, String id, String pw, String name, String phoneNumber, String jumin, String bank, String account, int balance, int reservationCount,
			int noshowCount,  String checkStop, String signIn,
			String signOut) {
		super();
		this.userType = userType;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.jumin = jumin;
		this.reservationCount = reservationCount;
		this.noshowCount = noshowCount;
		this.balance = balance;
		this.bank = bank;
		this.account = account;
		this.checkStop = checkStop;
		this.signIn = signIn;
		this.signOut = signOut;
	}

	public User (String id, String pw, String name, String phoneNumber, String jumin, int reservationCount, int noshowCount, int balance,
			String bank, String account, String checkStop, String signIn, String signOut) {
		super();
		this.userType = 1;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.jumin = jumin;
		this.reservationCount = reservationCount;
		this.noshowCount = noshowCount;
		this.balance = balance;
		this.bank = bank;
		this.account = account;
		this.checkStop = checkStop;
		this.signIn = signIn;
		this.signOut = signOut;
	}
	
	/**
	 * getter > 각 멤버 변수들의 값을 반환
	 * setter > 각 멤버 변수들의 값을 설정
	 */
	public int getUserType() {
		return userType;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getJumin() {
		return jumin;
	}

	public int getNoshowCount() {
		return noshowCount;
	}

	public int getBalance() {
		return balance;
	}

	public String getBank() {
		return bank;
	}

	public String getAccount() {
		return account;
	}

	public String getCheckStop() {
		return checkStop;
	}

	public String getSignIn() {
		return signIn;
	}

	public String getSignOut() {
		return signOut;
	}

	public boolean checkid(String id) {
		return true;
	}
	
	public boolean checkSignOut(Calendar signOut) {
		return true;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", jumin=" + jumin + ", noshowCount=" + noshowCount + ", balance=" + balance + ", bank="
				+ bank + ", account=" + account + ", checkStop=" + checkStop + ", signIn=" + signIn + ", signOut="
				+ signOut + "]";
	}

	public int getReservationCount() {
		return reservationCount;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
		
	}

	public String getBirth() {
        String[] juminToBirth = this.jumin.split("-");
		return juminToBirth[0];
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setSignOut(String signOut) {
		this.signOut = signOut;
	}
	/**
	 * 사용자 정보 출력
	 */
	@Override
	public void print() {

		String tmp = "";
		tmp = String.format("%s%20s%17s%15d회%15d회%19s%15s",
				"일반회원",
				this.getId(),
				this.getName(),
				this.getReservationCount(),
				this.getNoshowCount(),
				this.getSignOut(),
				(this.getNoshowCount() >= 10)? "정지회원":" ");
		System.out.println(tmp);	
	}
	
	/**
	 * 회원 가입 정보를 나타내는 printSignIn 메서드
	 */
	@Override
	public void printSignIn() {

		String tmp = "";
		tmp = String.format("%s%15s%18s%15s%15d회%15d회%19s",
				"일반회원",
				this.getId(),
				this.getSignIn(),
				this.getName(),
				this.getReservationCount(),
				this.getNoshowCount(),
				(this.getNoshowCount() >= 10)? "정지회원입니다.":" ");
		System.out.println(tmp);
	}

	
}
