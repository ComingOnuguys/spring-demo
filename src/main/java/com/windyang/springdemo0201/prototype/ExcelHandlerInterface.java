package com.windyang.springdemo0201.prototype;

import com.windyang.springdemo0201.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author windyang
 */
@Component
@Slf4j
public class ExcelHandlerInterface extends AbstractHandlerInterface{



    @Autowired
    private HomeService homeService;

    @Override
    public void fun1() {
        log.info("ExcelHandlerInterface fun1 method = " + homeService.getHome());
    }

    @Override
    public void fun2() {
        log.info("ExcelHandlerInterface fun2 method");
    }

    @Override
    public void fun3() {
        log.info("ExcelHandlerInterface fun3 method");
    }

}
