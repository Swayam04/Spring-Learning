package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PaymentAspect {
    private final Logger logger = LoggerFactory.getLogger(PaymentAspect.class);

    @Around("execution(* org.example.service.*.makePayment(..))")
    public void pay(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Paying {}", joinPoint.getSignature().getName());
        joinPoint.proceed();
        logger.info("Payment completed");
    }

    @Around("execution(* org.example.service.*.makePaymentWithReturn(..))")
    public Object payWithReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Payment method {} with parameters {}", methodName, Arrays.asList(args));
        Object returnValue = joinPoint.proceed(args);
        logger.info("Payment completed. Return Value: {}", returnValue);
        return "Failed";
    }

    @AfterReturning(value = "@annotation(org.example.annotations.ToLog)", returning = "returnedValue")
    public void refundWithReturn(Object returnedValue) throws Throwable {
        logger.info("Intercepting refund method after returning. Returned Value: {}", returnedValue);
    }
}
