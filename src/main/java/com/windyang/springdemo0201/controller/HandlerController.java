package com.windyang.springdemo0201.controller;

import com.windyang.springdemo0201.prototype.ExcelHandlerInterface;
import com.windyang.springdemo0201.prototype.HandlerInterface;
import com.windyang.springdemo0201.prototype.JsonHandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/handler")
public class HandlerController {

    @Autowired
    private ExcelHandlerInterface excelHandlerInterface;
    @Autowired
    private JsonHandlerInterface jsonHandlerInterface;

    @GetMapping("/getList")
    public void getList(){
        excelHandlerInterface.fun4();
    }

    @GetMapping("/getList2")
    public void getList2(){
        jsonHandlerInterface.fun4();
    }

}
