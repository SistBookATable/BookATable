package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class DataTest {
	public static void main(String[] args) {
		m1();
		m2();
		m3();
		m4();
		m5();

	}

	
	private static void m5() {
		String path1 = "dat\\request.txt";
		String path2 = "dat\\businessUser.txt";
		String lisenceNum;
		ArrayList<String> requestList = new ArrayList<>();
		try {

			BufferedReader reader1 = new BufferedReader(new FileReader(path1));

			String line = null;
			while ((line = reader1.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				requestList.add(line);
			}	
			
			reader1.close();	
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader2 = new BufferedReader(new FileReader(path2));
			String line = null;
			while ((line = reader2.readLine()) != null) {
				String[] temp = line.split(",");
				lisenceNum=temp[4];
				String requester = temp[1];
				
				for(String str : requestList) {
					if(str.indexOf(lisenceNum)>-1) {
//						System.out.println(lisenceNum);
						System.out.println(lisenceNum+","+requester);
					}
					
				}
			}
			reader2.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	private static void m4() {
//		dat/request.txt : 리뷰삭제요청 릴레이션
//		[요청번호], 리뷰번호, 사업자 등록번호, 요청사유, 요청자명, 요청시간, 승인여부
		String path1 = "dat\\businessUser.txt";
		String path2 = "dat\\review.txt";
		
		int requestNumber = 0;
		int reviewNumber;
		String lisence;
		String reason;
		String requester;
		String dateWritten;
		String permission = null;
		
		ArrayList<String> businessUserList = new ArrayList<>();
		ArrayList<String> requestList = new ArrayList<>();
		String[] reasonEx = { "허위사실 유포", "명예 훼손", "관련없는 내용 작성", "인격모독", "악의적인 리뷰 작성"};

		Random rnd = new Random();
		try {

			BufferedReader reader1 = new BufferedReader(new FileReader(path1));

			String line = null;
			while ((line = reader1.readLine()) != null) {
				
				String[] temp = line.split(",");
				businessUserList.add(line);
				requester=temp[1];
					
					try {

						BufferedReader reader2 = new BufferedReader(new FileReader(path2));

						String str1 = null;
						int i = 0;
						while ((str1 = reader2.readLine()) != null) {
							String[] tmp = str1.split(",");
							requestNumber += 1 ;
							reviewNumber=(Integer.parseInt(temp[0]));
				
							reason = reasonEx[(rnd.nextInt(5))];
							lisence = tmp[2];
							dateWritten = tmp[3];
							
							permission = "null";
							for(String str:businessUserList) {
								if(str.indexOf(lisence)>-1) {
									System.out.printf("%d,%d,%s,%s,%s,%s,%s\n" 
											, requestNumber, reviewNumber, lisence, requester, reason, dateWritten,permission);
									
								}
							}

						}
						reader2.close();

					} catch (Exception e) {
						System.out.println("Data.load");
						e.printStackTrace();
					}
					
				}
				
			
			reader1.close();	
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		

		

	}
		
		
		
	
	private static void m3() {
	
		String path1 = "dat\\review.txt";
		String path2 = "dat\\store.txt";
		String lisenceNum;

		ArrayList<String> reviewList = new ArrayList<String>();
		ArrayList<String> reviewCountList = new ArrayList<String>();
		
		try {

			BufferedReader reader1 = new BufferedReader(new FileReader(path1));

			String line = null;
			while ((line = reader1.readLine()) != null) {
				
				String[] temp = line.split(",");
				lisenceNum=temp[2];
				reviewList.add(lisenceNum);
			}	
			
			reader1.close();	
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader2 = new BufferedReader(new FileReader(path2));
			String line = null;
			while ((line = reader2.readLine()) != null) {
				String[] temp = line.split(",");
				lisenceNum=temp[0];
				String storeName = temp[1];
				int i = 0;
				for(String review : reviewList) {
					if(review.indexOf(lisenceNum)>-1) {
						i++;
					}
					
				}
				String result = String.format("[리뷰]%d개 ,[상호명] %s", i,storeName);
				reviewCountList.add(result);
			}
			reader2.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Collections.sort(reviewCountList,Collections.reverseOrder());
		for(String output : reviewCountList) {
			System.out.println(output);
		}

	}
		
	

	private static void m2() {

		// dat\vip.txt : 단골 릴레이션
		// [사업자 등록번호], 일반회원ID, 이용횟수, 최다주문메뉴
		String path = "dat\\vipTest.txt";
		String lisenceNum;
		String userId;
		String check;
		int usageCount = 0;
		
		// 최다주문메뉴..?
		ArrayList<String> vipList = new ArrayList<String>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				userId=temp[0];
				lisenceNum = temp[1];
				check = temp[2];
				vipList.add(check);
				usageCount = 0;
				for(String str :vipList) {
					
					if(str.indexOf(check)>-1) {
						usageCount++;
						if(usageCount>=2) {
						System.out.printf("%s,%s,%d,%s\n",lisenceNum,userId,usageCount,temp[8]);
						}
					}
				}	
					
			}	
			reader.close();	

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

	private static void m1() {
//		dat\review.txt : 리뷰 릴레이션
//		[리뷰번호], 작성일, 리뷰 내용, 평점, 예약번호

//		String USER = "dat\\user.txt";
//		String TABLE = "dat\\table.txt";
		String RESERVATION = "dat\\reservation.txt";
//		1,milalhz,992-09-13475,1100,2023-12-12,3,4,노쇼,돼지갈비,돼지갈비,돼지갈비
		int reservationNum;
		int reviewNumber;
		double score;
		String dateWritten;
//		String content = "";
		ArrayList<String> reviewList = new ArrayList<String>();
		String[] rewiewEx = { "맛있어요", "다시 주문할게요", "다시 안 시켜 먹을 것 같아요.", "머리카락 나옴..;;", "양이 너무 적어요... ", "인생 맛집 입니다. ㅎㅎ",
				"잘 먹었습니다~", "부모님이 맛 있다고 하시네요!", "사장님이 친절하시고 음식도 맛있어요." };
		Random rnd = new Random();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(RESERVATION));

			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				i++;
				String[] temp = line.split(",");
				String check = temp[7];
				if (check.equals("방문")) {
					reservationNum = Integer.parseInt(temp[0]);
					reviewNumber = i;
					String content = rewiewEx[(rnd.nextInt(9))];
					score = rnd.nextDouble(5.0);
					dateWritten = temp[4];

					System.out.printf("%d,%s,%s,%s,%s,%.1f,%d\n", reviewNumber, temp[1], temp[2], dateWritten, content,
							score, reservationNum);

				}

			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

}
