package cn.xyh.b_annotation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * dao实现,使用Spring对jdbc支持功能
 */
@Repository
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = " insert into t_user(userName) values (?) ";
        jdbcTemplate.update(sql, user.getUserName());
    }
}
