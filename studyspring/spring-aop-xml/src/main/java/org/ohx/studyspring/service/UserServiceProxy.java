package org.ohx.studyspring.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author mudkip
 * @date 2022/7/20
 */
public class UserServiceProxy {
    /**
     * 前置通知
     */
    public void before() {
        System.out.println("before...");
    }

    /**
     * 后置通知
     */
    public void after() {
        System.out.println("after...");
    }

    /**
     * 最终通知
     */
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    /**
     * 异常通知
     */
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    /**
     * 环绕通知
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("around after...");
    }
}
