package sql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SqlInterface {
    private String sql;
    private List<Object> params;
    private String className;

    private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

    public SqlInterface(String sql, String className) {
        this.sql = sql;
        this.params = null;
        this.className = className;
    }

    public SqlInterface(String sql, String className, List<Object> params) {
        this.sql = sql;
        this.params = params;
        this.className = className;
    }

    public List<HashMap<String, String>> queryLists() {
        List<HashMap<String, String>> result = new LinkedList<HashMap<String, String>>();

        try {
            conn = SqlConnect.getConnection();
            ps = conn.prepareStatement(sql);

            int i = 1;
            for (Object item : params)
            {
                ps.setObject(i++, item);
            }

            rs = ps.executeQuery();
            while (rs.next())
            {
                HashMap<String, String> map = new HashMap<>();
                Class<?> c = Class.forName(className);
                
                Field[] fields = c.getFields();
                for (int j = 0; j < fields.length; j++)
                {
                    map.put(fields[j].getName(), rs.getString(fields[j].getName()));
                }
                result.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            SqlConnect.close(conn, ps, rs);
        }

        return result;
    }
}