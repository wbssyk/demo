package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaKun.shi
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("filter")
    @ResponseBody
    public String filter(){
        return "是一款";
    }

    @GetMapping(value = "inter")
    @ResponseBody
    public String inter(){
        return "师亚坤";
    }
}
