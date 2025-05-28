package user_profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import util.DBUtil;
import util.FormatterUtil;

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, conn);
		}
		return user;

	}

	// 회원가입
	public int signupUser(String id, String name, String pass, String phone, String birth_date) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "insert into user_profile values(?, ?, ?, ?, sysdate(), sysdate(), ?)";
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
		} finally {
			DBUtil.close(null, ptmt, conn);
		}
		return result;
	}

	// 회원정보수정
	public int updateUser(String choice, String id) {
		Scanner key = new Scanner(System.in);
		String sql = "";
		String p = "";

		switch (choice) {
		case "1":
			System.out.println("아이디는 수정할 수 없습니다.");
			return 0;
		case "2":
			System.out.print("수정할 이름을 작성해주세요: ");
			p = key.nextLine();
			sql = "UPDATE user_profile SET name = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
			break;
		case "3":
			System.out.print("수정할 전화번호를 작성해주세요: ");
			p = FormatterUtil.phoneFormatter(key.nextLine());
			sql = "UPDATE user_profile SET phone = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
			break;
		case "4":
			System.out.print("수정할 생년월일을 작성해주세요 (YYYY-MM-DD): ");
			p = FormatterUtil.yearFormatter(key.nextLine());
			sql = "UPDATE user_profile SET birth_date = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
			break;
		case "0":
			System.out.println("회원 정보 수정이 완료되었습니다.");
			return 0;
		default:
			System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
			return 0;
		}

		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, p);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, conn);
		}

		return result;
	}

	// 회원정보 수정 후 갱신
	public UserDTO getUserById(String id) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserDTO user = null;
		String sql = "select * from user_profile where id = ?";
		try {
			conn = DBUtil.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, conn);
		}
		return user;

	}

	// 회원탈퇴
	public int deleteUser(String id) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {
			conn = DBUtil.getConnection();

			String updateSeatSql = """
					    UPDATE seat s
					    JOIN reservation r ON s.id = r.seat_id
					    SET s.is_reserved = FALSE, s.reserved_at = NULL
					    WHERE r.user_id = ?
					""";
			ptmt = conn.prepareStatement(updateSeatSql);
			ptmt.setString(1, id);
			ptmt.executeUpdate();
			ptmt.close();

			String deleteUserSql = "DELETE FROM user_profile WHERE id = ?";
			ptmt = conn.prepareStatement(deleteUserSql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, conn);
		}

		return result;
	}

}
