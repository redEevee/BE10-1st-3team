package reservation;

public class ReservationDTO {
	private String id;
	private String user_id;
	private String screening_id;
	private String seat_id;
	private String status;
	private String reserved_at;
	private String movieTitle;
	private String genre;
	private String rating;
	private String theaterName;
	private String startTime;
	private String endTime;
	private String seatNumber;

	public ReservationDTO() {
	}

	public ReservationDTO(String id, String user_id, String screening_id, String seat_id, String status,
			String reserved_at) {
		this.id = id;
		this.user_id = user_id;
		this.screening_id = screening_id;
		this.seat_id = seat_id;
		this.status = status;
		this.reserved_at = reserved_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getScreening_id() {
		return screening_id;
	}

	public void setScreening_id(String screening_id) {
		this.screening_id = screening_id;
	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReserved_at() {
		return reserved_at;
	}

	public void setReserved_at(String reserved_at) {
		this.reserved_at = reserved_at;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", user_id=" + user_id + ", screening_id=" + screening_id + ", seat_id="
				+ seat_id + ", status=" + status + ", reserved_at=" + reserved_at + ", movieTitle=" + movieTitle
				+ ", genre=" + genre + ", rating=" + rating + ", theaterName=" + theaterName + ", startTime="
				+ startTime + ", endTime=" + endTime + ", seatNumber=" + seatNumber + "]";
	}

}