package com.digdaya.aspects;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    private final Logger logger = LoggerFactory.getLogger("RestControllerAspect");

    Counter productCreatedCounter = Metrics.counter("com.digdaya.product.created");

    @Before("execution(public * com.digdaya.spring.controller.*Controller.*(..))")
    public void generalAllMethodASpect() {
        logger.info("All Method Calls invoke this general aspect method");
    }

    @AfterReturning("execution(public * com.digdaya.spring.controller.*Controller.createProduct(..))")
    public void getsCalledOnProductSave() {
        logger.info("This aspect is fired when the save method of the controller is called");
        productCreatedCounter.increment();
    }
}
