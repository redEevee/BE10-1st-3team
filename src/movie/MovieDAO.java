// movie.MovieDAO.java (인터페이스)
package movie;

import java.sql.SQLException;
import java.util.List;

// DB 연결 유틸리티 클래스가 있다고 가정
// import util.DBUtil; // UserDAO와 동일한 DBUtil 사용

public interface MovieDAO {
    // 영화 삽입 (id는 AUTO_INCREMENT이므로 DTO에서 명시적으로 받지 않고 DB에서 생성)
    int insertMovie(MovieDTO movie) throws SQLException;
    
    // 모든 영화 조회
    List<MovieDTO> getAllMovies() throws SQLException;
    
    // 특정 ID의 영화 조회
    MovieDTO getMovieById(String movieId) throws SQLException; // id가 String이므로 String으로 받음
    
    // 영화 정보 업데이트
    int updateMovie(MovieDTO movie) throws SQLException;
    
    // 영화 삭제
    int deleteMovie(String movieId) throws SQLException; // id가 String이므로 String으로 받음
}