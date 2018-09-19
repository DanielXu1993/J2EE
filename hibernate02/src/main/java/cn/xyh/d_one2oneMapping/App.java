package cn.xyh.d_one2oneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
    private static SessionFactory factory;

    static {
        factory =
                new Configuration().configure().buildSessionFactory();
    }


    @Test
    public void test() {
        Session session = factory.openSession();
        session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("Jack");

        IdCard card = new IdCard();
        card.setCardNum("456321321532xxxx");
        card.setIssuePlace("安徽省");
        customer.setIdCard(card);

        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }
}
