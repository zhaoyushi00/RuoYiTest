package com.zhaoyushi.service;

import com.zhaoyushi.dto.AuthRequest;
import com.zhaoyushi.dto.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoyushi.util.HttpUtil;

/**
 * 认证服务类
 * 负责处理与开放平台的认证相关操作
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
public class AuthService {

    /**
     * 开放平台基础URL
     */
    private static final String BASE_URL = "https://openapi.chanjet.com";

    /**
     * 获取token的接口地址
     */
    private static final String AUTH_URL = BASE_URL + "/v1/common/auth/selfBuiltApp/generateToken";

    /**
     * 获取访问令牌
     * 向开放平台发送认证请求，获取访问令牌
     *
     * @param appKey 应用标识
     * @param appSecret 应用密钥
     * @param authRequest 认证请求参数
     * @return 认证响应结果
     * @throws Exception 当请求发生异常时抛出
     */
    public AuthResponse getToken(String appKey, String appSecret, AuthRequest authRequest) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(authRequest);

        // 发送请求
        String response = HttpUtil.post(AUTH_URL, jsonRequest, appKey, appSecret, null);

        // 解析响应
        return objectMapper.readValue(response, AuthResponse.class);
    }
}