package cn.xyh.a_tx;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * dao实现,使用Spring对jdbc支持功能
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = " insert into t_user(userName) values (?) ";
        jdbcTemplate.update(sql, user.getUserName());
    }
}
