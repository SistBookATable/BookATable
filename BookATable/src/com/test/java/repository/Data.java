package com.test.java.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;


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

public class Data {

	
	//여러개면 Path 클래스를 만들어서 넣는게 좋음
	private final static String USER = "dat"+File.separator+"user.txt";
	private final static String BUSINESSUSER = "dat"+File.separator+"businessUser.txt";
	private final static String ADMIN = "dat"+File.separator+"admin.txt";
	
	private final static String STORE = "dat"+File.separator+"store.txt";
	
	private final static String BLACKLIST = "dat"+File.separator+"blackList.txt";
	private final static String VIP = "dat"+File.separator+"vip.txt";
	private final static String TABLE = "dat"+File.separator+"table.txt";
	private final static String MENU = "dat"+File.separator+"menu.txt";
	private final static String OPERATINGHOURS = "dat"+File.separator+"operatinghours.txt";
	private final static String RESERVATION = "dat"+File.separator+"reservation.txt";
	private final static String POINTUSAGE = "dat"+File.separator+"pointUsage.txt";
	private final static String REVIEW = "dat"+File.separator+"review.txt";
	private final static String FAQ = "dat"+File.separator+"faq.txt";
	private final static String INQUIRY = "dat"+File.separator+"inquiry.txt";
	private final static String REQUEST = "dat"+File.separator+"request.txt";
	private final static String BOOKMARK = "dat"+File.separator+"bookmark.txt";
	private final static String POINTREFUND = "dat"+File.separator+"pointRefund.txt";
	
	
	//필요한 자료들
	public static ArrayList<Member> memberList = new ArrayList<>();
	public static ArrayList<Store> storeList = new ArrayList<>();
	public static ArrayList<Menu> menuList = new ArrayList<>();
	public static ArrayList<Reservation> reservationList = new ArrayList<>();
	public static ArrayList<BlackList> blackListList = new ArrayList<>();
	public static ArrayList<Inquiry> inquiryList = new ArrayList<>();
	public static ArrayList<Faq> faqList = new ArrayList<>();
	public static ArrayList<OperatingHours> operatingHoursList = new ArrayList<>();

	public static ArrayList<PointUsage> pointList = new ArrayList<>();
//	public static ArrayList<CompletedList> compleatedList = new ArrayList<>();
	public static ArrayList<Request> requestList = new ArrayList<>();
//	public static ArrayList<ReservationCancel> reservationCancelList = new ArrayList<>();
	public static ArrayList<Review> reviewList = new ArrayList<>();
	public static ArrayList<Review> reviewCountList = new ArrayList<>();
	//public static ArrayList<StopUser> stopUserList = new ArrayList<>();
	public static ArrayList<Table> tableList = new ArrayList<>();

	public static ArrayList<WriteReview> writeReviewList = new ArrayList<>();
	public static String path1 = "dat\review.txt";
    public static String path2 = "dat\store.txt";
    
	
	
	public static void loadPointRefund() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.POINTREFUND));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] tmp = line.split(",");
				PointRefund pointRefund = new PointRefund(tmp[0], Integer.parseInt(tmp[1]),tmp[2]);
				pointRefundList.add(pointRefund);

			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void loadBookmark() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.BOOKMARK));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Bookmark bookmark = new Bookmark(tmp[0], tmp[1]);
				bookmarkList.add(bookmark);
				System.out.println(bookmarkList);
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
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
	
	public static void loadOperatingHours() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.OPERATINGHOURS));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				OperatingHours operatingHours = new OperatingHours(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
				operatingHoursList.add(operatingHours);
				System.out.println(pointList);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO PointUsage 개체 완성하고, loadPointUsage() 마무리.... 
	public static void loadPointUsage() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.POINTUSAGE));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
////				PointUsage pointUsage = new PointUsage(Integer.parseInt(tmp[0]),tmp[1],tmp[2],tmp[3]);
//				pointList.add(pointUsage);
				System.out.println(pointList);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void loadFaq() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.FAQ));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Faq faq = new Faq(Integer.parseInt(tmp[0]),tmp[1],tmp[2],tmp[3]);
				faqList.add(faq);
				System.out.println(faq);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void loadBlackList() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.BLACKLIST));
		
		String line = null;
		
		while((line = reader.readLine())!=null){
			
			String[] tmp = line.split(",");
			
			BlackList blackList = new BlackList(tmp[0],tmp[1],Integer.parseInt(tmp[2]));
			blackListList.add(blackList);
		}
		reader.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
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
	
	public static void saveBlackList() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.BLACKLIST));
			
			for(BlackList blackList : Data.blackListList) {
				String line = String.format("%s,%s,%d",blackList.getLicenseNumber(),blackList.getUserId(),blackList.getNoShowCount());
							
				writer.write(line);
					
			}
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
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
	//프로그램을 시작할 때 file의 내용을 모두 메모리에 넣는 작업
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
				System.out.println(store);
			}
			
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
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
				System.out.println(user);
				memberList.add(user);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

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
	
	//프로그램을 끝낼 때 메모리의 내용을 모두 file에 넣는 작업
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
	
	
	
	public static String getUser() {
		return USER;
	}
}