/**
 * UserCancellationView 클래스는 사용자 회원탈퇴와 관련된 뷰를 담당하는 클래스입니다.
 * 사용자로부터 비밀번호를 입력받아 회원탈퇴를 진행합니다.
 */
public class UserCancellationView {

    /**
     * 회원탈퇴 화면을 출력하는 메서드입니다.
     */
    public static void show() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|                    회원탈퇴 - 비밀번호를 입력해주세요               |");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.println();
    }

    /**
     * 사용자로부터 비밀번호를 입력받는 메서드입니다.
     * @return 사용자가 입력한 비밀번호
     */
    public static String getPw() {
        System.out.print("비밀번호 입력: ");
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        return temp;
    }

}
