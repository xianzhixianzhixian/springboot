package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配合freemaker使用的controller
 */
@Controller
public class FreemakerController {

    @RequestMapping(value = "/index")
    public String index(Map<String, String> map) {
        map.put("name", "动态数据");
        return "index";
    }

    @RequestMapping(value = "/list")
    public String list(Map<String, Object> map) {
        map.put("name", "动态数据");
        map.put("sex", "0");
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("6");
        map.put("names", list);
        return "list";
    }
}
