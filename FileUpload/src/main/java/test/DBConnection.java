package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@183.98.140.90:1521:XE";
	
	// 드라이버 등록
	public DBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {}
	}
	
	// 연결
	public void getConnection() {	// ==> session=ssf.openSession()
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {}
	}
	
	// 해제
	public void disConnection() {	// session.close()
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {}
	}
}
