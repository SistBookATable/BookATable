package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Menu;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.SignInView;
import com.test.java.view.StoreView;

/**
 * 음식점을 검색하는 기능을 제공하는 StoreController 클래스
 */
public class StoreController {
	
	/**
	 * StoreController에 필요한 멤버 변수 선언
	 */
    private StoreView storeView;
    private Store store;
    private ArrayList<Store> bookmarkedStores; 
    
    /**
     * StoreController의 생성자, 각 객체들을 초기화
     */
    public StoreController() {
        this.storeView = new StoreView();
        this.bookmarkedStores = new ArrayList<>();
    }
    /**
     * 음식점과 리뷰를 저장하는 ArrayList
     */
    ArrayList<Store> searched = new ArrayList<>();
    ArrayList<Review> reviewCount = new ArrayList<>();
    
    /**
     * 상호명 및 메뉴명을 선택하여 해당 기능으로 갈 수 있는 run 메서드
     */
    public void run() {
        boolean loop = true;
        while(loop) {
            storeView.searchMenu();
            int choice = storeView.get();

            switch(choice) {
                case 0:		// 이전 화면 이동
                    System.out.println("이전 화면으로 이동합니다.");
                    loop = false;
                    break;
                case 1:		// 상호명 검색
                    String storeName = storeView.getStoreName();
                    searched = searchStoreName(storeName);
                    if(searched.isEmpty()) {
                        System.out.println("음식점 리스트가 없습니다.");
                        continue;
                    }
                    storeView.show(searched);
                    loop = processSortingOption(searched);
                    break;
                case 2:		// 메뉴 검색
                    String menuName = storeView.getmenuName();
                    searched = searchMenuName(menuName);
                    if(searched.isEmpty()) {
                        System.out.println("음식점 리스트가 없습니다.");
                        continue;
                    }
                    storeView.show(searched);
                    loop = processSortingOption(searched);
                    break;
                default:	// 잘못된 값을 입력한 경우
                    System.out.println("잘못 입력하셨습니다. 0 ~ 2범위의 숫자를 입력하여 주세요.");
            }
        }
    }
   
    /**
     * 별점 내림차순, 리뷰 갯수 내림차순, 상세페이지로 이동할 수 있는
     * processSortingOption 메서드
     * @param searched
     * @return 
     */
    private boolean processSortingOption(ArrayList<Store> searched) {
        boolean loop = true;
        while (loop) {
            storeView.showSelectBox();
            int sortingOption = storeView.get();
            ReservationController reservationController = new ReservationController();

            switch (sortingOption) {
                case 0:		// 이전 화면 이동
                    System.out.println("이전 화면으로 이동합니다.");
                    loop = false;
                    break;
                case 1:		// 별점 내림차순 정렬, 람다식으로 내림차순 정렬
                    Collections.sort(searched, (o1, o2) -> (int)(o2.getScore()*10 - o1.getScore()*10));
                    storeView.show(searched);
                    break;
                case 2:		// 리뷰 갯수 내림차순 정렬, 람다식으로 내림차순 정렬
                    Collections.sort(searched, (o1, o2) -> (o2.getReviewCount() - o1.getReviewCount()));
                    storeView.show(searched);
                    break;
                case 3:		// 상세페이지, false를 반환하는 경우 문장 종료
                    if (!detailPage()) {
                        return false;
                    }
                    break;
                default:	// 잘못된 값 입력 시 해당 내용 출력
                    System.out.println("잘못 입력하셨습니다. 0 ~ 3범위의 숫자를 입력하여 주세요.");
            }
        }
        return true;
    }
    
    /**
     * 상세페이지를 나타내는 detailPage 메서드
     * @return 메뉴로 돌아가는 경우 > true, 아니면 false
     */
    public boolean detailPage() {
        ReservationController reservationController = new ReservationController();
        Scanner sc = new Scanner(System.in);
        storeView.bookmarkNreservation();
        int choice = sc.nextInt();
        // 레벨 0 : 비회원, 레벨 1 : 일반 회원, 레벨 2 : 업체 회원
        switch(choice) {
            case 0:			// 이전 페이지 이동
                storeView.backPage();
                return true;
            case 1:			// 예약하기, 음식점 리스트의 인덱스 번호를 이용하여 사업자번호를 reservation에 전달하며 메서드 호출
                if ((Member.level == 1)) {
                    storeView.show(searched);
                    storeView.reservationNumber();
                    int select = sc.nextInt();
                    reservationController.reservation(searched.get(select-1).getLicenseNumber());
                } else if(Member.level == 2) {
                	storeView.noneBusinessUserAvailable();
                	break;
                }
                else if(Member.level == 0) {
                    storeView.show(searched);
                    storeView.noneMemberAvailable();
                    String input = storeView.getTxt();
                    if(input.equals("y")) {			// 회원가입 유무, Y를 누르면 초기 페이지 이동
                        return false;
                    } else if(input.equals("n")) {	// N을 누르면 이전 페이지 이동
                        storeView.backPage();
                        return true;
                    } else {
                        storeView.inputError();		// 잘못된 값 입력 시 출력
                        return false;
                    }
                }
            case 2:
                // 즐겨찾기 등록
                bookmarkStore(searched);
                break;
            case 3:
                // 즐겨찾기 삭제
                removeBookmark(bookmarkedStores);
                break;
            case 4:
                // 즐겨찾기 조회
            	showBookmarkedStores(searched);
                break;
            default:
                System.out.println("잘못 입력하셨습니다. 0 ~ 4범위의 숫자를 입력하여 주세요.");
        }
        return true;
    }
    /**
     * 즐겨찾기 등록, 넘버링은 1부터 시작하므로 get으로 가져올 때 -1을 뺌
     * @param searched
     */
    private void bookmarkStore(ArrayList<Store> searched) {
        Scanner scanner = new Scanner(System.in);
        storeView.show(searched);
        System.out.print("즐겨찾기에 추가할 음식점 번호를 선택하세요: ");
        int index = scanner.nextInt();
        Store store = searched.get(index - 1);
        store.setBookmark(true);
        bookmarkedStores.add(store);
        System.out.println(store.getStoreName() + "이(가) 즐겨찾기에 추가되었습니다.");
    }
    
    /**
     * 즐겨찾기 삭제 메서드
     * @param bookmarkedStores
     */
    private void removeBookmark(ArrayList<Store> bookmarkedStores) {
        if (bookmarkedStores.isEmpty()) {
            System.out.println("현재 즐겨찾기된 음식점이 없습니다.");
            return;
        }

        storeView.showBookmarkedStores(bookmarkedStores);
        Scanner scanner = new Scanner(System.in); 
        System.out.print("삭제할 즐겨찾기 번호를 선택하세요: ");
        int index = scanner.nextInt();

        if (index < 1 || index > bookmarkedStores.size()) {
            System.out.println("잘못된 번호를 선택하셨습니다.");
            return;
        }

        Store store = bookmarkedStores.get(index - 1);
        store.setBookmark(false);
        bookmarkedStores.remove(store);
        System.out.println(store.getStoreName() + "의 즐겨찾기가 삭제되었습니다.");
    }
    
    /**
     * 즐겨찾기 조회 메서드
     * @param searched
     */
    public void showBookmarkedStores(ArrayList<Store> searched) {
        if (bookmarkedStores.isEmpty()) {
            System.out.println("즐겨찾는 음식점이 없습니다.");
        } else {
            System.out.println("즐겨찾는 음식점 목록:");
            for (int i = 0; i < bookmarkedStores.size(); i++) {
                Store store = bookmarkedStores.get(i);
                System.out.println((i+1) + ". " + store.getStoreName());
                storeView.show(store, i+1);
                System.out.println();
            }
        }
    }

    /**
     * 특정 리뷰를 찾은 후 해당 음식점을 찾아 반환하는 searchReviewCount 메서드
     * @param menu
     * @return 
     */
    private ArrayList<Store> searchReviewCount(String menu) {
        ArrayList<Store> tmp = new ArrayList<>();

        for(Review r : Data.reviewList) {
            if(r.getLicenseNumber().equals(menu)) {
                String licenseNumber = r.getLicenseNumber();

                for(Store s : Data.storeList) {
                    if(s.getLicenseNumber().equals(licenseNumber)) {
                        tmp.add(s);
                    }
                }
            }
        }
        return tmp;
    }
    
    /**
     * Data의 메뉴리스트와 전달받은 menu가 같다면 menuList의 사업자번호를 licenseNumber 변수에 저장하고
     * storeList의 요소들을 반복하여 store객체의 사업자번호와 licenseNumber가 같으면 tmp에 저장 후 반환하는
     * searchMenuName 메서드
     * @param menu
     * @return tmp
     */
    private ArrayList<Store> searchMenuName(String menu) {
        ArrayList<Store> tmp = new ArrayList<>();

        for(Menu m : Data.menuList) {
            if(m.getMenuName().equals(menu)) {
                String licenseNumber = m.getLicenseNumber();
                for(Store store : Data.storeList) {
                    if(store.getLicenseNumber().equals(licenseNumber)) {
                        tmp.add(store);
                    }
                }
            }
        }
        return tmp;
    }
    
    /**
     * 상호명으로 검색하는 searchStoreName 메서드
     * equal 메서드가 아닌 contains 메서드를 사용하여 해당 키워드가 포함된
     * 음식점을 모두 tmp 객체에 저장
     * @param keyword
     * @return tmp
     */

    private ArrayList<Store> searchStoreName(String keyword) {
        ArrayList<Store> tmp = new ArrayList<>();
        String same = keyword;
        for(Store store : Data.storeList) {
            if(store.getStoreName().contains(same)) {
                tmp.add(store);
            }
        }
        return tmp;
    }
}
