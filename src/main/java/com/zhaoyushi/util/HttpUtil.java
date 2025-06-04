package com.zhaoyushi.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

    public static String post(String url, String json, String appKey, String appSecret, String openToken) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("appKey", "DyqLZrdt");
        httpPost.setHeader("appSecret", "5A42A7B0A5F1C98040AF32DA9E21E638");
        httpPost.setHeader("openToken", openToken);

        // 设置请求体
        StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);

        // 发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);

        // 关闭资源
        response.close();
        httpClient.close();

        return responseString;
    }

}
