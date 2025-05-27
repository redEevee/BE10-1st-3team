// movie.MovieDTO.java
package movie;

import java.sql.Date;
import java.sql.Timestamp;

public class MovieDTO {
    private String id; // id 타입을 String으로 유지
    private String title;
    private String genre;
    private int duration;
    private String rating;
    private String description;
    private Date release_date;
    private Timestamp created_at;

    // 기본 생성자
    public MovieDTO() {
        super();
    }

    // 모든 필드를 포함하는 생성자
    public MovieDTO(String id, String title, String genre, int duration,
                    String rating, String description, Date release_date,
                    Timestamp created_at) {
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.release_date = release_date;
        this.created_at = created_at;
    }

    // id, title, genre, duration, rating, description을 포함하는 생성자 (insert 시 사용)
    public MovieDTO(String id, String title, String genre, int duration, String rating, String description) {
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
    }

    // toString() 메소드 오버라이드
    @Override
    public String toString() {
        return "MovieDTO [id=" + id + ", title=" + title + ", genre=" + genre + ", duration=" + duration + ", rating="
                + rating + ", description=" + description + ", release_date=" + release_date + ", created_at="
                + created_at + "]";
    }

    // Getter 및 Setter 메소드
    public String getId() { // 반환 타입 String
        return id;
    }

    public void setId(String id) { // 매개변수 타입 String
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}