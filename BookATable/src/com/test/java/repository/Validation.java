package com.test.java.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.test.java.controller.MainController;
import com.test.java.model.Member;

/**
 * 유효성 검사를 수행하는 메서드의 집합 클래스입니다.
 */
public class Validation {


	public static String[] banks = {"null", "SC제일은행", "신한은행", "씨티은행", "DGB대구은행", "케이뱅크", "NH농협은행","우리은행","부산은행","카카오뱅크", "IBK기업은행", "KEB하나은행"};

	/**
	 * id의 유효성을 검사하는 메서드 입니다.
	 * 1. 2글자 이상 작성
	 * @param id
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidId(String id) {
		return Pattern.matches("[a-zA-Z0-9]{2,}$", id);
	}
	

	/**
	 * 비밀번호의 유효성을 검사하는 메서드입니다.
	 * 1. 특수문자 1개 이상 2. 5글자 이상
	 * @param pw
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidPw(String pw) {
		return Pattern.matches("^(?=.*[!@#$%^&*])[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ!@#$%^&*]{5,}$", pw);
	}

	/**
	 * 은행과 계좌번호의 자릿수를 비교하여 유효성 검사를 수행하는 메서드입니다.
	 * @param account
	 * @param bank
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidAccount(String account, String bank) {
		switch(bank) {
		case "SC제일은행":
			return Pattern.matches("^(\\d){11,}", account);
		case "신한은행":
		case "씨티은행":
		case "DGB대구은행":
		case "케이뱅크":
			return Pattern.matches("^(\\d){12,}", account);
		case "NH농협은행":
		case "우리은행":
		case "부산은행":
		case "카카오뱅크":
			return Pattern.matches("^(\\d){13,}", account);
		case "IBK기업은행":
		case "KEB하나은행":
			return Pattern.matches("^(\\d){14,}", account);
		}
		return false;
		
	}

	/**
	 * 주어진 은행에 따라서 은행의 계좌번호 자릿 수를 확인하고 유효성검사를 수행하는 메서드입니다.
	 * @param bank
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidBank(String bank) {
		if (Pattern.matches("^[0-9]+$", bank)) {
			if (Integer.parseInt(bank) <= 11 && Integer.parseInt(bank) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 핸드폰번호의 유효성을 검사하는 메서드입니다.
	 * 1. - 포함하여 작성
	 * @param phone
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidPhone(String phone) {
		return Pattern.matches("^01(?:0|1|[6-9])-(\\d{3,4})-\\d{4}$", phone);
	}

	
	/**
	 * 주민등록번호의 유효성을 검사하는 메서드입니다.
	 *  1. (-포함)14자리
	 *  2. 중간에 '-' 작성
	 * @param jumin
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidJumin(String jumin) {
		return Pattern.matches("^[0-9]{6}-[1234][0-9]{6}$", jumin);
	}

	
	/**
	 * 이름의 유효성을 검사하는 메서드입니다.
	 * 1. 한글, 영문만 입력 가능(자음, 모음도 안됨) 2. 빈 값인 경우 불가능 3. 2글자 미만인 경우 불가능
	 * @param name
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidName(String name) {
		return Pattern.matches("^[가-힣a-zA-Z]{2,}", name);
	}

	
	/**
	 * 음식점의 이름의 유효성을 검사하는 메서드입니다.
	 * 1. 한글, 영문만 입력 가능(자음, 모음도 안됨)
	 * 2. 빈 값인 경우 불가능
	 * 3. (주)제외하고 2글자 미만인 경우 불가능
	 * 4.특수문자는 '(주)'의 형태로 작성하는 경우만 허용
	 * @param storeName
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidStoreName(String storeName) {

		if (Pattern.matches("([(주)])+[가-힣a-zA-Z0-9]{2,}$|^[가-힣a-zA-Z0-9]{2,}([(주)])+|^[가-힣a-zA-Z0-9]{2,}$",
				storeName)) {

			return true;
		}
		return false;
	}

	
	/**
	 * 업체 전화번호의 유효성을 검사하는 메서드 입니다.
	 * @param storeTelNumber
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidStoreTelNumber(String storeTelNumber) {
		if (Pattern.matches("^0(2|3[123]|4[12]|5[1-5]|6[1-4])-(\\d{3,4})-(\\d{4})$", storeTelNumber)) {

			return true;
		}
		return false;
	}

	/**
	 * 사업자등록번호 유효성검사하는 메서드입니다.
	 * 1. 000-00-00000 형식
	 * 2. 000: 101~999
	 * 3. 00: 01-79,80,81,84-87
	 * 4. 0000[0] : 0000은 0~9999 & [0] 각각의 숫자 조작하여 유효성 판단함
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidLisenceNumber(String lisenceNumber) {

		int[] VALID_LOGIC = { 1, 3, 7, 1, 3, 7, 1, 3, 5 };
		int sum = 0;

		// 입력 양식 유효성 검사
		if (!Pattern.matches("^([1-9][0-9][1-9]|[2-9]00)-([0-7]\\d|8[014567])-(\\d{5})$", lisenceNumber)) {
			System.out.println("정규식 오류");
			return false;
		}
		// 문자열에서 - 을 제거함
		int i;
		String removeDashLisenceNumber = lisenceNumber.replaceAll("-", "");
		// 문자열 문자을 int형으로 변환후, VALID_LOGIC[]의 요소값과 곱한 후 누적함
		for (i = 0; i < VALID_LOGIC.length; i++) {
			int replaceLisenceNumber = Character.getNumericValue(removeDashLisenceNumber.charAt(i));
			sum += VALID_LOGIC[i] * replaceLisenceNumber;
			// 마지막 인덱스는, 곱한 값을 10으로 나눈 후 몫을 한번 더 더해줌
			if (i == VALID_LOGIC.length - 1) {
				sum += (replaceLisenceNumber * VALID_LOGIC[i]) / 10;
			}
		}
		int check = 0;
		check = (10 - (sum % 10)) % 10;
		// 사업자 번호의 마지막 숫자와 위의 과정에서 나온 연산 값이 같으면 유효한 값
		if (Character.getNumericValue(removeDashLisenceNumber.charAt(9)) == check) {
			return true;
		}
		System.out.println("연산오류");
		return false;
	}

	/**
	 * 메뉴카테고리 유효성 검사하는 메서드입니다.
	 * {"한식","중식","일식","양식","육류","해산물","찜/탕","분식","치킨","피자","기타"} 중 하나 선택해서 입력 가능
	 */
	public static boolean isValidMenuCategory(String menuCategory) {
		if (menuCategory == "" || menuCategory == null) {
			return false;
		}

		String[] categoryList = { "한식", "중식", "일식", "양식", "육류", "해산물", "찜/탕", "분식", "치킨", "피자", "기타" };
		// 익명 객체를 생성하여, 배열을 스트림으로 변경후 람다식으로 유효성 확인
		return Arrays.stream(categoryList).anyMatch(menuCategory::equals);
	}

	/**
	 * id와 inputPw로 pw의 유효성을 확인하는 메서드입니다.
	 * @param id
	 * @param inputPw
	 * @return 모든 조건을 만족하면 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidPwWithInput(String id, String inputPw) {
		for (Member m : Data.memberList) {
			if (m.getId().equals(id)) {
				if (m.getPw().equals(inputPw)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 주어진 문자가 Y/y인지 여부를 확인하는 메서드입니다.
	 * @param string
	 * @return 매개변수 값이 Y/y인 경우 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidYorN(String string) {
		if (string.equalsIgnoreCase("Y")) {
			return true;
		}
		return false;
	}

	
	/**
	 * 업체 주소의 유효성을 검사하고, 전체 주소를 반환하는 메서드입니다.
	 * kakaoMap OpenApi 사용
	 * @param address
	 * @return
	 */
	public static String isValidAddress(String address) {
		if (address == "" || address == null) {
			return null;
		}
		String returnAddress = null;
		if ((returnAddress=getCoordinateByAddress(address))!=null) {
			return returnAddress;
		}
		return null;
	}

	/**
	 * 회원으로 부터 주소를 입력 받고, kakaoMap OpenApi 호출 전 인코딩하는 메서드입니다.
	 * @param inputAddress
	 * @return
	 */
	public static String getCoordinateByAddress(String inputAddress) {
		Scanner scan = new Scanner(System.in);
		MainController mainController = new MainController();

		String checkAddress = inputAddress;
		String address = null;

		// 입력값 인코딩 테스트
		try {
			//사용자 입력값 인코딩
			address = URLEncoder.encode(inputAddress, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		// API키 변수 설정
		String apiKEY = "KakaoAK " + "24f2cb271ab48a4e3995714610edcd7d";
		String apiURL = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address
				+ "&analyze_type=similar&page=1&size=10"; // 사용자 입력값 전달, OpenApi 정보 요청

		// 요청헤더 생성
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", apiKEY);
		String responseBody = get(apiURL, requestHeaders);

		try {
			
			JSONParser parser = new JSONParser();
			JSONObject geoData = (JSONObject) parser.parse(responseBody);
			JSONArray documents = (JSONArray) geoData.get("documents");
			for (Object coodinate : documents) {
				String addressName = (String) ((JSONObject) coodinate).get("address_name");
				String y = (String) ((JSONObject) coodinate).get("y");
				String x = (String) ((JSONObject) coodinate).get("x");
				System.out.println("입력하신 주소로 검색한 결과입니다.");
				System.out.println();
				System.out.printf("[%s]\n", addressName);
				System.out.println();
				boolean loop = true;
				// 메뉴 선택창 출력
				while(loop) {
				System.out.println("1. 해당 주소 등록");
				System.out.println("2. 다른 주소 검색");
				System.out.println("0. 메인 화면 이동");
				System.out.print("선택(번호) : ");
					int number = scan.nextInt();
						switch (number) {
						case 1:
							System.out.println("해당 주소로 등록합니다.");
							return addressName;
						case 2:
							System.out.println("주소 입력 화면으로 이동합니다.");
							return null;
						case 0:
							System.out.println("메인 화면으로 이동합니다.");
							mainController.start();
							break;
						default:
							System.out.println("1,2,0만 입력 가능합니다.");
							break;
						}
				}
			}

		} catch (Exception e) {
			System.out.println("GetCoodinateTest");
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * getCoordinateByAddress()메서드에서 요청헤더 생성합니다.
	 * 또한, 정상 호출 여부를 확인하는 메서드입니다.
	 * @param apiURL
	 * @param requestHeaders
	 * @return 정상호출시 readBody(con.getInputStream()), 호출 오류시 readBody(con.getErrorStream())를 반환합니다.
	 */
	private static String get(String apiURL, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiURL);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	
	/**
	 * kakaoMap OpenApi와 서버연결을 확인하는 메서드입니다.
	 * @param apiURL
	 * @return URL주소의 원격 객체에 접근하여, 통신할 수 있는 URLConnection 객체를 리턴합니다.
	 */
	private static HttpURLConnection connect(String apiURL) {
		try {
			URL url = new URL(apiURL);
			
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
		}
	}

	/**
	 * 서버의 응답을 받아오는 메서드 입니다.
	 * @param body
	 * @return 서버의 응답을 한줄씩 추가하여 responseBody.toString()를 반환합니다.
	 */
	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

	
	/**
	 * 상세주소의 유효성을 검사하는 메서드입니다.
	 *  1. 한글, 영어, 득수문자: ~()-_@ 입력가능
	 *  2. 한 글자 이상 작성 필수
	 *  3.특수문자만으로 작성 불가능
	 * @param detailAddress
	 * @return 조건에 맞게 작성한 경우 true, 아닌 경우 false를 반환합니다.
	 */
	public static boolean isValidDetailAddress(String detailAddress) {

		return Pattern.matches("^[가-힣a-zA-Z0-9]([가-힣a-zA-Z0-9~()-_@\\s])*$", detailAddress);

	}

}
