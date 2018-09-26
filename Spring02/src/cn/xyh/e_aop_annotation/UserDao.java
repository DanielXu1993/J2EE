package cn.xyh.e_aop_annotation;

import org.springframework.stereotype.Component;

/**
 * 目标对象
 */
@Component
public class UserDao{
    public void save() {
        System.out.println("-----保存数据-----");
    }
}
