package cn.xyh.f_ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

public class OgnlDemo1 {
    /**
     * 1. Ognl语言取值：取非根元素的值必须用#
     *
     * @throws Exception
     */
    @Test
    public void testOgnl1() throws Exception {
        // 创建Ognl上下文对象
        OgnlContext context = new OgnlContext();

        // 往非根元素中放入元素
        context.put("hello", "world");
        // 获取数据
        // 构建获取数据的Ognl表达式
        Object expression = Ognl.parseExpression("#hello");
        // 解析表达式
        Object value = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(value);

        User user = new User();
        user.setId(100);
        user.setName("Jack");
        // 往非根元素中放入对象元素
        context.put("user", user);

        Object expression1 = Ognl.parseExpression("#user.name");
        Object value1 = Ognl.getValue(expression1, context, context.getRoot());
        System.out.println(value1);
    }

    /**
     * 2. Ognl语言取值：取根元素的值，不需要使用#，也不需要对象名
     *
     * @throws Exception
     */
    @Test
    public void testOgnl2() throws Exception {
        // 创建Ognl上下文对象
        OgnlContext context = new OgnlContext();

        User user = new User();
        user.setId(100);
        user.setName("Jack");
        // 往根元素中放入对象元素
        context.setRoot(user);

        Object expression1 = Ognl.parseExpression("name");
        Object value1 = Ognl.getValue(expression1, context, context.getRoot());
        System.out.println(value1);

        Object expression2 = Ognl.parseExpression("address.province");
        Object value2 = Ognl.getValue(expression2, context, context.getRoot());
        System.out.println(value2);

    }

    /**
     * 3. Ognl对静态方法调用的支持
     *
     * @throws OgnlException
     */
    @Test
    public void testOgnl3() throws OgnlException {
        // 创建Ognl上下文对象
        OgnlContext context = new OgnlContext();

        // Ognl表达式语言调用静态方法
        Object expression = Ognl.parseExpression("@Math@floor(10.9)");
        // 由于Math类在开发中比较常用，所以也可以写成如下形式
        // Object expression = Ognl.parseExpression("@@floor(10.9)");
        Object value = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(value);
    }
}
