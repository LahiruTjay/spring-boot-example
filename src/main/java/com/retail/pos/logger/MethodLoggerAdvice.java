package com.retail.pos.logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodLoggerAdvice {
	
    private static final Logger logger = LoggerFactory.getLogger(MethodLoggerAdvice.class);
    
    @Before("execution(* com.retail.pos.controller.*.*(..)) ")
    public void controllerClassLog(JoinPoint jointPoint) throws Throwable {
        logger.info("{}.{}, parameter value - {}", jointPoint.getTarget().getClass().getName(),
                jointPoint.getSignature().getName(), jointPoint.getArgs().length > 0 ? jointPoint.getArgs()[0].toString(): null);
    }
}
