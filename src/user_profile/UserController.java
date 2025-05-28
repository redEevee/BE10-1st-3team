package user_profile;

import java.sql.SQLException;
import java.util.Scanner;

import movie.MovieController;
import util.FormatterUtil;

public class UserController {
	Scanner key = new Scanner(System.in);
	UserDAOImpl dao = new UserDAOImpl();
	MovieController mc = new MovieController();

	public UserDTO login() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("              로그인 페이지              ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("비밀번호:");
		String password = key.next();
		UserDTO user = dao.login(id, password);
		if (user == null) {
			System.out.println("로그인 실패. \n다시 시도해주세요.");
		}
		return user;
	}

	public boolean signupUser() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("              회원가입 페이지              ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("비밀번호:");
		String pass = key.next();
		System.out.print("이름:");
		String name = key.next();
		System.out.print("전화번호:");
		String phone = key.next();
		phone = FormatterUtil.phoneFormatter(phone);
		System.out.print("생년월일:");
		String birth_date = key.next();
		birth_date = FormatterUtil.yearFormatter(birth_date);
		boolean result = false;
		if (dao.signupUser(id, name, pass, phone, birth_date) != 0) {
			result = true;
		}
		return result;
	}

	public boolean confirmPassword(String id, String passwordConfirm) {
		if (dao.login(id, passwordConfirm) != null) {
			return true;
		}
		return false;
	}

	public boolean deleteUserProfile(String id) {
		boolean result = false;
		if (dao.deleteUser(id) != 0) {
			result = true;
		}
		return result;
	}

	public UserDTO updateUserProfile(UserDTO loggedInUser) throws SQLException {
		Scanner key = new Scanner(System.in);

		while (true) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("              회원 정보 수정");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1. 아이디: " + loggedInUser.getId() + " (수정 불가)");
			System.out.println("2. 이름: " + loggedInUser.getName());
			System.out.println("3. 전화번호: " + loggedInUser.getPhone());
			System.out.println("4. 생년월일: " + loggedInUser.getBirth_date());
			System.out.println("0. 수정 완료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("수정할 메뉴를 선택해주세요: ");

			String choice = key.nextLine().trim();

			if (choice.equals("0")) {
				System.out.println("회원 정보 수정이 완료되었습니다.");
			}
			UserDTO result = null;
			if (dao.updateUser(choice, loggedInUser.getId()) != 0) {

				result = dao.getUserById(loggedInUser.getId());
			}
			return result;
		}
	}

}
