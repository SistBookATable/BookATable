package com.test.java.model;


public class Review {

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
   
   
   public Review(int reviewNumber, String userId, String licenseNumber, String dateWritten, String content,
         double score, int reservationNumber) {
      super();
      this.reviewNumber = reviewNumber;
      this.userId = userId;
      this.licenseNumber = licenseNumber;
      this.dateWritten = dateWritten;
      this.content = content;
      this.score = score;
      this.reservationNumber = reservationNumber;
   }
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