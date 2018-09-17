package cn.xyh.a_collectionMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.*;

public class App {
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveSet() {
        Session session = factory.openSession();
        session.beginTransaction();

        Set<String> addressSet = new HashSet<>();
        addressSet.add("广州");
        addressSet.add("深圳");
        User user = new User();
        user.setUserName("Jack");
        user.setAddressSet(addressSet);

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveList() {
        Session session = factory.openSession();
        session.beginTransaction();

        List<String> addressList = new ArrayList<>();
        addressList.add("广州");
        addressList.add("深圳");
        User user = new User();
        user.setUserName("Jack");
        user.setAddressList(addressList);

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testSaveMap() {
        Session session = factory.openSession();
        session.beginTransaction();

        Map<String, String> addressMap = new HashMap<>();
        addressMap.put("A00001", "广州");
        addressMap.put("A00002", "深圳");
        User user = new User();
        user.setUserName("Tom");
        user.setAddressMap(addressMap);

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGet() {
        Session session = factory.openSession();

        User user = session.get(User.class, 1);
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        // 当查询用户时可以同时获取关联的集合数据，因为有正确的映射
        // 只有当使用到集合时才会向数据库发送sql(懒加载)
        // get方法值懒加载关联的数据，而load方法懒加载所有数据，即没一条数据用到时才发送一条sql
        System.out.println(user.getAddressList());

        session.close();
    }
}
