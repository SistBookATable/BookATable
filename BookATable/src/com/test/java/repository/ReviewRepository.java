package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Review;


/**
 * 리뷰 정보를 조회하고 검색하는 기능을 담당하는 클래스입니다. 
 */

public class ReviewRepository {

	/**
	 * 사용자 ID에 해당하는 별점을 조회하는 메서드입니다.
	 * @param id 사용자 ID
	 * @return 사용자 ID에 해당하는 별점을 반환합니다. 없으면 0을 반환합니다.
	 */
	public static double findScoreById(String id) {
		for(Review r :Data.reviewList) {
			if(r.getUserId().equals(id)){
				return r.getScore();
			}
		}
		return 0;
	}

	/**
	 * 예약 번호에 해당하는 별점을 조회하는 메서드입니다.
	 * @param reservationNumber 예약 번호
	 * @return 예약 번호에 해당하는 별점을 반환합니다. 없으면 0을 반환합니다.
	 */
	public static double findScoreByReservationNumber(int reservationNumber) {
		for(Review r :Data.reviewList) {
			if(r.getReservationNumber()==reservationNumber){
				return r.getScore();
			}
		}
		return 0;
	}

	/**
	 * 예약 번호에 해당하는 리뷰 내용을 조회하는 메서드입니다.
	 * @param reservationNumber 예약 번호
	 * @return 예약 번호에 해당하는 리뷰 내용을 반환합니다. 없으면 null을 반환합니다.
	 */
	public static String findContentByReservationNumber(int reservationNumber) {
		for(Review r :Data.reviewList) {
			if(r.getReservationNumber()==reservationNumber){
				return r.getContent();
			}
		}
		return null;
	}

	/**
	 * 사업자등록번호에 해당하는 모든 리뷰 정보를 조회하는 메서드입니다.
	 * @param lisenceNumber 사업자등록번호
	 * @return 사업자등록번호에 해당하는 모든 리뷰 정보를 ArrayList로 반환합니다.
	 */
	public static ArrayList<Review> findAllByLisenceNumber(String lisenceNumber) {
		ArrayList<Review> tmp = new ArrayList<>();
		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	/**
	 * 사용자 ID와 사업자등록번호에 해당하는 리뷰가 있는지 여부를 확인하는 메서드입니다.
	 * @param id 사용자 ID
	 * @param lisenceNumber 사업자등록번호
	 * @return 사용자 ID와 사업자등록번호에 해당하는 리뷰가 있으면 true, 없으면 false를 반환합니다.
	 */
	public static boolean findOneById(String id, String lisenceNumber) {
		for(Review r : Data.reviewList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 예약번호에 해당하는 리뷰를 조회하는 메서드입니다.
	 * @param reservationNumber 예약 번호
	 * @return 예약 번호에 해당하는 리뷰를 반환합니다. 없으면 null을 반환합니다
	 */
	public static Review findOne(int reservationNumber) {
		for(Review r : Data.reviewList) {
			if(r.getReservationNumber() == reservationNumber) {
				return r;
			}
		}
		return null;
	}

	/**
	 * 리뷰를 추가하는 메서드입니다. 
	 * @param i 리뷰 번호
	 * @param id 사용자ID
	 * @param lisenceNumber 사업자등록번호
	 * @param today 리뷰 작성일
	 * @param reviewContent 리뷰 내용 
	 * @param score 별점
	 * @param reservationNumber 예약 번호 
	 */
	public static void add(int i, String id, String lisenceNumber, String today, String reviewContent, double score,
			int reservationNumber) {
		Review tmp = new Review(i, id, lisenceNumber, today, reviewContent, score, reservationNumber);
		Data.reviewList.add(tmp);
	}

}
