package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPoolUtil {
	public static Connection makeConnection() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		try {
			con = pool.getConnection();
			// System.out.println("데이타베이스접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이타베이스 연결 실패");
		}
		return con;
	}

	public static void dbReleaseClose(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
		}
		try {

			if (con != null) {
				ConnectionPool pool = ConnectionPool.getInstance();
				pool.releaseConnection(con);
			}
		} catch (Exception e) {
		}
	}

	public static void dbReleaseClose(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				ConnectionPool pool = ConnectionPool.getInstance();
				pool.releaseConnection(con);
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public static void dbReleaseClose(CallableStatement cstmt, Connection con) {
		try {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				ConnectionPool pool = ConnectionPool.getInstance();
				pool.releaseConnection(con);
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public static void dbReleaseClose(PreparedStatement pstmt, Connection con) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
		}
		try {

			if (con != null) {
				ConnectionPool pool = ConnectionPool.getInstance();
				pool.releaseConnection(con);
			}
		} catch (Exception e) {
		}
	}
}