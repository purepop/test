package sql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SqlInterface {
    private String sql;
    private List<Object> params;
    private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

    public SqlInterface(String sql) {
        this.sql = sql;
        this.params = null;
    }

    public SqlInterface(String sql, List<Object> params) {
        this.sql = sql;
        this.params = params;
    }

    public List<HashMap<String, String>> queryLists() {
        List<HashMap<String, String>> result = new LinkedList<HashMap<String, String>>();

        try {
            conn = SqlConnect.getConnection();
            ps = conn.prepareStatement(sql);

            String className = "user";

            Iterator<Object> iterator = params.iterator();

            if (iterator.hasNext())
            {
                int i = 1;
                
                ps.setObject(i++, iterator.next());
            }

            rs = ps.executeQuery();
            while (rs.next())
            {
                HashMap<String, String> map = new HashMap<>();
                Class<?> c = Class.forName(className);
                
                Field[] fields = c.getFields();
                for (int i = 0; i < fields.length; i++)
                {
                    map.put(fields[i].getName(), rs.getString(fields[i].getName()));
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