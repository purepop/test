package sql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SqlInterface<T> {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    Class<T> clazz = null;

    private SqlInterface() {
    }

    public SqlInterface(Class<T> clazz) {
        try {
            this.clazz = clazz;

            conn = SqlConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            new SqlInterface<T>();
        }
    }

    protected void finalize() {
        SqlConnect.close(conn);
    }

    public List<T> queryList(HashMap<String, Object> whparams) throws InvocationTargetException, NoSuchMethodException {
        List<T> result = new ArrayList<>();
        select(whparams);

        try {
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                T instance = clazz.getDeclaredConstructor().newInstance();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    Field field = clazz.getDeclaredField(metaData.getColumnName(i));
                    field.setAccessible(true);
                    field.set(instance, rs.getObject(i));
                }
                result.add(instance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            SqlConnect.close(ps, rs);
        }

        return result;
    }

    public int insert(HashMap<String, Object> whparams) {
        int id = 0;
        int i = 1;

        try {
            ps = conn.prepareStatement(spellSQL("insert", whparams.keySet(), null), Statement.RETURN_GENERATED_KEYS);
            for (Object param : whparams.values()) {
                ps.setObject(i++, param);
            }
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()) id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlConnect.close(ps, rs);
        }

        return id;
    }

    public int delete(HashMap<String, Object> whparams) {
        int flag = 0;
        int i = 1;

        try {
            ps = conn.prepareStatement(spellSQL("delete", whparams.keySet(), null));
            for (Object param : whparams.values()) {
                ps.setObject(i++, param);
            }
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlConnect.close(ps);
        }

        return flag;
    }

    public int update(HashMap<String, Object> params, HashMap<String, Object> whparams) {
        int r = 0;
        int i = 1;

        try {
            ps = conn.prepareStatement(spellSQL("update", params.keySet(), whparams.keySet()));
            for (Object param : params.values()) {
                ps.setObject(i++, param);
            }
            for (Object param : whparams.values()) {
            	ps.setObject(i++, param);
            }
            r = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlConnect.close(ps);
        }

        return r;
    }

    private void select(HashMap<String, Object> whparams) {
        int i = 1;
        try {
            ps = conn.prepareStatement(spellSQL("select", whparams.keySet(), null));
            for (Object param : whparams.values()) {
                ps.setObject(i++, param);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String spellSQL(String type, Set<String> keys, Set<String> whkeys) {
        StringBuffer sql = new StringBuffer("");
        int i = 0;

        if (type.equals("select")) {
            sql.append(type + " * from " + clazz.getSimpleName());
            for (String key : keys)
            {
                if (i != 0) { sql.append(" and "); }
                if (i == 0) { sql.append(" where "); }
                sql.append(key + " = ?");
                i++;
            }
        }
        else if (type.equals("delete")) {
            sql.append(type + " from " + clazz.getSimpleName() + " where ");
            for (String key : keys)
            {
                if (i != 0) { sql.append(" and "); }
                sql.append(key + " = ?");
                i++;
            }
        }
        else if (type.equals("insert")) {
            sql.append(type + " into " + clazz.getSimpleName());
            StringBuffer values = new StringBuffer("values (");
            for (String key : keys)
            {
                if (i == 0) { sql.append( " (" ); }
                sql.append(key + ",");
                values.append("?,");
                i++;
            }
            values.deleteCharAt(values.length() - 1);
            values.append(")");
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")" + values);
        }
        else if (type.equals("update")) {
            sql.append(type + " " + clazz.getSimpleName() + " set ");
            StringBuffer wh = new StringBuffer(" where ");
            for (String key : keys)
            {
                sql.append(key + " = ?,");
            }
            for (String key : whkeys)
            {
            	if (i != 0) { sql.append(" and "); }
            	wh.append(key + "=?");
            	i++;
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(wh);
        }

        return sql.toString();
    }
}