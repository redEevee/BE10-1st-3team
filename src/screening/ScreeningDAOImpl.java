// movie.MovieDAOImpl.java
package screening;

import util.DBUtil; // DB 연결 유틸리티
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreeningDAOImpl implements ScreeningDAO {

	@Override
	public List<ScreeningDTO> getAllMoviesTime(String movie_id) {
		List<ScreeningDTO> screeningList = new ArrayList<>();
		String sql = "SELECT s.id, s.movie_id, s.theater_name, s.start_time, s.end_time \n" + "FROM screening s\n"
				+ "INNER JOIN movie m ON s.movie_id = m.id\n" + "WHERE m.id = " + movie_id;

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				ScreeningDTO movie = new ScreeningDTO();
				movie.setId(rs.getString("id"));
				movie.setMovie_id((rs.getString("movie_id")));
				movie.setTheater_name(rs.getString("theater_name"));
				movie.setStart_time(rs.getString("start_time"));
				movie.setEnd_time(rs.getString("end_time"));
				screeningList.add(movie);
			}
		} catch (SQLException e) {
			System.err.println("상영관 목록을 가져오는 중 오류 발생: " + e.getMessage());
			e.printStackTrace(); // 개발 중에는 스택 트레이스 출력, 운영 시에는 로깅 시스템 활용
		}
		return screeningList;
	}
}