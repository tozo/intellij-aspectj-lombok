package ie.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(void ie.test.service.CustomInterface.run())")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("before the function");

        Object result = proceedingJoinPoint.proceed();

        logger.info("after the function");

        return result;
    }

}
