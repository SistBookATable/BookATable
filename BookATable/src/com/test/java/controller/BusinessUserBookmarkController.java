package com.test.java.controller;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.BookmarkRepository;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.StoreRepository;
import com.test.java.view.BusinessUserBookmarkView;

public class BusinessUserBookmarkController {

	BusinessUserBookmarkView businessUserBookmarkView = new BusinessUserBookmarkView();
	
	public void bookmarkManagement() {
		businessUserBookmarkView.showTitle();
		
		//ID로 라이센스 넘버 조회
		String lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();
		
		//라이센스 넘버로 즐겨찾기 수 조회
		int count = BookmarkRepository.findAllCount(lisenceNumber);
		
		//라이센스 넘버로 매장명 조회
		String storeName = StoreRepository.findOneByLicenseNumber(lisenceNumber).getStoreName();
		
		//즐겨찾기 수 출력
		businessUserBookmarkView.showBookMarkCount(storeName,count);
		
	}

}
