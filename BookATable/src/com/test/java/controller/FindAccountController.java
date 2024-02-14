/**
 * FindAccountController 클래스는 계정(ID 또는 비밀번호)을 찾는 기능을 담당하는 컨트롤러 클래스입니다.
 * 사용자로부터 찾고자 하는 계정 정보를 입력받고, 해당 정보를 출력합니다.
 */
public class FindAccountController {

    /**
     * 사용자로부터 찾고자 하는 계정 정보를 입력받고, 해당 정보를 출력하는 메서드입니다.
     * 사용자가 ID를 찾을 경우 사용자의 이름과 전화번호를 입력받아 ID를 찾아 출력하고,
     * 비밀번호를 찾을 경우 사용자의 ID와 전화번호를 입력받아 비밀번호를 찾아 출력합니다.
     */
    public void findAccount() {
        FindAccountView.showSelectBox();
        int choice = FindAccountView.getSelectNum();

        String name = "";
        String phoneNumber = "";
        String id = "";
        String pw = "";

        switch (choice) {
            case 1:
                FindAccountView.showFindIdTitle();
                name = FindAccountView.getName();
                phoneNumber = FindAccountView.getPhoneNumber();
                id = MemberRepository.findId(name, phoneNumber);
                FindAccountView.showResultID(id);
                break;
            case 2:
                FindAccountView.showFindPwTitle();
                id = FindAccountView.getId();
                phoneNumber = FindAccountView.getPhoneNumber();
                pw = MemberRepository.findPw(id, phoneNumber);
                FindAccountView.showResultPw(pw);
                break;
            case 0:
                break;
            default:
                break;
        }

        View.pause();
    }
    
}
