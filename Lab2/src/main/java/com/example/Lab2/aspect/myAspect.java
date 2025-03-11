package com.example.Lab2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import  org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import java.util.Arrays;
import java.util.stream.IntStream;

@Aspect
@Component
public class myAspect {
    @Pointcut("execution(* com.example.Lab2.Controller.myController.*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void beforeControllerMethods(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();

        for (int i = 0; i < args.length; i++) {
            System.out.println("Param: " + paramNames[i] + " = " + args[i]);
        }
    }
}
