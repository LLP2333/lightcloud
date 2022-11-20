package com.llp.lightcloud.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author llp
 * {@code @date} 2022年11月17日20:22
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {
    @Pointcut("execution(* com.llp.lightcloud.controller.UserController.login(..))")
    public void pointcut(){}

    @Before("pointcut()")
     void Before()
    {
        log.info("开始调用前");
    }

    @After("pointcut()")
    void After()
    {
        log.info("调用后");
    }

    @AfterReturning("pointcut()")
    void afterReturn()
    {
        log.info("afterReturn");
    }

    @AfterThrowing("pointcut()")
    void AfterThrowing()
    {
        log.info("afterTrowing");
    }


}
