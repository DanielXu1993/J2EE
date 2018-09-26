package cn.xyh.g_jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    // 测试传统的JDBC技术
    @Test
    public void testJDBCOriginal() {
        new UserDao01().save();
    }

    // 测试C3P0与IOC结合的技术
    @Test
    public void testC3P0() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/g_jdbc/bean.xml");
        UserDao02 userDao = (UserDao02) ac.getBean("userDao02");
        userDao.save();
    }

    // 测试jdbcTemplate保存用户
    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/g_jdbc/bean.xml");
        UserDao03 userDao = (UserDao03) ac.getBean("userDao03");
        userDao.save();
    }

    // 测试jdbcTemplate根据用户id查询
    @Test
    public void testFindById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/g_jdbc/bean.xml");
        UserDao03 userDao = (UserDao03) ac.getBean("userDao03");
        User user = userDao.findById(1);
        System.out.println(user);
    }

    // 测试jdbcTemplate查询所有用户
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/g_jdbc/bean.xml");
        UserDao03 userDao = (UserDao03) ac.getBean("userDao03");
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
}