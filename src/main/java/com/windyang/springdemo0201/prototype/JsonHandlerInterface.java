package com.windyang.springdemo0201.prototype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JsonHandlerInterface extends AbstractHandlerInterface{
    @Override
    public void fun1() {
        log.info("JsonHandlerInterface fun1 method");
    }

    @Override
    public void fun2() {
        log.info("JsonHandlerInterface fun2 method");
    }

    @Override
    public void fun3() {
        log.info("JsonHandlerInterface fun3 method");
    }
}
