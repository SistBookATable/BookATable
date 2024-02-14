/**
 * FindAccountView 클래스는 계정 찾기와 관련된 뷰를 담당하는 클래스입니다.
 * 사용자로부터 찾을 계정 정보와 유형을 선택받아 해당하는 입력 화면을 출력하고,
 * 결과를 보여주는 역할을 수행합니다.
 */
public class FindAccountView {

    /**
     * 계정 찾기 유형 선택 화면을 출력하는 메서드입니다.
     */
    public static void showSelectBox() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|              계정 찾기 - 찾으실 계정 정보를 선택하세요                 |");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.println("==========================================================================================");
        System.out.println();
        System.out.println("■           1. ID 찾기      \t■");
        System.out.println("■           2. PW 찾기      \t■");
        System.out.println("■           0. 돌아가기      \t■");
        System.out.println();
        System.out.println("==========================================================================================");
        System.out.println();
        System.out.print("선택(번호) : ");
    }

    /**
     * 사용자로부터 선택된 찾기 유형을 반환하는 메서드입니다.
     * @return 사용자가 선택한 찾기 유형(1: ID 찾기, 2: PW 찾기, 0: 돌아가기)
     */
    public static int getSelectNum() {
        return View.getSelectType();
    }

    /**
     * 이름 또는 대표자명을 입력받는 메서드입니다.
     * @return 사용자가 입력한 이름 또는 대표자명
     */
    public static String getName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("이름/대표자명 : ");
        return scan.nextLine();
    }

    /**
     * ID를 입력받는 메서드입니다.
     * @return 사용자가 입력한 ID
     */
    public static String getId() {
        Scanner scan = new Scanner(System.in);
        System.out.print("ID : ");
        return scan.nextLine();
    }

    /**
     * 전화번호를 입력받는 메서드입니다.
     * @return 사용자가 입력한 전화번호
     */
    public static String getPhoneNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("전화번호 : ");
        return scan.nextLine();
    }

    /**
     * ID 찾기 결과를 출력하는 메서드입니다.
     * @param id 찾은 ID (null이면 해당 정보로 가입된 이력이 없음)
     */
    public static void showResultID(String id) {
        System.out.println(id != null ? "찾으시는 ID 입니다.\n[ " + id + " ]" : "입력하신 정보로 가입된 이력이 없습니다.");
    }

    /**
     * ID 찾기 화면의 제목을 출력하는 메서드입니다.
     */
    public static void showFindIdTitle() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|        ID 찾기 - 이름/대표자명, 전화번호를 입력해주세요            |");
        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * PW 찾기 화면의 제목을 출력하는 메서드입니다.
     */
    public static void showFindPwTitle() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|           PW 찾기 - ID, 전화번호를 입력해주세요                |");
        System.out.println("└───────────────────────────────────────────────────────┘");
    }

    /**
     * PW 찾기 결과를 출력하는 메서드입니다.
     * @param pw 찾은 PW (null이면 해당 정보로 가입된 이력이 없음)
     */
    public static void showResultPw(String pw) {
        System.out.println(pw != null ? "찾으시는 PW 입니다.\n[ " + pw + " ]" : "입력하신 정보로 가입된 이력이 없습니다.");
    }

}
