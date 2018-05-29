package cn01.xyh.SelfDefinedPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyPool {
    private int init_count = 3; // 初始化连接数目
    private int max_count = 6;  // 记录最大连接数
    private int current_count = 0; // 记录当前使用的连接数，包含池中的和正在使用的
    // 连接池，存放所有的初始化连接
    private LinkedList<Connection> pool = new LinkedList<>();

    // 1. 构造函数中，初始化连接放入连接池
    public MyPool() {
        // 初始化连接
        for (int i = 0; i < init_count; i++) {
            // 创建连接并且放入连接池
            pool.add(createConnection());
            current_count++;
        }
    }

    // 2.创建一个新的连接的方法
    private Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql:///itanyoa", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 3.外部获取连接
    public Connection getConnection() {
        // 问题一：会产生并发问题
        // 1. 判断连接池中是否有链接，如果有，直接取
        if (pool.size() > 0) {
            return pool.removeLast();
        }
        // 2. 连接池中没有连接，判断是否达到最大连接数，没有达到创建新连接，达到抛异常
        if (current_count < max_count) {
            current_count++;
            return createConnection();
        }
        throw new RuntimeException("当前连接池已经达到最大连接数");
    }

    // 4. 释放连接
    public void releaseConnection(Connection connection) {
        // 判断池中的数目是否已经达到初始化连接数
        if (pool.size() < init_count) {
            pool.add(connection);
        } else {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        current_count--;
    }

    public static void main(String[] args) {
        MyPool pool = new MyPool();
        System.out.println("当前连接数：" + pool.current_count);

        Connection connection1 = pool.getConnection();
        Connection connection2 = pool.getConnection();
        Connection connection3 = pool.getConnection();
        Connection connection4 = pool.getConnection();
        Connection connection5 = pool.getConnection();
        Connection connection6 = pool.getConnection();


        pool.releaseConnection(connection5);
        // 问题二：此时的connection可以调用自己的close()方法，
        // 此时连接不会返回到连接池中，会产生异常。
        // 可以使用动态代理对close()方法进行扩展
        Connection connection7 = pool.getConnection();

        System.out.println("连接池中数量：" + pool.pool.size());
        System.out.println("当前连接数：" + pool.current_count);
    }
}
