package cn.xyh.g_annotation2;

import org.springframework.stereotype.Repository;

//@Component("userDao")等价于
//@Component等价于
@Repository
public class UserDao {
    public void save() {
        System.out.println("DB:保存用户");
    }
}
