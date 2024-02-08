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

public class StoreController {

    private StoreView storeView;
    private Store store;
    private ArrayList<Store> bookmarkedStores; // 즐겨찾기 목록

    public StoreController() {
        this.storeView = new StoreView();
        this.bookmarkedStores = new ArrayList<>();
    }

    ArrayList<Store> searched = new ArrayList<>();
    ArrayList<Menu> searchMenu = new ArrayList<>();
    ArrayList<Review> reviewCount = new ArrayList<>();
    

    public void run() {
        boolean loop = true;
        while(loop) {
            storeView.searchMenu();
            int choice = storeView.get();

            switch(choice) {
                case 0:
                    System.out.println("이전 화면으로 이동합니다.");
                    loop = false;
                    break;
                case 1:
                    String storeName = storeView.getStoreName();
                    searched = searchStoreName(storeName);
                    if(searched.isEmpty()) {
                        System.out.println("음식점 리스트가 없습니다.");
                        continue;
                    }
                    storeView.show(searched);
                    loop = processSortingOption(searched);
                    break;
                case 2:
                    String menuName = storeView.getmenuName();
                    searched = searchMenuName(menuName);
                    if(searched.isEmpty()) {
                        System.out.println("음식점 리스트가 없습니다.");
                        continue;
                    }
                    storeView.show(searched);
                    loop = processSortingOption(searched);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 0 ~ 2범위의 숫자를 입력하여 주세요.");
            }
        }
    }

    private boolean processSortingOption(ArrayList<Store> searched) {
        boolean loop = true;
        while (loop) {
            storeView.showSelectBox();
            int sortingOption = storeView.get();
            ReservationController reservationController = new ReservationController();

            switch (sortingOption) {
                case 0:
                    System.out.println("이전 화면으로 이동합니다.");
                    loop = false;
                    break;
                case 1:
                    Collections.sort(searched, (o1, o2) -> (int)(o2.getScore()*10 - o1.getScore()*10));
                    storeView.show(searched);
                    break;
                case 2:
                    Collections.sort(searched, (o1, o2) -> (o2.getReviewCount() - o1.getReviewCount()));
                    storeView.show(searched);
                    break;
                case 3:
                    if (!detailPage()) {
                        return false;
                    }
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 0 ~ 3범위의 숫자를 입력하여 주세요.");
            }
        }
        return true;
    }
    
    public boolean detailPage() {
        ReservationController reservationController = new ReservationController();
        SignInController signInController = new SignInController();
        Scanner sc = new Scanner(System.in);
        storeView.bookmarkNreservation();
        int choice = sc.nextInt();

        switch(choice) {
            case 0:
                storeView.backPage();
                return true;
            case 1:
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
                    if(input.equals("y")) {
                        return false;
                    } else if(input.equals("n")) {
                        storeView.backPage();
                        return true;
                    } else {
                        storeView.inputError();
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

    private void bookmarkStore(ArrayList<Store> searched) {	// 즐겨찾기 등록
        Scanner scanner = new Scanner(System.in);
        storeView.show(searched);
        System.out.print("즐겨찾기에 추가할 음식점 번호를 선택하세요: ");
        int index = scanner.nextInt();
        Store store = searched.get(index - 1);
        store.setBookmark(true);
        bookmarkedStores.add(store);
        System.out.println(store.getStoreName() + "이(가) 즐겨찾기에 추가되었습니다.");
    }
    
    private void removeBookmark(ArrayList<Store> bookmarkedStores) { // 즐겨찾기 삭제
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
    
    public void showBookmarkedStores(ArrayList<Store> searched) { // 즐겨찾기 조회
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
