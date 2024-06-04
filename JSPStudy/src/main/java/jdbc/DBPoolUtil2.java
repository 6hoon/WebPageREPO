package jdbc;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBPoolUtil2 {
	// was에서 제공하는 lib을 이용
	public static Connection makeConnection() {
//		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/myOracle"); // JNDI
			// -> lookup의 리턴 : object
			// -> downcasting 하여 받아줘야함
			con = ds.getConnection();
			// System.out.println("데이타베이스접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이타베이스 연결 실패");
		} catch (NamingException e) {
			e.printStackTrace();
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
				con.close();
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
				con.close();
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
				con.close();
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
}