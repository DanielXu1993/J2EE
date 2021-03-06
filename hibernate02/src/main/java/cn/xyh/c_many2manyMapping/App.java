package cn.xyh.c_many2manyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }


    @Test
    public void save() {
        Session session = factory.openSession();
        session.beginTransaction();

        Project pro_ds = new Project();
        pro_ds.setPro_name("电商系统");
        Project pro_oa = new Project();
        pro_oa.setPro_name("oa系统");

        Developer dev_cj = new Developer();
        dev_cj.setD_name("曹集");
        Developer dev_wc = new Developer();
        dev_wc.setD_name("王春");
        Developer dev_lz = new Developer();
        dev_lz.setD_name("老张");

        pro_ds.getDevelopers().add(dev_cj);
        pro_ds.getDevelopers().add(dev_wc);
        pro_oa.getDevelopers().add(dev_wc);
        pro_oa.getDevelopers().add(dev_lz);

        session.save(dev_cj);
        session.save(dev_wc);
        session.save(dev_lz);

        session.save(pro_ds);
        session.save(pro_oa);
        session.getTransaction().commit();
        session.close();
    }
}
