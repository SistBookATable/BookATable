package com.test.java.model;

/**
 * Inquiry 클래스는 1:1 사용자의 문의에 관련한 모델 클래스입니다.
 */
public class Inquiry {
	public static int COUNT = 1;
	private int inquiryNumber; // 문의 번호
	private String userId; // 사용자 ID
	private String title; // 제목
	private String content; // 내용
	private int type; // 문의자 type(=level), [일반회원=1,업체회원=2]
	private String dateWritten; // 작성일
	private String adminId; // 관리자 ID
	private String answer; // 답변

	
	/**
     * Inquiry 객체를 생성하는 생성자입니다.
     *
     * @param inquiryNumber 문의 번호
     * @param userId        사용자 ID
     * @param title         제목
     * @param content       내용
     * @param type          문의자 type(=level), [일반회원=1,업체회원=2]
     * @param dateWritten   작성일
     * @param adminId       관리자 ID
     * @param answer        답변
     */
	public Inquiry(int inquiryNumber, String userId, String title, String content, int type, String dateWritten,
			String adminId, String answer) {
		super();
		this.inquiryNumber = COUNT++;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.type = type;
		this.dateWritten = dateWritten;
		this.adminId = adminId;
		this.answer = answer;
	}

	/**
     * 관리자 ID를 설정합니다.
     * @param id 관리자 ID
     */
	public void setAdminId(String id) {
		this.adminId = id;
	}

	/**
     * 답변을 설정합니다.
     * @param answer 답변
     */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
     * 문의 번호를 반환합니다.
     * @return inquiryNumber 문의 번호
     */
	public int getInquiryNumber() {
		return inquiryNumber;
	}

	/**
     * 회원 ID를 반환합니다.
     * @return userId 회원 ID
     */
	public String getUserId() {
		return userId;
	}
	/**
     * 제목을 반환합니다.
     * @return title 제목
     */
	public String getTitle() {
		return title;
	}

	/**
     * 문의 내용을 반환합니다.
     * @return content 내용
     */
	public String getContent() {
		return content;
	}
	
	 /**
     * 관리자 ID를 반환합니다.
     * @return 관리자 ID
     */
	public String getAdminId() {
		return adminId;
	}
	
	/**
     * 문의회원의 Type을 반환합니다.
     * [일반회원=1,업체회원=2]
     * @return 종류
     */
	public int getType() {
		return type;
	}
	/**
     * 작성일을 반환합니다.
     * @return dateWritten 작성일
     */
	public String getDateWritten() {
		return dateWritten;
	}
	/**
     * 답변을 반환합니다.
     * @return answer 답변
     */
	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryNumber=" + inquiryNumber + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", type=" + type + ", dateWritten=" + dateWritten + ", adminId=" + adminId + ", answer="
				+ answer + "]";
	}

}