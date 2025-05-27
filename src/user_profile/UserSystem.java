package user_profile;

import java.util.Scanner;

public class UserSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("********3조시네마********");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");

		System.out.print("원하는 작업을 선택하세요:");
		int choice = key.nextInt();
		if (choice == 1) {
			login();
		} else {
			userInsert();
		}
//		show(choice);
	}

	public static void login() {
		UserController ui = new UserController();
		ui.login();
	}

	public static void userInsert() {
		UserController ui = new UserController();
		ui.userInsert();
	}

	// 로그인 후 사용하는 뷰 부분
	public static void show(int choice) {
		UserController ui = new UserController();
		switch (choice) {
		case 1:
//			ui.insertMenu();
			break;
		case 2:
//			ui.selectMenu();
			break;
		}
	}
}
