package user_profile;

import java.sql.SQLException;
import java.util.Scanner;

import movie.MovieController;

public class UserSystem {
	private static Scanner key = new Scanner(System.in);

	private static UserDTO loggedInUser = null;

	public static void main(String[] args) {
		UserController userController = new UserController();

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                                      ");
		System.out.println("      🎬 3조 시네마에 오신걸 환영합니다! 🎬      ");
		System.out.println("                                      ");

		while (loggedInUser == null) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("  1.  로그인                             ");
			System.out.println("  2.  회원가입                            ");
			System.out.println("  0.  종료                               ");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("=> 원하는 작업을 선택하세요: ");

			int choice = getMenuChoice();

			switch (choice) {
			case 1:
				loggedInUser = userController.login();
				if (loggedInUser != null) {
					System.out.println("             " + loggedInUser.getName() + "님 환영합니다.");
				}
				break;
			case 2:
				boolean signupSuccess = userController.signupUser();
				if (signupSuccess) {
					displayMessage("회원가입이 완료되었습니다. 로그인 해주세요.");
				} else {
					displayMessage("회원가입 실패. 다시 시도해주세요.");
				}
				break;
			case 0:
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("                  종료                  ");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.exit(0);
			default:
				displayMessage("없는 메뉴입니다. 다시 선택해주세요.");
			}
		}

		if (loggedInUser != null) {
			try {
				showMainMenu();
			} catch (SQLException e) {
				displayMessage("메인 메뉴 실행 중 데이터베이스 오류 발생: " + e.getMessage());
				e.printStackTrace();
			}
		}

		key.close();
	}

	// 로그인 후 사용자에게 보여줄 메인 메뉴
	public static void showMainMenu() throws SQLException {
		MovieController movieController = new MovieController(loggedInUser);
		UserController userController = new UserController();

		while (loggedInUser != null) { // 로그인 상태일 때만 메뉴 표시
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("                메인페이지                ");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("  1.  영화 목록 조회");
			System.out.println("  2.  영화 예매");
			System.out.println("  3.  내 예매 내역 조회");
			System.out.println("  4.  회원 정보 관리 (마이페이지)");
			System.out.println("  5.  로그아웃");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("=> 원하는 작업을 선택하세요: ");
			int menuChoice = getMenuChoice();
			switch (menuChoice) {
			case 1:
				movieController.movieSelect();
				break;
			case 2:
				movieController.reserveMovie();
				break;
			case 3:
				movieController.showMyReserve();
				break;
			case 4:
				showMyPageMenu(userController);
				break;
			case 5:
				displayMessage("로그아웃 되었습니다.");
				loggedInUser = null; // 로그인 상태 해제
				return;
			default:
				displayMessage("잘못된 선택입니다. 다시 선택해주세요.");
			}
		}
	}

	public static void showMyPageMenu(UserController userController) throws SQLException {
		while (true) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("              회원 정보 관리             ");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("  1.  내 정보 보기");
			System.out.println("  2.  회원 정보 수정");
			System.out.println("  3.  회원 탈퇴");
			System.out.println("  0.  이전 메뉴로 돌아가기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("=> 원하는 작업을 선택하세요: ");

			int myPageChoice = getMenuChoice();

			switch (myPageChoice) {
			case 1:
				System.out.println("아이디:  " + loggedInUser.getId());
				System.out.println("이름:  " + loggedInUser.getName());
				System.out.println("전화번호:  " + loggedInUser.getPhone());
				System.out.println("생년월일:  " + loggedInUser.getBirth_date());
				break;
			case 2:
				UserDTO result = userController.updateUserProfile(loggedInUser);
				if (result != null) {
					displayMessage("회원 정보 수정 완료!");
					loggedInUser = result;
				} else {
					displayMessage("회원 정보 수정 실패!");
				}
				break;
			case 3:
				if (confirmAccountDeletion(userController)) {
					return;
				}
				break;
			case 0:
				displayMessage("이전 메뉴로 돌아갑니다.");
				return;
			default:
				displayMessage("잘못된 선택입니다. 다시 선택해주세요.");
			}
		}
	}

	private static boolean confirmAccountDeletion(UserController userController) throws SQLException {
		System.out.println("회원 탈퇴를 진행하시겠습니까?");
		System.out.println("탈퇴 시 모든 예매 내역이 삭제됩니다.");
		System.out.println();
		System.out.print("비밀번호를 입력하여 탈퇴를 확인해주세요: ");
		String passwordConfirm = key.nextLine();

		if (userController.confirmPassword(loggedInUser.getId(), passwordConfirm)) {
			boolean deleted = userController.deleteUserProfile(loggedInUser.getId());
			if (deleted) {
				displayMessage("회원 탈퇴가 완료되었습니다. 이용해주셔서 감사합니다.");
				loggedInUser = null;
				System.exit(0);
				return true;
			} else {
				displayMessage("회원 탈퇴 처리 중 오류가 발생했습니다.");
			}
		} else {
			displayMessage("비밀번호가 일치하지 않습니다. 탈퇴가 취소되었습니다.");
		}
		return false;
	}

	private static int getMenuChoice() {
		while (true) {
			try {
				return Integer.parseInt(key.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("숫자를 입력해주세요: ");
			}
		}
	}

	private static void displayMessage(String message) {
		System.out.println();
		System.out.println(message);
		System.out.println();
	}
}