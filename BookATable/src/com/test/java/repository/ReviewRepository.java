package com.test.java.repository;

import com.test.java.model.Review;

public class ReviewRepository {

	public static double findScoreById(String id) {
		for(Review r :Data.reviewList) {
			if(r.getUserId().equals(id)){
				return r.getScore();
			}
		}
		return 0;
	}

	public static double findScoreByReservationNumber(int reservationNumber) {
		for(Review r :Data.reviewList) {
			if(r.getReservationNumber()==reservationNumber){
				return r.getScore();
			}
		}
		return 0;
	}

	public static String findContentByReservationNumber(int reservationNumber) {
		for(Review r :Data.reviewList) {
			if(r.getReservationNumber()==reservationNumber){
				return r.getContent();
			}
		}
		return null;
	}
}
