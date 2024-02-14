package com.test.java.model;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * 예약 정보를 관리하는 Reservation 클래스
 */
public class Reservation {
	
	private static int COUNT=1;
	private int reservationNumber;
	private String userId;
	private String licenseNumber;
	private String reservationTime;
	private String reservationDate;
	private int numOfPeople;
	private int tableCapacity;
	private String state;
	
	private ArrayList<String> menulist = new ArrayList<>();
	
	/**
	 * Reservation클래스의 객체를 생성하는 생성자
	 * @param reservationNumber	예약 번호
	 * @param userId			사용자 ID
	 * @param licenseNumber		사업자 번호
	 * @param reservationTime	예약 시간
	 * @param reservationDate	예약 날짜
	 * @param numOfPeople		예약 인원
	 * @param tableCapacity		테이블 용량
	 * @param state				예약 상태
	 * @param menulist 			메뉴리스트를 담는 ArrayList
	 */
	public Reservation (int reservationNumber, String userId, String licenseNumber, String reservationTime,String reservationDate
			, int numOfPeople, int tableCapacity, String state, ArrayList<String> menulist) {
		super();
		this.reservationNumber = COUNT++;
		this.userId = userId;
		this.licenseNumber = licenseNumber;
		this.reservationTime = reservationTime;
		this.reservationDate = reservationDate;
		this.numOfPeople = numOfPeople;
		this.tableCapacity = tableCapacity;
		this.state = state;
		this.menulist = menulist;
	}
	
	/**
	 * getter > 각 멤버 변수의 값을 반환
	 * setter > 각 멤버 변수들의 값을 설정
	 * @param name
	 */
	public void addmenu(String name) {
		menulist.add(name);
	}
	
	public ArrayList<String> getMenulist() {
		return menulist;
	}
	public void setMenulist(ArrayList<String> menulist) {
		this.menulist = menulist;
	}
	public int getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(int numOfPeple) {
		this.numOfPeople = numOfPeple;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		System.out.println(menulist);
		return "Reservation [reservationNumber=" + reservationNumber + ", userId=" + userId + ", licenseNumber="
				+ licenseNumber + ", reservationTime=" + reservationTime + ", reservationDate=" + reservationDate
				+ ", numOfPeople=" + numOfPeople + ", tableCapacity=" + tableCapacity + ", state=" + state
				+ ", menulist=" + menulist + "]";
	}

	
	
}