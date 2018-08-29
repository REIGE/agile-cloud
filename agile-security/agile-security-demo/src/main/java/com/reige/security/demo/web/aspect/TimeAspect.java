package com.reige.security.demo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/29.
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.reige.security.demo.web..*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        long start = System.currentTimeMillis();

        Object object = pjp.proceed();

        long end = System.currentTimeMillis();
        System.out.println("time aspect 耗时:" + (end - start));

        System.out.println("time aspect end");

        return object;
    }

}
