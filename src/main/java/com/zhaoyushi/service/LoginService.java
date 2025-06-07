package com.zhaoyushi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoyushi.dto.LoginRequest;
import com.zhaoyushi.dto.LoginResponse;
import com.zhaoyushi.util.HttpUtil;

/**
 * 登录服务类
 * 负责处理与开放平台的登录相关操作
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
public class LoginService {

    /**
     * 开放平台基础URL
     */
    private static final String BASE_URL = "https://openapi.chanjet.com";

    /**
     * 获取登录URL的接口地址
     */
    private static final String LOGIN_URL = BASE_URL + "/v2/common/authSite/sso/getLoginUrl";

    /**
     * 获取登录URL
     * 向开放平台发送登录请求，获取登录页面URL
     *
     * @param request 登录请求参数
     * @param appKey 应用标识
     * @param appSecret 应用密钥
     * @param openToken 访问令牌
     * @return 登录响应结果
     * @throws Exception 当请求发生异常时抛出
     */
    public LoginResponse getLoginUrl(LoginRequest request, String appKey, String appSecret, String openToken) throws Exception {

        // ObjectMapper 是 Jackson 提供的核心类，用于在 Java 对象和 JSON 格式之间进行相互转换。
        // 可以将 Java 对象序列化为 JSON 字符串（如本例），也可以将 JSON 字符串反序列化为 Java 对象。
        ObjectMapper objectMapper = new ObjectMapper();
        // 将传入的 Java 对象 request（类型为 LoginRequest）序列化为 JSON 格式的字符串。
        String jsonRequest = objectMapper.writeValueAsString(request);

        // 发送请求
        // 该 JSON 字符串随后会被作为请求体发送给服务端（通过 HttpUtil.post() 方法）。
        String response = HttpUtil.post(LOGIN_URL, jsonRequest, appKey, appSecret, openToken);

        // 解析响应
        return objectMapper.readValue(response, LoginResponse.class);
    }
}