package fr.iocean.speciesrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodNameLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("within(fr.iocean.speciesrest.service.PersonService)")
    public void logService(JoinPoint joinPoint) {
        logger.info(">>> ASPECT <<< Executing PersonService method {}", joinPoint.getSignature().getName());
    }

}
