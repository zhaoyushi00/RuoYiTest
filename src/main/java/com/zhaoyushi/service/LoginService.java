package com.zhaoyushi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoyushi.dto.LoginRequest;
import com.zhaoyushi.dto.LoginResponse;
import com.zhaoyushi.util.HttpUtil;

public class LoginService {

    private static final String BASE_URL = "https://openapi.chanjet.com";
    private static final String LOGIN_URL = BASE_URL + "/v2/common/authSite/sso/getLoginUrl";

    public LoginResponse getLoginUrl(LoginRequest request, String appKey, String appSecret, String openToken) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(request);

        // 发送请求
        String response = HttpUtil.post(LOGIN_URL, jsonRequest, appKey, appSecret, openToken);

        // 解析响应
        return objectMapper.readValue(response, LoginResponse.class);
    }
}