package seat;

import java.sql.SQLException;
import java.util.List;

public interface SeatDAO {

	List<SeatDTO> getSeatsByScreeningId(String screeningId) throws SQLException;

	boolean updateSeatReservation(String screeningId, String seatNumber, boolean isReserved) throws SQLException;

}