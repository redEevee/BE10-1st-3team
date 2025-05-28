package movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import reservation.ReservationDAO;
import reservation.ReservationDAOImpl;
import reservation.ReservationDTO;
import screening.ScreeningDAO;
import screening.ScreeningDAOImpl;
import screening.ScreeningDTO;
import seat.SeatDAO;
import seat.SeatDAOImpl;
import seat.SeatDTO;
import user_profile.UserDTO;

public class MovieController {
	private Scanner scanner = new Scanner(System.in);
	private MovieDAO movieDAO = new MovieDAOImpl();
	private ScreeningDAO screeningDAO = new ScreeningDAOImpl();
	private SeatDAO seatDAO = new SeatDAOImpl();
	private ReservationDAO reservationDAO = new ReservationDAOImpl();
	private UserDTO currentUser; // 현재 로그인된 사용자

	// 생성자 - 로그인된 사용자 정보를 받음
	public MovieController() {
		this.currentUser = null;
	}

	public MovieController(UserDTO user) {
		this.currentUser = user;
	}

	// 현재 사용자 설정 메서드
	public void setCurrentUser(UserDTO user) {
		this.currentUser = user;
	}

	public void movieSelect() throws SQLException {
		MovieDTO selectedMovie = selectMovie("상세조회");
		if (selectedMovie != null) {
			displayMovieDetails(selectedMovie);
		}
	}

	public void reserveMovie() throws SQLException {
		if (currentUser == null) {
			System.out.println("로그인이 필요한 서비스입니다.");
			return;
		}

		MovieDTO selectedMovie = selectMovie("예매");
		if (selectedMovie == null)
			return;

		ScreeningDTO selectedScreening = selectScreening(selectedMovie.getId());
		if (selectedScreening == null)
			return;

		displayScreeningInfo(selectedMovie, selectedScreening);

		// 간단한 예매 프로세스
		simpleReservation(selectedScreening.getId());
	}

	// 간단한 예매 프로세스
	private void simpleReservation(String screeningId) throws SQLException {
		List<SeatDTO> availableSeats = getAvailableSeats(screeningId);

		if (availableSeats.isEmpty()) {
			System.out.println("예약 가능한 좌석이 없습니다.");
			return;
		}

		// 좌석 현황 표시
		displaySimpleSeatLayout(screeningId);

		// 좌석 선택 (하나만)
		String selectedSeat = selectSingleSeat(availableSeats);
		if (selectedSeat == null) {
			System.out.println("예매를 취소했습니다.");
			return;
		}

		// 예매 확인 및 처리
		if (confirmAndProcessSingle(selectedSeat, screeningId)) {
			System.out.println("예매가 완료되었습니다!");
		}
	}

	private List<SeatDTO> getAvailableSeats(String screeningId) throws SQLException {
		List<SeatDTO> allSeats = seatDAO.getSeatsByScreeningId(screeningId);
		List<SeatDTO> availableSeats = new ArrayList<>();

		for (SeatDTO seat : allSeats) {
			if (!seat.isIs_reserved()) {
				availableSeats.add(seat);
			}
		}

		return availableSeats;
	}

	private void displaySimpleSeatLayout(String screeningId) throws SQLException {
		List<SeatDTO> seats = seatDAO.getSeatsByScreeningId(screeningId);
		Map<String, SeatDTO> seatMap = new HashMap<>();

		for (SeatDTO seat : seats) {
			seatMap.put(seat.getSeat_number(), seat);
		}

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                🎬 좌석 현황 🎬");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		// 열 번호 출력
		System.out.print("    ");
		for (int i = 1; i <= 4; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		// 각 행 출력
		for (char row = 'A'; row <= 'D'; row++) {
			System.out.print(" " + row + "  ");
			for (int col = 1; col <= 4; col++) {
				String seatNumber = row + String.valueOf(col);
				SeatDTO seat = seatMap.get(seatNumber);

				if (seat == null) {
					System.out.print(" X ");
				} else if (seat.isIs_reserved()) {
					System.out.print(" ■ ");
				} else {
					System.out.print(" □ ");
				}
			}
			System.out.println();
		}

		System.out.println("\n□ = 예약가능  ■ = 예약됨  X = 좌석없음");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	private String selectSingleSeat(List<SeatDTO> availableSeats) {
		System.out.println("\n예약 가능한 좌석:");
		for (SeatDTO seat : availableSeats) {
			System.out.print(seat.getSeat_number() + " ");
		}
		System.out.println();

		while (true) {
			System.out.print("\n원하는 좌석을 선택하세요 (취소: 0): ");
			String input = scanner.nextLine().trim().toUpperCase();

			if (input.equals("0")) {
				return null;
			}

			// 좌석 유효성 검사
			if (isValidSeat(input, availableSeats)) {
				System.out.println(input + " 좌석을 선택했습니다.");
				return input;
			} else {
				System.out.println("선택할 수 없는 좌석입니다. 다시 입력해주세요.");
				System.out.print("사용 가능한 좌석: ");
				for (SeatDTO seat : availableSeats) {
					System.out.print(seat.getSeat_number() + " ");
				}
				System.out.println();
			}
		}
	}

	private boolean isValidSeat(String seatNumber, List<SeatDTO> availableSeats) {
		for (SeatDTO seat : availableSeats) {
			if (seat.getSeat_number().equals(seatNumber)) {
				return true;
			}
		}
		return false;
	}

	private boolean confirmAndProcessSingle(String selectedSeat, String screeningId) throws SQLException {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                예매 확인");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("선택한 좌석: " + selectedSeat);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		while (true) {
			System.out.print("예매하시겠습니까? (y/n): ");
			String confirm = scanner.nextLine().trim().toLowerCase();

			if (confirm.equals("y") || confirm.equals("yes")) {
				return processSingleReservation(selectedSeat, screeningId);
			} else if (confirm.equals("n") || confirm.equals("no")) {
				System.out.println("예매를 취소했습니다.");
				return false;
			} else {
				System.out.println("y 또는 n을 입력해주세요.");
			}
		}
	}

	private boolean processSingleReservation(String selectedSeat, String screeningId) throws SQLException {
		try {
			// 좌석 예약 상태 업데이트
			if (!seatDAO.updateSeatReservation(screeningId, selectedSeat, true)) {
				System.out.println("좌석 예약 실패");
				return false;
			}

			// 예약 정보 생성
			String reservationId = generateReservationId();
			ReservationDTO reservation = new ReservationDTO();
			reservation.setId(reservationId);
			reservation.setUser_id(currentUser.getId()); // 로그인된 사용자 ID 사용
			reservation.setScreening_id(screeningId);
			reservation.setSeat_id(getSeatIdByNumber(screeningId, selectedSeat));
			reservation.setStatus("RESERVED");

			if (!reservationDAO.createReservation(reservation)) {
				System.out.println("예약 정보 저장 실패");
				return false;
			}

			// 성공 메시지
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("                예매 완료!");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("예매자: " + currentUser.getName());
			System.out.println("예약 번호: " + reservationId);
			System.out.println("예약 좌석: " + selectedSeat);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

			return true;

		} catch (Exception e) {
			System.out.println("예매 처리 중 오류 발생: " + e.getMessage());
			return false;
		}
	}

	private String getSeatIdByNumber(String screeningId, String seatNumber) throws SQLException {
		List<SeatDTO> seats = seatDAO.getSeatsByScreeningId(screeningId);
		for (SeatDTO seat : seats) {
			if (seat.getSeat_number().equals(seatNumber)) {
				return seat.getId();
			}
		}
		return null;
	}

	private String generateReservationId() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	// 기존 공통 메서드들은 그대로 유지
	private MovieDTO selectMovie(String action) throws SQLException {
		List<MovieDTO> movies = movieDAO.getAllMovies();

		if (movies.isEmpty()) {
			System.out.println("현재 상영 중인 영화가 없습니다.");
			return null;
		}

		displayMovieList(movies);
		return getUserMovieSelection(movies, action);
	}

	private void displayMovieList(List<MovieDTO> movies) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                 영화목록                 ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for (int i = 0; i < movies.size(); i++) {
			MovieDTO movie = movies.get(i);
			System.out.printf("%d. %s (장르: %s, 관람등급: %s)\n", i + 1, movie.getTitle(), movie.getGenre(),
					movie.getRating());
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	private MovieDTO getUserMovieSelection(List<MovieDTO> movies, String action) {
		while (true) {
			System.out.printf("%s 하실 영화의 번호를 입력하세요 (취소: 0): ", action);
			int selectedIndex = getValidIntegerInput();

			if (selectedIndex == 0) {
				System.out.println("영화 선택을 취소했습니다.");
				return null;
			}

			if (selectedIndex > 0 && selectedIndex <= movies.size()) {
				return movies.get(selectedIndex - 1);
			}

			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
	}

	private ScreeningDTO selectScreening(String movieId) throws SQLException {
		List<ScreeningDTO> screenings = screeningDAO.getAllMoviesTime(movieId);

		if (screenings.isEmpty()) {
			System.out.println("해당 영화의 상영 일정이 없습니다.");
			return null;
		}

		displayScreeningList(screenings);
		return getUserScreeningSelection(screenings);
	}

	private void displayScreeningList(List<ScreeningDTO> screenings) {
		System.out.println("\n상영 시간표:");
		for (int i = 0; i < screenings.size(); i++) {
			ScreeningDTO screening = screenings.get(i);
			System.out.printf("%d. %s | %s ~ %s\n", i + 1, screening.getTheater_name(), screening.getStart_time(),
					screening.getEnd_time());
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	private ScreeningDTO getUserScreeningSelection(List<ScreeningDTO> screenings) {
		while (true) {
			System.out.print("예매 하실 상영시간 번호를 입력하세요 (취소: 0): ");
			int selectedIndex = getValidIntegerInput();

			if (selectedIndex == 0) {
				System.out.println("상영관 선택을 취소했습니다.");
				return null;
			}

			if (selectedIndex > 0 && selectedIndex <= screenings.size()) {
				return screenings.get(selectedIndex - 1);
			}

			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
	}

	private void displayMovieDetails(MovieDTO movie) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("             영화 정보");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("제목: " + movie.getTitle());
		System.out.println("장르: " + movie.getGenre());
		System.out.println("상영 시간: " + movie.getDuration() + "분");
		System.out.println("관람 등급: " + movie.getRating());
		System.out.println("개봉일: " + movie.getRelease_date());
		System.out.println("줄거리:\n" + movie.getDescription());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	private void displayScreeningInfo(MovieDTO movie, ScreeningDTO screening) {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("             예매 정보");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("영화: " + movie.getTitle());
		System.out.println("상영관: " + screening.getTheater_name());
		System.out.println("상영시간: " + screening.getStart_time() + " ~ " + screening.getEnd_time());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	private int getValidIntegerInput() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
			}
		}
	}

	public void showMyReserve() throws SQLException {
		if (currentUser == null) {
			System.out.println("로그인이 필요한 서비스입니다.");
			return;
		}

		List<ReservationDTO> myReservations = reservationDAO.getReservationsByUserId(currentUser.getId());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("              내 예매 내역");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		if (myReservations.isEmpty()) {
			System.out.println("           예매 내역이 없습니다.");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			return;
		} else {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("총 " + myReservations.size() + "건의 예매 내역이 있습니다.");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			for (int i = 0; i < myReservations.size(); i++) {
				ReservationDTO reservation = myReservations.get(i);

				System.out.printf("[%d] 예매번호: %s\n", i + 1, reservation.getId());
				System.out.println("영화: " + reservation.getMovieTitle() + " (" + reservation.getGenre() + ", "
						+ reservation.getRating() + ")");
				System.out.println("상영관: " + reservation.getTheaterName());
				System.out.println("상영시간: " + reservation.getStartTime() + " ~ " + reservation.getEndTime());
				System.out.println("좌석: " + reservation.getSeatNumber());
				System.out.println("예매일시: " + reservation.getReserved_at());

				// 상태에 따른 표시
				if ("RESERVED".equals(reservation.getStatus())) {
					System.out.println("상태: 예매 완료");
				} else if ("CANCELLED".equals(reservation.getStatus())) {
					System.out.println("상태: 예매 취소");
				}

				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
	}
}