package com.liyouzhi.client.service.impl;


import com.liyouzhi.client.service.HttpClient;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUrlConnectionJson implements HttpClient<String, String, String, String> {
    @Override
    public String get(String url, String params, String charset) {
        return null;
    }

    @Override
    public String post(String urlParam, String params, String charset) {
        StringBuffer resultBuffer = null;

        StringBuffer sbParams = new StringBuffer();

        if(params != null && params.length() > 0){
            sbParams.append(params);
        }
        HttpURLConnection httpURLConnection = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(urlParam);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            if (sbParams != null && sbParams.length() > 0) {
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), charset);
                outputStreamWriter.write(sbParams.substring(0, sbParams.length() - 1));
                outputStreamWriter.flush();
            }
            // 读取返回内容
            resultBuffer = new StringBuffer();
            int contentLength = Integer.parseInt(httpURLConnection.getHeaderField("Content-Length"));
            if (contentLength > 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), charset));
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    resultBuffer.append(temp);
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    outputStreamWriter = null;
                    throw new RuntimeException(e);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    bufferedReader = null;
                    throw new RuntimeException(e);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                }
            }
        }

        return resultBuffer.toString();
    }
}
