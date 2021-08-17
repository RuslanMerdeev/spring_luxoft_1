package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exceptions.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

@Aspect
public class ValidationLoggingAspect {

    private final static Logger LOG = Logger.getLogger(ValidationLoggingAspect.class.getName());


    @Pointcut("execution(* setAge(..))")
    public void setAgeMethod() {

    }

    @AfterThrowing(pointcut = "setAgeMethod()", throwing = "e")
    public void validationExceptionLogging(JoinPoint joinPoint, ValidationException e) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object arg :
                args) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(arg.toString());
        }
        LOG.severe("ValidationException in method " + name + "with args " + args);
    }
}
