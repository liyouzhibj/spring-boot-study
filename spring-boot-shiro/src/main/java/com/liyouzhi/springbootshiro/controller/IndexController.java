package com.liyouzhi.springbootshiro.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

class WsSPChkDupIc{
    private String status_code;
    private String status_msg;

    WsSPChkDupIc(String status_code, String status_msg){
        this.status_code = status_code;
        this.status_msg = status_msg;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_msg() {
        return status_msg;
    }

    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }
}

@RestController
public class IndexController {
    @RequestMapping("/WsSPChkDupIc")
    public WsSPChkDupIc wsSPChkDupIc(@RequestBody Map<String, Object> requestMap){
        String usr_id = requestMap.get("usr_id").toString();
        String nric = requestMap.get("nric").toString();

        System.out.println("WsSPChkDupIc are requested, request params: " + usr_id + " " + nric);
        WsSPChkDupIc result = new WsSPChkDupIc("0", "Success, no duplication of user id or nric.");
        return result;
    }

    @RequestMapping("/WsSPRegUsr")
    public void ssSPRegUsr(@RequestBody Map<String, Object> requestMap){
        String usr_id = requestMap.get("usr_id").toString();
        String pwd = requestMap.get("pwd").toString();
        String fullname = requestMap.get("fullname").toString();
        String passport_no = requestMap.get("passport_no").toString();
        String email = requestMap.get("email").toString();
        String hp_no = requestMap.get("hp_no").toString();
        String user_role = requestMap.get("user_role").toString();

        System.out.println("WsSPRegUsr are requested, request params: " + usr_id + " " + pwd + " " + fullname);
    }
}
