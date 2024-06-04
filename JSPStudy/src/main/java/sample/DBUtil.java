package sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection makeConnection() {
		// db.properties 파일경로
		String filePath = "D:/myProject/myjsp/JSPStudy/src/main/java/sample/db.properties";
		Connection con = null;
		try {
			// db.properties 디비주소,사용자명,사용자암호 가져오기
			Properties properties = new Properties();
			properties.load(new FileReader(filePath));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			// ORACLE JDBC LOADING
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DATABASE CONNECT
			con = DriverManager.getConnection(url, user, password);
			// System.out.println("데이타베이스접속 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("데이타베이스 드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이타베이스 연결 실패");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB.PROPERTIES 연결실패");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB.PROPERTIES 연결실패");
		}
		return con;
	}

	// 자원 닫는 함수
	public static void closeResources(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResources(CallableStatement cstmt, Connection con) {
		try {
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}