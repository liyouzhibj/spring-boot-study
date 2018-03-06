package com.liyouzhi.server.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping(path = "/postRequestBody", method = RequestMethod.POST)
    public String postRequestBody(@RequestBody Map<String, Object> requestMap) {
        String userId = "";
        String userName = "";

        if (requestMap.get("userId") != null) {
            userId = requestMap.get("userId").toString();
        }

        if (requestMap.get("userId") != null) {
            userName = requestMap.get("userName").toString();
        }


        System.out.println("Request params: " + userId + " " + userName);
        return "success";
    }
}
