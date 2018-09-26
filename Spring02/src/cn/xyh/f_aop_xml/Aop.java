package cn.xyh.f_aop_xml;

// 切面类
public class Aop {
    public void begin() {
        System.out.println("开启事务");
    }

    public void commit() {
        System.out.println("提交事务");
    }

}
