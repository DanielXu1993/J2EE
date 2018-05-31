package cn03.xyh.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static ThreadLocal<Connection> local = new ThreadLocal<>();
    private static DataSource dataSource;

    // 初始化连接池资源
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static Connection getConnection() {
        Connection connection = null;
        connection = local.get();
        if (null == connection) {
            try {
                connection = dataSource.getConnection();
                local.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close(ResultSet rs, Statement st) {
        try {
            local.get().close();
            local.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
