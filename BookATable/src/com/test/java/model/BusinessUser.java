package com.test.java.model;

import java.util.Calendar;

/**
 * Member를 상속받은 BusinessUser 클래스
 * 업체회원에 대한 정보를 담고 있음
 */
public class BusinessUser extends Member{
	
	private int userType = 2;
	private String id; 
	private String pw; 
	private String name; 
	private String licenseNumber;
	private String phoneNumber;
	private String bank; 
	private String account;
	private String signIn;
	private String signOut;
	private int reservationCount;
	private int noshowCount;
	
	/**
	 * BusinessUser 클래스의 생성자
	 * @param userType		회원 유형
	 * @param id			아이디
	 * @param pw			비밀번호
	 * @param name			이름
	 * @param licenseNumber	사업자번호
	 * @param phoneNumber	휴대전화번호
	 * @param bank			은행
	 * @param account		계좌
	 * @param signIn		회원가입
	 * @param signOut		회원탈퇴
	 */
	public BusinessUser(int userType, String id, String pw, String name, String licenseNumber, String phoneNumber,
			String bank, String account, String signIn, String signOut) {
		super();
		this.userType = userType;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.phoneNumber = phoneNumber;
		this.bank = bank;
		this.account = account;
		this.signIn = signIn;
		this.signOut = signOut;
	}
	


	public BusinessUser() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "BusinessUser [userType=" + userType + ", id=" + id + ", pw=" + pw + ", name=" + name
				+ ", licenseNumber=" + licenseNumber + ", phoneNumber=" + phoneNumber + ", bank=" + bank + ", account="
				+ account + ", signIn=" + signIn + ", signOut=" + signOut + "]";
	}

	
	// 사용자 id를 반환
	public String getId() {
		return id;
	}
	// 사용자 p/w를 반환
	public String getPw() {
		return pw;
	}
	// 사용자 이름을 반환
	public String getName() {
		return name;
	}
	// 유저의 타입을 반환
	public int getUserType() {
		return userType;
	}
	// 사업자 번호를 반환
	public String getLicenseNumber() {
		return licenseNumber;
	}
	// 휴대전화 번호를 반환
	public String getPhoneNumber() {
		return phoneNumber;
	}
	// 계좌번호를 반환
	public String getAccount() {
		return account;
	}
	// 회원탈퇴 날짜를 반환
	public String getSignOut() {
		return signOut;
	}
	// 입력된 id와 회원 id가 일치 여부를 반환
	public boolean checkId(String inputId) {
		return true;
	}
	// 회원 탈퇴 시간이 일치하는지 여부를 반환
	public boolean checkSignOut(Calendar inputSignOut) {
		return true;
	}

	// 은행 정보를 반환
	public String getBank() {
		return bank;
	}
	// 회원 탈퇴 시간을 반환
	@Override
	public String getSignIn() {
		return signIn;
	}



	// 예약 횟수를 반환
	public int getReservationCount() {
		return reservationCount;
	}

	// 노쇼 횟수를 반환
	public int getNoshowCount() {
		return noshowCount;
	}
	
	/**
	 * 업체회원, id, 이름, 탈퇴일을 출력하고 예약 횟수와 노쇼 횟수는 0으로 초기화
	 */
	@Override
	public void print() {

		String tmp = "";
		tmp = String.format("%s%20s%17s%15d회%15d회%19s%15s",
				"업체회원",
				this.getId(),
				this.getName(),
				0,
				0,
				this.getSignOut(),
				" ");
		System.out.println(tmp);	
	}

	/**
	 * 회원가입 정보를 나타내는 printSignIn 메서드
	 */
	@Override
	public void printSignIn() {

		String tmp = "";
		tmp = String.format("%s%15s%18s%15s%15d회%15d회%19s",
				"업체회원",
				this.getId(),
				this.getSignIn(),
				this.getName(),
				0,
				0,
				" ");
		System.out.println(tmp);
	}





	
	
}
