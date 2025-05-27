package user_profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class UserDAOImpl {

	// 로그인
	public UserDTO login(String id, String password) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserDTO user = null;
		String sql = "select * from user_profile where id = ? && pass = ?";
		try {
			conn = DBUtil.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, password);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, conn);
		}
		return user;

	}

	// 회원가입
	public int userInsert(String id, String name, String pass, String phone, String birth_date) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "insert into user_profile values(?, ?, ?, ?, sysdate(), null, ?)";
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, name);
			ptmt.setString(3, phone);
			ptmt.setString(4, birth_date);
			ptmt.setString(5, pass);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, conn);
		}
		return result;
	}
	
	
}
