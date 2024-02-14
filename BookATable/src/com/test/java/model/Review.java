package com.test.java.model;

/**
 * 리뷰를 관리하는 Review 클래스
 */
public class Review {

	private static int COUNT = 1;
   private int reviewNumber;
   private String userId;
   private String licenseNumber;
   private String dateWritten;
   private String content;
   public void setContent(String content) {
      this.content = content;
   }
   private double score;
   private int reservationNumber;
   
   /**
    * Review 클래스의 객체를 생성하는 생성자
    * @param reviewNumber		리뷰 번호
    * @param userId				사용자 ID
    * @param licenseNumber		사업자 번호
    * @param dateWritten		리뷰 작성 날짜
    * @param content			리뷰 내용
    * @param score				별점
    * @param reservationNumber	예약 번호
    */
   public Review(int reviewNumber, String userId, String licenseNumber, String dateWritten, String content,
         double score, int reservationNumber) {
      super();
      this.reviewNumber = COUNT++;
      this.userId = userId;
      this.licenseNumber = licenseNumber;
      this.dateWritten = dateWritten;
      this.content = content;
      this.score = score;
      this.reservationNumber = reservationNumber;
   }
   
   /**
    * getter > 각 멤버변수들의 값을 반환
    * @return
    */
   public String getUserId() {
      return userId;
   }
   public String getLicenseNumber() {
      return licenseNumber;
   }
   public int getReviewNumber() {
      return reviewNumber;
   }
   public String getDateWritten() {
      return dateWritten;
   }
   public String getContent() {
      return content;
   }
   public double getScore() {
      return score;
   }
   public int getReservationNumber() {
      return reservationNumber;
   }
   
   
   @Override
   public String toString() {
      return "Review [reviewNumber=" + reviewNumber + ", userId=" + userId + ", licenseNumber=" + licenseNumber
            + ", dateWritten=" + dateWritten + ", content=" + content + ", score=" + score + ", reservationNumber="
            + reservationNumber + "]";
   }   
}