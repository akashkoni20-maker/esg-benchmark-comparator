package com.internship.backend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Before("execution(* com.internship.backend.service.*.create*(..))")
    public void logCreate(JoinPoint jp) {
        System.out.println("AUDIT LOG: CREATE -> " + jp.getSignature().getName());
    }

    @Before("execution(* com.internship.backend.service.*.update*(..))")
    public void logUpdate(JoinPoint jp) {
        System.out.println("AUDIT LOG: UPDATE -> " + jp.getSignature().getName());
    }

    @Before("execution(* com.internship.backend.service.*.delete*(..))")
    public void logDelete(JoinPoint jp) {
        System.out.println("AUDIT LOG: DELETE -> " + jp.getSignature().getName());
    }
}
