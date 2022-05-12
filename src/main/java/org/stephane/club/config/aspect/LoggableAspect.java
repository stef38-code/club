package org.stephane.club.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.stephane.club.share.tools.CustomTime;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggableAspect {

    @Around("@annotation(org.stephane.club.config.aspect.TrackTime)")
    public Object logMethodTiming(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();
        Object returnValue = proceedingJoinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();
        log.info(">> {} en {}", proceedingJoinPoint.getSignature().getName(), CustomTime.findDifferenceWithStringFormat(start, end));
        return returnValue;
    }
}
