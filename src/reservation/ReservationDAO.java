package reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {
	boolean createReservation(ReservationDTO reservation) throws SQLException;

	List<ReservationDTO> getReservationsByUserId(String userId) throws SQLException;

	ReservationDTO getReservationById(String reservationId) throws SQLException;

	boolean updateReservationStatus(String reservationId, String status) throws SQLException;
}