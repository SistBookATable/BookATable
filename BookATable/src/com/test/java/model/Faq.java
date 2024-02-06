package com.test.java.model;


public class Faq {
	
	private int faqNumber;
	private String title;
	private String question;
	private String answer;

	public Faq(int faqNumber, String title, String question, String answer) {
		super();
		this.faqNumber = faqNumber;
		this.title = title;
		this.question = question;
		this.answer = answer;
	}

	public int getFaqNumber() {
		return faqNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "Faq [faqNumber=" + faqNumber + ", title=" + title + ", question=" + question + ", answer="
				+ answer + "]";
	}
	
	
	
}