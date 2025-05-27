// movie.MovieDAOImpl.java
package movie;

import util.DBUtil; // DB 연결 유틸리티
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {

    @Override
    public int insertMovie(MovieDTO movie) throws SQLException {
        // id는 AUTO_INCREMENT이므로 SQL 쿼리에 id를 명시하지 않습니다.
        String sql = "INSERT INTO movie (title, genre, duration, rating, description, release_date) VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setInt(3, movie.getDuration());
            pstmt.setString(4, movie.getRating());
            pstmt.setString(5, movie.getDescription());
            pstmt.setDate(6, movie.getRelease_date());
            result = pstmt.executeUpdate();
        }
        return result;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieList = new ArrayList<>();
        String sql = "SELECT id, title, genre, duration, rating, description, release_date, created_at FROM movie";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                MovieDTO movie = new MovieDTO();
                movie.setId(String.valueOf(rs.getInt("id"))); // DB의 int를 String으로 변환하여 DTO에 설정
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDuration(rs.getInt("duration"));
                movie.setRating(rs.getString("rating"));
                movie.setDescription(rs.getString("description"));
                movie.setRelease_date(rs.getDate("release_date"));
                movie.setCreated_at(rs.getTimestamp("created_at"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("영화 목록을 가져오는 중 오류 발생: " + e.getMessage());
            e.printStackTrace(); // 개발 중에는 스택 트레이스 출력, 운영 시에는 로깅 시스템 활용
        }
        return movieList;
    }

    @Override
    public MovieDTO getMovieById(String movieId) throws SQLException {
        // DB의 id는 INT이므로, String으로 받은 movieId를 int로 변환하여 사용합니다.
        int idAsInt = Integer.parseInt(movieId); // String -> int 변환
        
        String sql = "SELECT id, title, genre, duration, rating, description, release_date, created_at FROM movie WHERE id = ?";
        MovieDTO movie = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAsInt);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    movie = new MovieDTO();
                    movie.setId(String.valueOf(rs.getInt("id"))); // DB의 int를 String으로 변환하여 DTO에 설정
                    movie.setTitle(rs.getString("title"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setDuration(rs.getInt("duration"));
                    movie.setRating(rs.getString("rating"));
                    movie.setDescription(rs.getString("description"));
                    movie.setRelease_date(rs.getDate("release_date"));
                    movie.setCreated_at(rs.getTimestamp("created_at"));
                }
            }
        }
        return movie;
    }

    @Override
    public int updateMovie(MovieDTO movie) throws SQLException {
        // 예시: 영화 제목, 장르, 상영 시간, 등급, 설명, 개봉일 수정
        // id는 String이므로, Integer.parseInt()를 사용합니다.
        String sql = "UPDATE movie SET title = ?, genre = ?, duration = ?, rating = ?, description = ?, release_date = ? WHERE id = ?";
        int result = 0;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setInt(3, movie.getDuration());
            pstmt.setString(4, movie.getRating());
            pstmt.setString(5, movie.getDescription());
            pstmt.setDate(6, movie.getRelease_date());
            pstmt.setInt(7, Integer.parseInt(movie.getId())); // String -> int 변환
            result = pstmt.executeUpdate();
        }
        return result;
    }

    @Override
    public int deleteMovie(String movieId) throws SQLException {
        // id는 String이므로, Integer.parseInt()를 사용합니다.
        int idAsInt = Integer.parseInt(movieId); // String -> int 변환
        
        String sql = "DELETE FROM movie WHERE id = ?";
        int result = 0;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAsInt);
            result = pstmt.executeUpdate();
        }
        return result;
    }
}