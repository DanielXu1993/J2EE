package cn.xyh.d_myaop;

import org.springframework.stereotype.Component;

@Component
// 重复执行的代码
public class Aop {
    public void begin() {
        System.out.println("开启事务");
        System.out.println("提交事务");
    }

    public void commit() {
        System.out.println("提交事务");
    }
}
