package com.windyang.springdemo0201.prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractHandlerInterface implements HandlerInterface{

    @Override
    public void fun1() {
        log.info("AbstractHandlerInterface fun1 method");
        fun2();
    }

    @Override
    public void fun2() {
        log.info("AbstractHandlerInterface fun2 method");
    }

    @Override
    public void fun3() {
        log.info("AbstractHandlerInterface fun3 method");
    }

    @Override
    public void fun4() {
        log.info("AbstractHandlerInterface fun4 method");
        this.fun2();
    }


}
