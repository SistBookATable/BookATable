package com.test.java.model;


public class Faq {
	
	private static int faqNumber;
	private static String title;
	private static String question;
	private static String answer;

	public Faq(int faqNumber, String title, String question, String answer) {
		super();
		this.faqNumber = faqNumber;
		this.title = title;
		this.question = question;
		this.answer = answer;
	}

	public static int getFaqNumber() {
		return faqNumber;
	}

	public static String getTitle() {
		return title;
	}

	public static String getQuestion() {
		return question;
	}

	public static String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "Faq [faqNumber=" + faqNumber + ", title=" + title + ", question=" + question + ", answer="
				+ answer + "]";
	}
	
	
	
}