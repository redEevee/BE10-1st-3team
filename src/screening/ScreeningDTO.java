// movie.MovieDTO.java
package screening;

import java.sql.Date;
import java.sql.Timestamp;

public class ScreeningDTO {
	private String id;
	private String movie_id;
	private String theater_name;
	private String start_time;
	private String end_time;
	private Timestamp created_at;

	public ScreeningDTO() {
		super();
	}

	public ScreeningDTO(String id, String movie_id, String theater_name, String start_time, String end_time,
			Timestamp created_at) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.theater_name = theater_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.created_at = created_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String string) {
		this.start_time = string;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "ScreeningDTO [id=" + id + ", movie_id=" + movie_id + ", theater_name=" + theater_name + ", start_time="
				+ start_time + ", end_time=" + end_time + ", created_at=" + created_at + "]";
	}

}