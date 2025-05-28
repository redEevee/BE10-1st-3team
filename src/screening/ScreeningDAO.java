// movie.MovieDAO.java (인터페이스)
package screening;

import java.sql.SQLException;
import java.util.List;

// DB 연결 유틸리티 클래스가 있다고 가정
// import util.DBUtil; // UserDAO와 동일한 DBUtil 사용

public interface ScreeningDAO {

	// 모든 영화 시간 조회
	List<ScreeningDTO> getAllMoviesTime(String movie_id) throws SQLException;

}