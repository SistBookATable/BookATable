package com.test.java.view;

import java.util.Scanner;

public class BusinessUserSignInView {

		

	public static String getName() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("업체의 대표자명을 입력해주세요.이름은 한글과 영문자로만 구성되어야 하고 총 2자 이상 작성하십시오.");
		System.out.println("⁕⁕⁕ 공동 대표의 경우 등록할 한 명의 정보만 입력하십시오. 회원가입 절차 중 입력한 대표자의 명의의 전화번호, 계좌번호 작성란이 있습니다.");
		System.out.println();
		System.out.print("대표자명 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getLicenseNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("사업자등록증상의 등록번호를 “-”를 포함하여 000-00-00000 형식으로 작성하십시오.");
		System.out.println("유효함: 777-77-77770");
		System.out.print("사업자 등록번호 : ");
		tmp = scan.nextLine();
		return tmp;
	}


	public static String getPhoneNumber() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("전화번호를 숫자와 “-”로만 구성하여 000-0000-0000 형식으로 작성하십시오");
		System.out.println();
		System.out.print("대표자 전화번호 : ");
		tmp = scan.nextLine();

		return tmp;
	}
	public static String getId() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.print("ID : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getPw() {
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("PW는 특수문자(!,@,#,$,%,^,&,*)1자 이상 포함하여 5자 이상으로 작성하십시오");
		System.out.println();
		System.out.print("PW : ");
		tmp = scan.nextLine();
		return tmp;
	}
	
	public static String getBank() {

		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("연결 계좌의 은행을 선택해 주세요");
		System.out.println("1. SC제일은행");
		System.out.println("2. 신한은행");
		System.out.println("3. 씨티은행");
		System.out.println("4. DGB대구은행");
		System.out.println("5. 케이뱅크");
		System.out.println("6. NH농협은행");
		System.out.println("7. 우리은행");
		System.out.println("8. 부산은행");
		System.out.println("9. 카카오뱅크");
		System.out.println("10. IBK기업은행");
		System.out.println("11. KEB하나은행");
		System.out.print("입력 (번호) : ");
		tmp = scan.nextLine();
		return tmp;
	}
	
	public static String getAccount() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.print("계좌번호 : ");
		tmp = scan.nextLine();		
		return tmp;
	}
	
	public static String getStoreName() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("상호명: 한글,영어,숫자로 2글자이상 입력하세요.\r\n⁕⁕⁕ “(주)”를 포함하는 상호명의 길이는 3글자이상이어야 합니다.");
		System.out.println();
		System.out.print("상호명 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static String getStoreTelNumber() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("업체 전화번호는 지역번호(ex.02,031,042 등)와 “-”를 포합하여 작성하십시오.\r\n⁕⁕⁕예시) 지역번호-000-000 또는 지역번호-0000-0000");
		System.out.println();
		System.out.print("업체 전화번호 : ");
		tmp = scan.nextLine();
		return tmp;
	}
//	TODO 주소 유효성 검사 생성
	public static String getAddress() {
		//실제 있는 주소인지 확인
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("업체 주소 : 도로명 주소 or (구)지번주소만 작성하십시오.");
		System.out.println("⁕⁕⁕상세주소(동,호수,층,건물명) 제외하고 작성하십시오.");
		System.out.println();
		System.out.print("업체 주소 : ");
		tmp = scan.nextLine();
		return tmp;
	}
	public static String getDetailAddress() {
		//동,호수,층,건물명 등
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("상세 주소(동,호수,층,건물명)를 1자 이상 작성하십시오. 특수문자 “~,(,),-,_,@” 포함하여 작성 가능하며, 특수문자 만으로 작성은 불가능합니다.");
		System.out.print("업체 상세 주소 : ");
		tmp = scan.nextLine();
		return tmp;
	}
	

	public static String getMenuCategory() {
		
		Scanner scan = new Scanner(System.in);
		String tmp = "";
		System.out.println("===========================================================================================");
		System.out.println("한식\t중식\t일식\t양식\t육류\t해산물\r\n찜/탕\t분식\t치킨\t피자\t기타");
		System.out.println("⁕⁕⁕음식 분야는 위의 예시 중 하나로 작성하십시오.");
		System.out.println();
		System.out.print("음식 분야 : ");
		tmp = scan.nextLine();
		return tmp;
	}

	public static void errorMessage() {

		System.out.println();
		System.out.println("잘못된 값을 입력하셨습니다.");
		System.out.println();
		
		
	}
}
