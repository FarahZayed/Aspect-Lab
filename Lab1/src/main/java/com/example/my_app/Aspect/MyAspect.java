package com.example.my_app.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import  org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.example.my_app.controller.MyController.*(..))")
    public void beforeMyServiceMethods(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }
}

