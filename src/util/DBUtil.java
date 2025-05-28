package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 드라이버 로딩, 커넥션, 자원반납 등
// 모든 DAO 클래스에서 공통으로 처리하는 기능을 정의
// 1. 드라이버 로딩
//   - 한 번 실행
//   - static 블럭
// 2. DB서버 연결
//   - SQL문이 실행될 때마다 항상 DB서버에 먼저 연결해야 하므로 메소드마다 정의
//   - 메도스로 정의
//   - Connection을 리턴
//   - static메소드로 정의
// 3. 자원반납
//   - 메소드마다 작업이 끝나면 모든 자원을 반납하도록 처리
//   - 메소드를 정의
//   - 모든 자원에 대한 반납을 하나의 메소드에서 처리(따로 하나씩 만들어도 좋음)
//   - static메소드

public class DBUtil {
	// 드라이버 로딩
	// => 클래스가 로딩될 때 한 번 실행된다.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// DB서버 접속하기
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://192.168.0.11/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	// 자원반납
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
