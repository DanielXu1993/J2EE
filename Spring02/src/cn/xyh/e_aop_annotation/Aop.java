package cn.xyh.e_aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // 指定当前类为切面类
@Component // 切面类必须加入容器
// 重复执行的代码
public class Aop {
    @Pointcut("execution(* cn.xyh.e_aop_annotation.UserDao.save(..))")
    public void pointCut_() {

    }

    // 前置通知:在执行目标方法之前执行
    @Before("execution(* cn.xyh.e_aop_annotation.UserDao.save(..))")
    public void begin() {
        System.out.println("开启事务");
    }

    // 后置/最终通知:在执行目标方法之后执行[无论目标方法是否异常都执行]
    @After("pointCut_()")
    public void commit() {
        System.out.println("提交事务");
    }

    // 返回后通知:在调用业务方法后执行[目标方法出现异常时该方法不执行]
    @AfterReturning("pointCut_()")
    public void afterReturning() {
        System.out.println("afterReturning:目标方法出现异常时不执行");
    }

    // 异常通知:当目标方法执行出现异常时执行此关注点代码
    @AfterThrowing("pointCut_()")
    public void afterThrowing() {
        System.out.println("afterThrowing:目标方法出现异常时执行");
    }

    // 环绕通知
    @Around("pointCut_()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("环绕前...");
        Object returnValue = pjp.proceed(); // 执行目标方法
        System.out.println("环绕后...");
    }
}
