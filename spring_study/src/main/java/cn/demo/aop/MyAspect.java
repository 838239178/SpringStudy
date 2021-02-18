package cn.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* cn.demo.service.impl.*.*(..))")
    public void pointCut() {}

    @Before("MyAspect.pointCut()")
    public void before() {
        System.out.println("before advice");
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
}
