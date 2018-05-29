package cn02.xyh.DBCP;

/**
 * sun公司约定，连接池技术需要实现javax.sql.DataSource接口
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * DBCP:
 * 核心类：BasicDataSource
 */
public class DBCPDemo {

    /**
     * 硬编码方式实现DBCP
     */
    @Test
    public void testDBCP() throws Exception {
        // DBCP连接池核心类
        BasicDataSource dataSource = new BasicDataSource();

        // 连接池参数配置：初始化连接数、最大连接数
        dataSource.setInitialSize(3);
        dataSource.setMaxActive(6);

        // 连接池参数配置: url、用户名、密码
        dataSource.setUrl("jdbc:mysql://localhost:3306/itanyoa");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 关闭(释放)连接
        connection.close();
    }

    // 2.配置方式实现DBCP
    // 注意：配置文件中的key要与BasicDataSource中的属性名保持一致
    @Test
    public void testProp() throws Exception {
        Properties prop = new Properties();
        // 加载属性配置文件
        prop.load(this.getClass().getClassLoader().getResourceAsStream("dbcp.properties"));
        // 根据Prop配置文件直接创建数据源对象
        DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);

        // 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 关闭(释放)连接
        connection.close();
    }
}
