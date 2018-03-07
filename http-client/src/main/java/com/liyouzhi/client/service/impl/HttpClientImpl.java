package com.liyouzhi.client.service.impl;

import com.alibaba.fastjson.JSON;
import com.liyouzhi.client.service.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpClientImpl implements HttpClient<String, String, String, String>{
    @Override
    public String get(String s, String params, String s2) {
        return null;
    }

    @Override
    public String post(String url, String params, String charset) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        StringEntity stringEntity = new StringEntity(params, charset);
        stringEntity.setContentEncoding(charset);
        httpPost.setEntity(stringEntity);

        System.out.println("Executing request " + httpPost.getRequestLine());
        CloseableHttpResponse httpResponse = null;
        String result = "";
        try{
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
