package cn.xyh.g_jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用Spring与C3P0技术
 */
public class UserDao02 {
    // 通过IOC容器注入数据源对象
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save() {
        try {
            Connection connection = dataSource.getConnection();
            String sql = " insert into t_user(userName) values(?) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "李四");
            ps.executeUpdate();
            connection.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
