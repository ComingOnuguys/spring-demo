package com.windyang.springdemo0201.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author windyang
 */
@Service
@Slf4j
public class HomeService {

    public String getHome(){
        log.info("invoke getHome");
        return "123";
    }
}
