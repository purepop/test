package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

public class SqlConnect {
    private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/demoweb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String passWord = "root";
		
	public static Connection getConnection() 
	{
		Connection conn = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passWord);	
		} catch(final SQLTimeoutException e) {
            e.printStackTrace();
        } catch (final SQLException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }

        return conn;
    }

    public static void close(final Connection conn, final Statement sm, final ResultSet rs) {
        close(rs);
        close(conn, sm);
    }

    public static void close(final Connection conn, final Statement sm) {
        close(sm);
        close(conn);
    }

    public static void close(final Connection conn) {
        try {
            conn.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(final Statement sm) {
        try {
            sm.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(final ResultSet rs) {
        try {
            rs.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}