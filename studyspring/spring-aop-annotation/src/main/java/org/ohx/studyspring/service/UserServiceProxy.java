package org.ohx.studyspring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author mudkip
 * @date 2022/7/20
 */
@Service
@Aspect
public class UserServiceProxy {
    /**
     * 相同切入点
     */
    @Pointcut(value = "execution(* org.ohx.studyspring.service.UserService.add(..))")
    public void pointCut() {
    }

    /**
     * 前置通知
     */
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("before...");
    }

    /**
     * 后置通知
     */
    @After(value = "execution(* org.ohx.studyspring.service.UserService.add(..))")
    public void after() {
        System.out.println("after...");
    }

    /**
     * 最终通知
     */
    @AfterReturning(value = "execution(* org.ohx.studyspring.service.UserService.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* org.ohx.studyspring.service.UserService.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* org.ohx.studyspring.service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("around after...");
    }
}
