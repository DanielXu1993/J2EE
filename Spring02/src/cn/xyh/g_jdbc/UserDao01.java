package cn.xyh.g_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用传统的JDBC技术
 */
public class UserDao01 {
    public void save() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql:///hib_demo", "root", "root");
            PreparedStatement ps = conn.prepareStatement("insert into t_user(userName)" +
                    " values (?)");
            ps.setString(1, "张三");
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
