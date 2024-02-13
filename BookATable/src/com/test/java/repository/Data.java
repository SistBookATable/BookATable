package com.test.java.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.test.java.model.Admin;
import com.test.java.model.BlackList;
import com.test.java.model.Bookmark;
import com.test.java.model.BusinessUser;
//import com.test.java.model.CompletedList;
import com.test.java.model.Faq;
import com.test.java.model.Inquiry;
import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.OperatingHours;
import com.test.java.model.PointRefund;
import com.test.java.model.PointUsage;
import com.test.java.model.Request;
import com.test.java.model.Reservation;
//import com.test.java.model.ReservationCancel;
import com.test.java.model.Review;
//import com.test.java.model.StopUser;
import com.test.java.model.Store;
import com.test.java.model.Table;
import com.test.java.model.User;
import com.test.java.model.WriteReview;
/**
 * Data 클래스는 프로젝트의 Data 파일의 경로를 선언합니다.
 * 관련 개체에 대한 ArrayList를 선언한 후에, 읽어온 Data를 ArrayList에 추가하여 Load하는 클래스입니다.
 */
public class Data {

	//파일의 경로를 선언합니다.
	private final static String VIP = "dat\\Vip.txt";// Vip(단골) 회원 파일 경로
	private final static String RESERVATIONMENU = "dat\\ReservationMenu.txt";// 예약 메뉴 파일 경로
	private final static String USER = "dat"+File.separator+"user.txt";// 일반회원 파일 경로
	private final static String BUSINESSUSER = "dat"+File.separator+"businessUser.txt";// 업체회원 파일 경로
	private final static String ADMIN = "dat"+File.separator+"admin.txt";// 관리자 파일 경로
	private final static String STORE = "dat"+File.separator+"store.txt";// 음식점 파일 경로
	private final static String BLACKLIST = "dat"+File.separator+"blackList.txt";// 블랙리스트 파일 경로
	private final static String TABLE = "dat"+File.separator+"table.txt";// 테이블 정보 파일 경로
	private final static String MENU = "dat"+File.separator+"menu.txt";// 메뉴 정보 파일 경로
	private final static String OPERATINGHOURS = "dat"+File.separator+"operatinghours.txt";// 영업 시간 정보 파일 경로
	private final static String RESERVATION = "dat"+File.separator+"reservation.txt";// 예약 정보 파일 경로
	private final static String POINTUSAGE = "dat"+File.separator+"pointUsage.txt";// 포인트 사용 내역 파일 경로
	private final static String REVIEW = "dat"+File.separator+"review.txt";// 리뷰 작성 내역 파일 경로
	private final static String FAQ = "dat"+File.separator+"faq.txt";// FAQ 파일 경로
	private final static String INQUIRY = "dat"+File.separator+"inquiry.txt";// 1:1 문의 파일 경로
	private final static String REQUEST = "dat"+File.separator+"request.txt";// 리뷰 삭제 요청내역 파일 경로
	private final static String BOOKMARK = "dat"+File.separator+"bookmark.txt";// 즐겨찾기 정보 파일 경로
	private final static String POINTREFUND = "dat"+File.separator+"pointRefund.txt";// 포인트 환급 내역 파일 경로
	
	//필요한 개체의 ArrayList를 선언합니다.
	public static ArrayList<Member> memberList = new ArrayList<>();
	public static ArrayList<Store> storeList = new ArrayList<>();
	public static ArrayList<Menu> menuList = new ArrayList<>();
	public static ArrayList<Reservation> reservationList = new ArrayList<>();
	public static ArrayList<BlackList> blackListList = new ArrayList<>();
	public static ArrayList<Inquiry> inquiryList = new ArrayList<>();
	public static ArrayList<Faq> faqList = new ArrayList<>();
	public static ArrayList<OperatingHours> operatingHoursList = new ArrayList<>();
	public static ArrayList<Bookmark> bookmarkList = new ArrayList<>();
	public static ArrayList<PointRefund> pointRefundList = new ArrayList<>();
	public static ArrayList<PointUsage> pointList = new ArrayList<>();
	public static ArrayList<Request> requestList = new ArrayList<>();
	public static ArrayList<Review> reviewList = new ArrayList<>();
	public static ArrayList<Review> reviewCountList = new ArrayList<>();
	public static ArrayList<Table> tableList = new ArrayList<>();
	public static ArrayList<WriteReview> writeReviewList = new ArrayList<>();

	public static String path1 = "dat\review.txt";
	public static String path2 = "dat\store.txt";
	
	/**
	 * 포인트 환급 데이터를 로드하는 메서드입니다.
	 */
	public static void loadPointRefund() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.POINTREFUND));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] tmp = line.split(",");
				PointRefund pointRefund = new PointRefund(tmp[0], Integer.parseInt(tmp[1]),tmp[2]);
//				pointRefundList.add(pointRefund);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 즐겨찾기(bookmark) 데이터를 로드하는 메서드입니다.
	 */
	public static void loadBookmark() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.BOOKMARK));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Bookmark bookmark = new Bookmark(tmp[0], tmp[1]);
				bookmarkList.add(bookmark);
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 리뷰삭제 요청 데이터를 로드하는 메서드입니다.
	 */
	public static void loadRequest() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.REQUEST));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Request request = new Request(
						Integer.parseInt(tmp[0]),
						Integer.parseInt(tmp[1]),
						tmp[2],
						tmp[3],
						tmp[4],
						tmp[5],
						tmp[6]);
				requestList.add(request);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 리뷰 작성 내역 데이터를 로드하는 메서드입니다.
	 */
	public static void loadReview() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.REVIEW));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] tmp = line.split(",");
				Review review = new Review(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], Double.parseDouble(tmp[5]), Integer.parseInt(tmp[6]));
				reviewList.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 음식점의 운영시간 데이터를 로드하는 메서드입니다.
	 */
	public static void loadOperatingHours() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.OPERATINGHOURS));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				OperatingHours operatingHours = new OperatingHours(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
				operatingHoursList.add(operatingHours);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 일반회원의 포인트 사용내역 데이터를 로드하는 메서드입니다.
	 */
	public static void loadPointUsage() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.POINTUSAGE));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				PointUsage pointUsage = new PointUsage(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),tmp[2],tmp[3], tmp[4]);
				pointList.add(pointUsage);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 자주묻는질문(faq) 데이터를 로드하는 메서드입니다.
	 */
	public static void loadFaq() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.FAQ));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Faq faq = new Faq(Integer.parseInt(tmp[0]),tmp[1],tmp[2],tmp[3]);
				faqList.add(faq);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * blacklist 회원의 데이터를 로드하는 메서드입니다.
	 */
	public static void loadBlackList() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.BLACKLIST));
		
		String line = null;
		
		while((line = reader.readLine())!=null){
			
			String[] tmp = line.split(",");

			BlackList blackList = new BlackList(tmp[0],tmp[1]);
			blackListList.add(blackList);
		}
		reader.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 1:1 문의내역 데이터를 로드하는 메서드입니다.
	 */
	public static void loadInquiry() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.INQUIRY));
		
		String line = null;
		
		while((line = reader.readLine())!=null){
			
			String[] tmp = line.split(",");
			
			Inquiry inquiry = new Inquiry(Integer.parseInt(tmp[0]),tmp[1],tmp[2], tmp[3], Integer.parseInt(tmp[4]),tmp[5],tmp[6],tmp[7]);
			
			inquiryList.add(inquiry);
		}

		reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 업체회원이 등록한 blacklist 회원의 데이터를 저장하는 메서드입니다.
	 */
	public static void saveBlackList() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.BLACKLIST));
			
			for(BlackList blackList : Data.blackListList) {
				String line = String.format("%s,%s",blackList.getLicenseNumber(),blackList.getUserId());
							
				writer.write(line);
					
			}
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	/**
	 * 에약 내역을 로드하는 메서드입니다.
	 */
	public static void loadReservation() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.RESERVATION));
		
		String line = null;
		
		while((line = reader.readLine())!=null){
			
			String[] tmp = line.split(",");
			ArrayList<String> bookedMenuList = new ArrayList<>();
			for(int i=0; i<Integer.parseInt(tmp[5]); i++) {
				bookedMenuList.add(tmp[i+8]);
			}
			
			Reservation reservation = new Reservation(Integer.parseInt(tmp[0]),tmp[1],tmp[2],tmp[3],tmp[4]
													,Integer.parseInt(tmp[5]),Integer.parseInt(tmp[6]),tmp[7], bookedMenuList);
			
			reservationList.add(reservation);
		}

		reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 에약 내역을 저장하는 메서드입니다.
	 */
	public static void saveReservation() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.RESERVATION));
			
			for(Reservation reservation : Data.reservationList) {
				String line = String.format("%d,%s,%s,%s,%s,%d,%d,%s",
						reservation.getReservationNumber(),
						reservation.getUserId(),
						reservation.getLicenseNumber(),
						reservation.getReservationTime(),
						reservation.getReservationDate(),
						reservation.getNumOfPeople(),
						reservation.getTableCapacity(),
						reservation.getState());
				
				for(String menuName :reservation.getMenulist()) {
					line += "," + menuName;
				}
				
				line += "\n";
				writer.write(line);
			}
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * 음식점별 메뉴 데이터를 로드하는 메서드입니다.
	 */
	public static void loadMenu() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.MENU));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] tmp = line.split(",");

				Menu menu = new Menu(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
				menuList.add(menu);

			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 수정된 메뉴 데이터를 저장하는 메서드입니다.
	 */
	public static void saveMenu() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MENU));
			
			for(Menu menu : Data.menuList) {
				String line = String.format("%s,%s,%d",menu.getLicenseNumber(),menu.getMenuName(),menu.getPrice());
							
				writer.write(line);
					
			}
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 음식점 정보 데이터를 로드하는 메서드입니다.
	 */
	public static void loadStore() {
		try {
			BufferedReader reader
				= new BufferedReader(new FileReader(Data.STORE));
			
			String line = null;
			
			while((line = reader.readLine()) != null){

				String[] tmp = line.split(",");

				Store store = new Store(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4],
										Double.parseDouble(tmp[5]),Integer.parseInt(tmp[6]));
				storeList.add(store);
			}
			
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 음식점 정보 데이터를 저장하는 메서드입니다.
	 */
	public static void saveStore() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.STORE));
			
			for(Store store : Data.storeList) {
				
				String line = String.format("%s,%s,%s,%s,%s,%.1f,%d"
											,store.getLicenseNumber(),store.getStoreName(),store.getStoreTelNumber(),store.getMenuCategory()
											,store.getAddress(),store.getAverageScore(),store.getDistanceFrom());
			
				writer.write(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * 관리자 정보 데이터를 로드하는 메서드입니다.
	 */
	public static void loadAdmin() {
		try {
			BufferedReader reader
				= new BufferedReader(new FileReader(Data.ADMIN));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				Admin admin = new Admin(Integer.parseInt(tmp[0]), tmp[1], tmp[2]); 
				memberList.add(admin);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 일반회원 정보 데이터를 로드하는 메서드입니다.
	 */
	public static void loadUser() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.USER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				User user = new User(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]
									, tmp[6], tmp[7]
									, Integer.parseInt(tmp[8]), Integer.parseInt(tmp[9]), Integer.parseInt(tmp[10]), tmp[11], tmp[12],tmp[13]);

				memberList.add(user);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 업체회원 정보 데이터를 로드하는 메서드입니다.
	 */
	public static void loadBusinessUser() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.BUSINESSUSER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				BusinessUser businessUser = new BusinessUser(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3]
															, tmp[4], tmp[5], tmp[6],  tmp[7]
															, tmp[8], tmp[9]);
				
				memberList.add(businessUser);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 일반회원 정보 데이터를 저장하는 메서드입니다.
	 */
	public static void saveUser() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.USER));
			
			for(Member user : Data.memberList) {
				if (user.getUserType() == 1) {
					
					String line = String.format("%d,%s,%s,%s,%s,%s,%s,%s,%d,%d,%d,%s,%s"
												, user.getUserType(), user.getId(), user.getPw(), user.getName()
												, user.getPhoneNumber(), user.getPhoneNumber(), ((User)user).getJumin()
												, ((User)user).getBank(), ((User)user).getAccount(), ((User)user).getBalance()
												, ((User)user).getReservationCount(), ((User)user), ((User)user).getNoshowCount()
												, ((User)user).getCheckStop(), ((User)user).getSignIn(), ((User)user).getSignOut()); 
					writer.write(line);
					
				}
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 업체회원 정보 데이터를 저장하는 메서드입니다.
	 */
	public static void saveBusinessUser() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.BUSINESSUSER));
			
			for(Member businessUser : Data.memberList) {
				if (businessUser.getUserType() == 1) {
					String line = String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s"
												, businessUser.getUserType(), businessUser.getId(), businessUser.getPw()
												, businessUser.getName(), ((BusinessUser)businessUser).getLicenseNumber()
												, businessUser.getPhoneNumber(), ((BusinessUser)businessUser).getBank()
												, ((BusinessUser)businessUser).getAccount()
												, ((BusinessUser)businessUser).getSignIn()
												, ((BusinessUser)businessUser).getSignOut());
							
							
					writer.write(line);
					
				}
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 *음식점의 테이블 정보 데이터를 로드하는 메서드입니다.
	 */
	public static void loadTable() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.TABLE));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] tmp = line.split(",");
				Table table = new Table(tmp[0], Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Boolean.parseBoolean(tmp[3]));
				tableList.add(table);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 일반회원 데이터 경로를 문자열로 반환하는 메서드입니다.
	 * @return Data.USER
	 */
	public static String getUser() {
		return USER;
	}
}