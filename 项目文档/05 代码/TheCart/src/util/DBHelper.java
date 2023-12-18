package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String username = "SYSTEM";
	private static final String password = "123456";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private Connection conn = null;
	public DBHelper(){
		try{
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnnection(){
		return this.conn;
	}
	public void close(){
		if(this.conn != null){
			try{
				this.conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
