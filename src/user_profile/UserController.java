package user_profile;

import java.util.Scanner;

import util.FormatterUtil;

public class UserController {
	Scanner key = new Scanner(System.in);
	UserDAOImpl dao = new UserDAOImpl();

	public void login() {
		System.out.println("*******로그인페이지********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("비밀번호:");
		String password = key.next();
		UserDTO user = dao.login(id, password);
		if (user != null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("아이디가 존재하지 않습니다. \n다시 시도해주세요.");
		}
	}

	public void userInsert() {
		System.out.println("*******회원가입페이지********");
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
		int result = dao.userInsert(id, name, pass, phone, birth_date);
		if (result != 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
	}
}
