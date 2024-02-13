package com.test.java.model;

/**
 * Request 클래스는 리뷰삭제 요청(Request) 정보를 담는 모델 클래스입니다.
 */
public class Request {
	private static int REQUESTCOUNT = 1;
	private int requestNumber; // 삭제요청 번호
	private int reviewNumber; // 리뷰작성번호
	private String licenseNumber; // 사업자등록번호
	private String reason; // 요청 사유
	private String requester; // 요청업체 ID
	private String dateWritten; // 삭제요청일
	private String permission; // 삭제 허가 여부

	 /**
     * Request 클래스의 생성자입니다.
     * @param requestNumber 삭제요청 번호
     * @param reviewNumber 리뷰작성번호
     * @param licenseNumber 사업자등록번호
     * @param reason 리뷰삭제 요청사유
     * @param requester 리뷰삭제요청 업체ID
     * @param dateWritten 삭제요청일
     * @param permission 삭제 승인 여부
     */
	public Request(int requestNumber, int reviewNumber, String licenseNumber, String reason, String requester,
			String dateWritten, String permission) {

		super();
		this.requestNumber = REQUESTCOUNT++;
		this.reviewNumber = reviewNumber;
		this.licenseNumber = licenseNumber;
		this.reason = reason;
		this.requester = requester;
		this.dateWritten = dateWritten;
		this.permission = permission;
	}

	 /**
     * 허가 여부를 설정하는 메서드입니다.
     * @param permission 허가 여부
     */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
     * 요청 번호를 반환하는 메서드입니다.
     * @return 요청 번호
     */
	public int getRequestNumber() {
		return requestNumber;
	}

	/**
     * 리뷰 번호를 반환하는 메서드입니다.
     * @return 리뷰 번호
     */
	public int getReviewNumber() {
		return reviewNumber;
	}

	/**
     * 사업자등록번호를 반환하는 메서드입니다.
     * @return 사업자등록번호
     */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
     * 요청 사유를 반환하는 메서드입니다.
     * @return 요청 사유
     */
	public String getReason() {
		return reason;
	}

	/**
     * 요청자를 반환하는 메서드입니다.
     * @return 요청자
     */
	public String getRequester() {
		return requester;
	}

	 /**
     * 삭제요청일을 반환하는 메서드입니다.
     * @return 요청일
     */
	public String getDateWritten() {
		return dateWritten;
	}

	/**
     * 삭제 승인 여부를 반환하는 메서드입니다.
     * @return 승인 여부
     */
	public String getPermission() {
		return permission;
	}

}
