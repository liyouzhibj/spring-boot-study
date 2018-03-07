package com.liyouzhi.client.service;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTest {
    @Autowired
    HttpClient httpClient;

    @Test
    public void HttpUrlConnectionTest(){
        String url = "http://localhost:8090//postRequestBody";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "123456");
        map.put("userName", "李晶");

        String charset = "utf-8";
        String result = (String)httpClient.post(url, JSON.toJSONString(map), charset);
        System.out.println(result);
    }
}
