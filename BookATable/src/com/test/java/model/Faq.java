package com.test.java.model;

/**
 * Faq 클래스는 자주 묻는 질문과 해당 질문에 대한 답변에 관련한 모델 클래스입니다.
 */
public class Faq {
	

	private int faqNumber; // FAQ 번호
    private String title; // 제목
    private String question; // 질문
    private String answer; // 답변

    /**
     * Faq 객체를 생성하는 생성자입니다.
     *
     * @param faqNumber FAQ 번호
     * @param title     제목
     * @param question  질문
     * @param answer    답변
     * 
     */
	public Faq(int faqNumber, String title, String question, String answer) {
		super();
		this.faqNumber = faqNumber;
		this.title = title;
		this.question = question;
		this.answer = answer;
	}

	/**
     * FAQ 번호를 반환합니다.
     * @return FAQ 번호
     */
	public int getFaqNumber() {
		return faqNumber;
	}

	/**
     * 제목을 반환합니다.
     * @return 제목
     */
	public String getTitle() {
		return title;
	}

	/**
     * 질문을 반환합니다.
     * @return 질문
     */
	public String getQuestion() {
		return question;
	}

	/**
     * 답변을 반환합니다.
     * @return 답변
     */
	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "Faq [faqNumber=" + faqNumber + ", title=" + title + ", question=" + question + ", answer="
				+ answer + "]";
	}
	
	
	
}