package cn.xyh.g_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 使用Spring提供的JdbcTemplate工具类
 */
public class UserDao03 {
    // 通过IOC容器注入jdbcTemplate对象
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 保存用户
    public void save() {
        String sql = " insert into t_user(userName) values(?) ";
        jdbcTemplate.update(sql, "王五");
    }

    public User findById(int id) {
        String sql = " select * from t_user where id = ? ";
        List<User> list = jdbcTemplate.query(sql, (rs, index) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            return user;
        }, id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    // 查询所有用户
    public List<User> findAll() {
        String sql = " select * from t_user";
        List<User> list = jdbcTemplate.query(sql, (rs, index) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            return user;
        });
        return list;
    }
}
