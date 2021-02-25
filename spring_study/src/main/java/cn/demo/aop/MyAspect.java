package cn.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect implements Ordered {

    @Pointcut("execution(* cn.demo.service.impl.*.*(..))")
    public void pointCut() {
    }

    @Around("MyAspect.pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("around 1");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around 2");
        return proceed;
    }

    @Value("${order.myAspect}")
    private int order;

    @Override
    public int getOrder() {
        return this.order;
    }
}
