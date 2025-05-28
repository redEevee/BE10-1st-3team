package seat;

public class SeatDTO {
	private String id;
	private String screening_id;
	private String seat_number;
	private boolean is_reserved;
	private String reserved_at;

	public SeatDTO() {
	}

	public SeatDTO(String id, String screening_id, String seat_number, boolean is_reserved, String reserved_at) {
		this.id = id;
		this.screening_id = screening_id;
		this.seat_number = seat_number;
		this.is_reserved = is_reserved;
		this.reserved_at = reserved_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScreening_id() {
		return screening_id;
	}

	public void setScreening_id(String screening_id) {
		this.screening_id = screening_id;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public boolean isIs_reserved() {
		return is_reserved;
	}

	public void setIs_reserved(boolean is_reserved) {
		this.is_reserved = is_reserved;
	}

	public String getReserved_at() {
		return reserved_at;
	}

	public void setReserved_at(String reserved_at) {
		this.reserved_at = reserved_at;
	}

	@Override
	public String toString() {
		return "SeatDTO [id=" + id + ", screening_id=" + screening_id + ", seat_number=" + seat_number
				+ ", is_reserved=" + is_reserved + ", reserved_at=" + reserved_at + "]";
	}
}