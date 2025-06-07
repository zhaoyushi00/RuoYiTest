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

/**
 * HTTP工具类
 * 提供HTTP请求相关的通用方法
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
public class HttpUtil {

    /**
     * 发送POST请求
     * 向指定URL发送POST请求，并返回响应内容
     *
     * @param url 请求URL
     * @param json 请求体JSON字符串
     * @param appKey 应用标识
     * @param appSecret 应用密钥
     * @param openToken 访问令牌
     * @return 响应内容字符串
     * @throws IOException 当请求发生IO异常时抛出
     */
    public static String post(String url, String json, String appKey, String appSecret, String openToken) throws IOException {

        //创建连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建 HttpPost 实例时必须传入这个 URL，后续设置 Header、Body 等都是基于这个请求对象进行配置。
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头
        //Content-Type: 告知服务器请求体的数据格式，例如 application/json 表示 JSON 数据。
        //自定义 Header（如 appKey, appSecret, openToken）：用于身份验证或接口权限控制。
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("appKey", "DyqLZrdt");
        httpPost.setHeader("appSecret", "5A42A7B0A5F1C98040AF32DA9E21E638");
        httpPost.setHeader("openToken", openToken);

        // 设置请求体
        // 将传入的 JSON 字符串封装成 HTTP 请求体，用于 POST 请求发送数据
        StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);

        // 发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost); //执行
        HttpEntity responseEntity = response.getEntity();  //获取
        String responseString = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);  //转换

        // 关闭资源
        response.close();
        httpClient.close();

        return responseString;
    }

}
