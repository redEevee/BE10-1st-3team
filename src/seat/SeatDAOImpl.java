// movie.MovieDAOImpl.java
package seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class SeatDAOImpl implements SeatDAO {

	@Override
	public List<SeatDTO> getSeatsByScreeningId(String screeningId) throws SQLException {
		List<SeatDTO> seatList = new ArrayList<>();
		String sql = "SELECT id, screening_id, seat_number, is_reserved, reserved_at "
				+ "FROM seat WHERE screening_id = ? ORDER BY seat_number";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, screeningId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				SeatDTO seat = new SeatDTO();
				seat.setId(rs.getString("id"));
				seat.setScreening_id(rs.getString("screening_id"));
				seat.setSeat_number(rs.getString("seat_number"));
				seat.setIs_reserved(rs.getBoolean("is_reserved"));
				seat.setReserved_at(rs.getString("reserved_at"));

				seatList.add(seat);
			}
		}

		return seatList;
	}

	@Override
	public boolean updateSeatReservation(String screeningId, String seatNumber, boolean isReserved)
			throws SQLException {
		String sql = "UPDATE seat SET is_reserved = ?, reserved_at = ? " + "WHERE screening_id = ? AND seat_number = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setBoolean(1, isReserved);
			if (isReserved) {
				pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			} else {
				pstmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			pstmt.setString(3, screeningId);
			pstmt.setString(4, seatNumber);

			return pstmt.executeUpdate() > 0;
		}
	}
}