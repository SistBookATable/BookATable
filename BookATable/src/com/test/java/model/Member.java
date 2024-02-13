package com.test.java.model;
/**
 * Member 클래스는 회원 정보를 나타내는 추상 클래스입니다.
 */
public abstract class Member {

	 /**
     * 회원의 레벨을 나타내는 정적 변수입니다.
     */
	public static int level;
	/**
     * 회원의 아이디를 나타내는 정적 변수입니다.
     */
	public static String id;
	/**
     * 회원의 사용자 유형을 반환하는 추상 메서드입니다.
     * @return 사용자 유형을 나타내는 정수 값 (일반회원:1, 업체회원:2, 관리자:3)
     */
	public abstract int getUserType();
	 /**
     * 회원 정보를 문자열로 반환하는 추상 메서드입니다.
     * @return 회원 정보를 나타내는 문자열
     */
	public abstract String toString();
	/**
     * 회원의 이름을 반환하는 추상 메서드입니다.
     * @return 회원의 이름
     */
	public abstract String getName();
	/**
     * 회원의 전화번호를 반환하는 추상 메서드입니다.
     * @return 회원의 전화번호
     */
	public abstract String getPhoneNumber();
	/**
     * 회원의 아이디를 반환하는 추상 메서드입니다.
     * @return 회원의 아이디
     */
	public abstract String getId();
	/**
     * 회원의 비밀번호를 반환하는 추상 메서드입니다.
     * @return 회원의 비밀번호
     */
	public abstract String getPw();
	 /**
     * 회원의 가입 날짜를 반환하는 추상 메서드입니다.
     * @return 회원의 가입 날짜
     */
	public abstract String getSignIn();
	/**
     * 회원의 계좌 정보를 반환하는 추상 메서드입니다.
     * @return 회원의 계좌 정보
     */
	public abstract String getAccount();
	/**
     * 회원의 회원탈퇴 날짜를 반환하는 추상 메서드입니다.
     * @return 회원의 탈퇴 날짜
     */
	public abstract String getSignOut();
	/**
     * 회원 정보를 출력하는 추상 메서드입니다.
     */
	public abstract void print();
	/**
     * 회원의 회원가입 정보를 출력하는 추상 메서드입니다.
     */
	public abstract void printSignIn();
	 /**
     * 회원의 예약 횟수를 반환하는 추상 메서드입니다.
     * @return 회원의 예약 횟수
     */
	public abstract int getReservationCount();
	/**
     * 회원의 노쇼 횟수를 반환하는 추상 메서드입니다.
     * @return 회원의 노쇼 횟수
     */
	public abstract int getNoshowCount();
	
}