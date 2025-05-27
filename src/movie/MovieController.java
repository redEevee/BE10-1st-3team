// movie.MovieController.java
package movie;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException; // SQLException import 추가

public class MovieController {
    private Scanner scanner = new Scanner(System.in);
    private MovieDAO movieDAO = new MovieDAOImpl(); // MovieDAOImpl 인스턴스 생성

    public void movieSelect() throws SQLException {
        System.out.println("----영화를 선택하세요----");
        System.out.println();

        List<MovieDTO> movies = movieDAO.getAllMovies(); // 모든 영화 목록 가져오기

        if (movies.isEmpty()) {
            System.out.println("현재 상영 중인 영화가 없습니다.");
            return;
        }

        // 영화 목록 출력
        System.out.println("============== 영화 목록 ==============");
        for (int i = 0; i < movies.size(); i++) {
            MovieDTO movie = movies.get(i);
            // MovieDTO의 id는 String이지만, 사용자에게는 순번(1부터 시작)을 보여줍니다.
            System.out.printf("%d. %s (장르: %s, 관람등급: %s, ID: %s)\n",
                              i + 1, movie.getTitle(), movie.getGenre(), movie.getRating(), movie.getId());
        }
        System.out.println("=====================================");

        MovieDTO selectedMovie = null;
        while (true) {
            System.out.print("선택할 영화의 번호를 입력하세요 (취소: 0): ");
            int selectedListIndex = -1;
            try {
                selectedListIndex = Integer.parseInt(scanner.nextLine()); // Line으로 받아서 Integer.parseInt로 처리
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue;
            }

            if (selectedListIndex == 0) {
                System.out.println("영화 선택을 취소했습니다.");
                return; // 메소드 종료
            } else if (selectedListIndex > 0 && selectedListIndex <= movies.size()) {
                selectedMovie = movies.get(selectedListIndex - 1);
                break; // 유효한 선택
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }

        System.out.println("\n선택하신 영화 정보:");
        System.out.println("ID: " + selectedMovie.getId());
        System.out.println("제목: " + selectedMovie.getTitle());
        System.out.println("장르: " + selectedMovie.getGenre());
        System.out.println("상영 시간: " + selectedMovie.getDuration() + "분");
        System.out.println("관람 등급: " + selectedMovie.getRating());
        System.out.println("개봉일: " + selectedMovie.getRelease_date());
        System.out.println("줄거리:\n" + selectedMovie.getDescription());
        System.out.println();

        // 이제 선택된 영화(selectedMovie)를 가지고 다음 단계 (예: 상영 시간표 조회)로 넘어갈 수 있습니다.
        // 예: this.showScreenings(selectedMovie.getId()); // 다음 메소드 호출 (필요시 구현)
    }

    // 새로운 영화 추가 메뉴 (예시)
    public void addMovie() {
        System.out.println("----새 영화 추가----");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("장르: ");
        String genre = scanner.nextLine();
        System.out.print("상영 시간 (분): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("관람 등급: ");
        String rating = scanner.nextLine();
        System.out.print("줄거리: ");
        String description = scanner.nextLine();
        System.out.print("개봉일 (YYYY-MM-DD): ");
        Date releaseDate = Date.valueOf(scanner.nextLine());

        // id는 DB에서 자동 생성되므로, 생성자에서는 id를 제외
        // MovieDTO movie = new MovieDTO(title, genre, duration, rating, description, releaseDate, null); // id 없음
        // 위 생성자는 MovieDTO에 없음. 기본 생성자 사용 후 setter로 설정.
        MovieDTO newMovie = new MovieDTO();
        newMovie.setTitle(title);
        newMovie.setGenre(genre);
        newMovie.setDuration(duration);
        newMovie.setRating(rating);
        newMovie.setDescription(description);
        newMovie.setRelease_date(releaseDate);

        try {
            int result = movieDAO.insertMovie(newMovie);
            if (result > 0) {
                System.out.println("영화가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("영화 추가에 실패했습니다.");
            }
        } catch (SQLException e) {
            System.err.println("영화 추가 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 영화 정보 업데이트 메뉴 (예시)
    public void updateMovieInfo() {
        System.out.println("----영화 정보 수정----");
        System.out.print("수정할 영화의 ID를 입력하세요: ");
        String movieId = scanner.nextLine();

        try {
            MovieDTO movieToUpdate = movieDAO.getMovieById(movieId);
            if (movieToUpdate == null) {
                System.out.println("해당 ID의 영화를 찾을 수 없습니다.");
                return;
            }

            System.out.println("현재 제목: " + movieToUpdate.getTitle() + " (변경하지 않으려면 엔터)");
            String newTitle = scanner.nextLine();
            if (!newTitle.isEmpty()) movieToUpdate.setTitle(newTitle);

            System.out.println("현재 장르: " + movieToUpdate.getGenre() + " (변경하지 않으려면 엔터)");
            String newGenre = scanner.nextLine();
            if (!newGenre.isEmpty()) movieToUpdate.setGenre(newGenre);

            // 다른 필드들도 유사하게 수정 로직 추가 가능

            int result = movieDAO.updateMovie(movieToUpdate);
            if (result > 0) {
                System.out.println("영화 정보가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("영화 정보 수정에 실패했습니다.");
            }
        } catch (SQLException e) {
            System.err.println("영화 정보 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 영화 삭제 메뉴 (예시)
    public void deleteMovie() {
        System.out.println("----영화 삭제----");
        System.out.print("삭제할 영화의 ID를 입력하세요: ");
        String movieId = scanner.nextLine();

        try {
            int result = movieDAO.deleteMovie(movieId);
            if (result > 0) {
                System.out.println("영화가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("영화 삭제에 실패했습니다. ID를 확인해주세요.");
            }
        } catch (SQLException e) {
            System.err.println("영화 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}