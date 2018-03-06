package com.liyouzhi.client.service.impl;


import com.liyouzhi.client.service.HttpClient;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUrlConnection implements HttpClient<String, String, Map<String, Object>, String> {
    @Override
    public String get(String url, Map<String, Object> params, String charset) {
        return null;
    }

    @Override
    public String post(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;

        StringBuffer sbParams = new StringBuffer();

        if(params != null && params.size() > 0){
            for(Map.Entry<String, Object> entry : params.entrySet()){
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(urlParam);
            httpURLConnection = (HttpURLConnection) url.openConnection();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return null;
    }
}
