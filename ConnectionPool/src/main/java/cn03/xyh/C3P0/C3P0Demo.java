package cn03.xyh.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * C3P0连接池：Spring框架默认支持,最常用的连接池技术
 * 核心类：ComboPooledDataSource
 */
public class C3P0Demo {

    // 硬编码方式
    @Test
    public void testC3P0() throws Exception {
        // 创建连接池核心工具类
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 设置参数：初始连接数、最大连接数
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);

        // 设置参数：url、用户名、密码
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/itanyoa");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // 从连接池中获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 关闭(释放)连接
        connection.close();
    }

    // XML配置方式
    @Test
    public void testXMLProp() throws Exception {
        // 创建核心工具类,会自动加载src下的c3p0-config.xml文件
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 从连接池中获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 关闭(释放)连接
        connection.close();
    }
}
