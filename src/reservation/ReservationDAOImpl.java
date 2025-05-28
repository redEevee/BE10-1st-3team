package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public boolean createReservation(ReservationDTO reservation) throws SQLException {
		String sql = "INSERT INTO reservation (id, user_id, screening_id, seat_id, status) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, reservation.getId());
			pstmt.setString(2, reservation.getUser_id());
			pstmt.setString(3, reservation.getScreening_id());
			pstmt.setString(4, reservation.getSeat_id());
			pstmt.setString(5, reservation.getStatus());

			return pstmt.executeUpdate() > 0;
		}
	}

	@Override
	public List<ReservationDTO> getReservationsByUserId(String userId) throws SQLException {
		List<ReservationDTO> reservationList = new ArrayList<>();

		// JOIN을 사용한 확장된 SQL
		String sql = """
				    SELECT r.id, r.user_id, r.screening_id, r.seat_id, r.status, r.reserved_at,
				           m.title as movie_title, m.genre, m.rating,
				           s.theater_name, s.start_time, s.end_time,
				           st.seat_number
				    FROM reservation r
				    JOIN screening s ON r.screening_id = s.id
				    JOIN movie m ON s.movie_id = m.id
				    JOIN seat st ON r.seat_id = st.id
				    WHERE r.user_id = ?
				    ORDER BY r.reserved_at DESC
				""";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ReservationDTO reservation = new ReservationDTO();

				// 기존 필드들
				reservation.setId(rs.getString("id"));
				reservation.setUser_id(rs.getString("user_id"));
				reservation.setScreening_id(rs.getString("screening_id"));
				reservation.setSeat_id(rs.getString("seat_id"));
				reservation.setStatus(rs.getString("status"));
				reservation.setReserved_at(rs.getString("reserved_at"));

				// 추가 필드들
				reservation.setMovieTitle(rs.getString("movie_title"));
				reservation.setGenre(rs.getString("genre"));
				reservation.setRating(rs.getString("rating"));
				reservation.setTheaterName(rs.getString("theater_name"));
				reservation.setStartTime(rs.getString("start_time"));
				reservation.setEndTime(rs.getString("end_time"));
				reservation.setSeatNumber(rs.getString("seat_number"));

				reservationList.add(reservation);
			}
		}

		return reservationList;
	}

	@Override
	public ReservationDTO getReservationById(String reservationId) throws SQLException {
		String sql = "SELECT id, user_id, screening_id, seat_id, status, reserved_at "
				+ "FROM reservation WHERE id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, reservationId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ReservationDTO reservation = new ReservationDTO();
				reservation.setId(rs.getString("id"));
				reservation.setUser_id(rs.getString("user_id"));
				reservation.setScreening_id(rs.getString("screening_id"));
				reservation.setSeat_id(rs.getString("seat_id"));
				reservation.setStatus(rs.getString("status"));
				reservation.setReserved_at(rs.getString("reserved_at"));
				return reservation;
			}
		}

		return null;
	}

	@Override
	public boolean updateReservationStatus(String reservationId, String status) throws SQLException {
		String sql = "UPDATE reservation SET status = ? WHERE id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, status);
			pstmt.setString(2, reservationId);

			return pstmt.executeUpdate() > 0;
		}
	}
}