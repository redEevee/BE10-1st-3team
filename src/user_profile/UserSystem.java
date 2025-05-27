// user_profile.UserSystem.java
package user_profile;

import java.sql.SQLException;
import java.util.Scanner;
import movie.MovieController; // 영화 관련 기능 호출을 위해 import
import movie.MovieDTO; // 영화 선택 후 MovieDTO 객체를 다루기 위해 import

public class UserSystem {
    // Scanner를 클래스 전체에서 재활용하도록 static으로 선언하고, 하나만 사용
    private static Scanner key = new Scanner(System.in);
    
    // 현재 로그인된 사용자 정보를 저장하는 필드 (애플리케이션 전반에서 사용 가능하도록 static)
    private static UserDTO loggedInUser = null;

    public static void main(String[] args) {
        UserController userController = new UserController();
        
        // 로그인될 때까지 또는 프로그램 종료될 때까지 반복
        while (loggedInUser == null) { 
            System.out.println("********3조시네마********");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("0. 종료"); // 종료 옵션 추가

            System.out.print("원하는 작업을 선택하세요:");
            int choice = -1;
            try {
                choice = Integer.parseInt(key.nextLine()); // 한 줄 전체를 읽고 int로 변환
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue; // 다시 처음으로 돌아가서 입력받음
            }

            if (choice == 1) {
                // 로그인 시도: 성공 시 UserDTO 객체 반환, 실패 시 null 반환
                loggedInUser = userController.login(); 
                // 로그인 실패 시 (loggedInUser == null) while 루프가 다시 실행됨
            } else if (choice == 2) {
                boolean signupSuccess;
                signupSuccess = userController.userInsert();
				if (signupSuccess) {
				    System.out.println("회원가입이 완료되었습니다. 로그인 해주세요.");
				    // 회원가입 성공 후 다시 로그인 메뉴로 돌아감
				} else {
				    System.out.println("회원가입 실패. 다시 시도해주세요.");
				}
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break; // 프로그램 종료 (while 루프 탈출)
            } else {
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }

        // 로그인 성공 시 (loggedInUser가 null이 아닐 때) 메인 메뉴로 진입
        if (loggedInUser != null) {
            try {
                showMainMenu();
            } catch (SQLException e) {
                System.err.println("메인 메뉴 실행 중 데이터베이스 오류 발생: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        // 애플리케이션 종료 시 Scanner 자원 해제
        key.close(); 
    }

    // 로그인 후 사용자에게 보여줄 메인 메뉴
    public static void showMainMenu() throws SQLException {
        MovieController movieController = new MovieController();
        UserController userController = new UserController();

        System.out.println("\n********메인 메뉴********");
        while (loggedInUser != null) { // 로그인 상태일 때만 메뉴 표시
            System.out.println("1. 영화 목록 조회 및 선택");
            System.out.println("2. 영화 예매");
            System.out.println("3. 내 예매 내역 조회");
            System.out.println("4. 회원 정보 관리 (마이페이지)");
            System.out.println("5. 로그아웃");
            // 관리자용 메뉴는 필요시 추가
            // if (loggedInUser.isAdmin()) { // UserDTO에 isAdmin() 메소드나 역할 필드 필요
            //     System.out.println("6. 영화 관리 (추가/수정/삭제)");
            // }

            System.out.print("원하는 작업을 선택하세요:");
            int menuChoice = -1;
            try {
                menuChoice = Integer.parseInt(key.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue;
            }

            switch (menuChoice) {
                case 1:
                    movieController.movieSelect(); // 영화 목록 조회 및 선택 기능 호출
                    // 영화 선택 후 다음 단계 (상영 시간표 조회 등)로 연결될 수 있도록 MovieController에서 로직 확장 필요
                    break;
                case 2:
                    System.out.println("영화 예매 기능 실행 예정...");
                    // 예매 로직 호출: 예) movieController.reserveMovie(loggedInUser);
                    break;
                case 3:
                    System.out.println("내 예매 내역 조회 기능 실행 예정...");
                    // 예매 내역 조회 로직 호출: 예) userController.viewMyReservations(loggedInUser.getId());
                    break;
                case 4:
                    showMyPageMenu(userController); // 마이페이지 서브 메뉴 호출
                    break;
                case 5:
                    System.out.println("로그아웃 되었습니다.");
                    loggedInUser = null; // 로그인 상태 해제
                    return; // showMainMenu 메소드 종료 -> main 메소드의 while(loggedInUser == null) 루프로 돌아감
                /*
                case 6: // 관리자 메뉴 예시
                    if (loggedInUser.isAdmin()) {
                        showAdminMovieMenu(movieController);
                    } else {
                        System.out.println("권한이 없습니다.");
                    }
                    break;
                */
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
            System.out.println(); // 메뉴 구분 위한 줄 바꿈
        }
    }

    // 마이페이지 서브 메뉴
    public static void showMyPageMenu(UserController userController) throws SQLException {
        while (true) {
            System.out.println("\n--- 회원 정보 관리 ---");
            System.out.println("1. 내 정보 보기");
            System.out.println("2. 회원 정보 수정");
            System.out.println("3. 회원 탈퇴");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("원하는 작업을 선택하세요:");
            int myPageChoice = -1;
            try {
                myPageChoice = Integer.parseInt(key.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue;
            }

            switch (myPageChoice) {
                case 1:
                    userController.myPage(loggedInUser); // 내 정보 보기
                    break;
                case 2:
                    // 회원 정보 수정 (loggedInUser 객체를 업데이트하도록 UserController에서 구현)
                    if (userController.deleteUserProfile(loggedInUser)) {
                        System.out.println("회원 정보 수정 완료!");
                    } else {
                        System.out.println("회원 정보 수정 실패!");
                    }
                    break;
                case 3:
                    if (loggedInUser != null) {
                        System.out.print("비밀번호를 다시 입력하여 탈퇴를 확인해주세요: ");
                        String passwordConfirm = key.nextLine();
                        // 비밀번호 일치 여부 확인 (UserDAO에서 검증)
                        if (userController.confirmPassword(loggedInUser.getId(), passwordConfirm)) { // UserController에 메소드 추가 필요
                            boolean deleted = userController.deleteUserProfile(loggedInUser.getId());
                            if (deleted) {
                                loggedInUser = null; // 탈퇴 성공 시 로그인 상태 해제
                                System.out.println("회원 탈퇴가 완료되었습니다. 프로그램을 종료합니다.");
                                // return을 두 번 사용하여 main 메뉴와 main의 while 루프까지 모두 종료
                                System.exit(0); // 프로그램 강제 종료
                            }
                        } else {
                            System.out.println("비밀번호가 일치하지 않습니다. 탈퇴가 취소되었습니다.");
                        }
                    } else {
                        System.out.println("로그인된 사용자 정보가 없어 탈퇴할 수 없습니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return; // 현재 루프 (마이페이지 메뉴) 종료
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
    /*
    // 관리자용 영화 관리 서브 메뉴 (필요시 활성화)
    public static void showAdminMovieMenu(MovieController movieController) {
        while (true) {
            System.out.println("\n--- 영화 관리 (관리자) ---");
            System.out.println("1. 영화 추가");
            System.out.println("2. 영화 정보 수정");
            System.out.println("3. 영화 삭제");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("원하는 작업을 선택하세요:");
            int adminMovieChoice = -1;
            try {
                adminMovieChoice = Integer.parseInt(key.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue;
            }

            switch (adminMovieChoice) {
                case 1:
                    movieController.addMovie();
                    break;
                case 2:
                    movieController.updateMovieInfo();
                    break;
                case 3:
                    movieController.deleteMovie();
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
    */
}