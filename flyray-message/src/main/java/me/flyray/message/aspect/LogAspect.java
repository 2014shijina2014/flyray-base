package me.flyray.message.aspect;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log Aop
 */
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private final static char DOT_CHAR = '.';

    public Object around(ProceedingJoinPoint point) throws Throwable {

        String serviceName = Joiner.on(DOT_CHAR).join(point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        String args = ToStringBuilder.reflectionToString(point.getArgs(), ToStringStyle.SHORT_PREFIX_STYLE);

        logger.info("Service start: serviceName={}, args={}", serviceName, args);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Object result = point.proceed();
            logger.info("Service finished: serviceName={}, args={}, result={}, duration={}ms", serviceName, args,
                    ToStringBuilder.reflectionToString(result, ToStringStyle.SHORT_PREFIX_STYLE), stopWatch.getTime());
            return result;
        } catch (Exception e) {
            logger.error("Service exception: serviceName={}, args={}, duration={}ms", serviceName, args, stopWatch.getTime(), e);
            throw e;
        } finally {
            stopWatch.stop();
        }
    }
}
