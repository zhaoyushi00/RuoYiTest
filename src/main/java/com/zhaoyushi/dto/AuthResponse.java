package com.zhaoyushi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认证响应实体类
 * 用于接收开放平台返回的认证结果
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    /**
     * 请求结果
     * true: 请求成功
     * false: 请求失败
     */
    private Boolean result;

    /**
     * 错误信息
     * 当请求失败时，包含详细的错误信息
     */
    private Error error;

    /**
     * 响应信息
     * 当请求成功时，包含认证相关的详细信息
     */
    private Value value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {
        /**
         * 错误码
         * 用于标识具体的错误类型
         */
        private Long code;

        /**
         * 错误信息
         * 描述具体的错误原因
         */
        private String msg;

        /**
         * 错误提示
         * 提供给用户的友好错误提示
         */
        private String hint;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Value {
        /**
         * 访问令牌
         * 调用开放平台接口的openToken
         */
        private String accessToken;

        /**
         * 刷新令牌
         * 用于刷新token，刷新之后原有token失效
         */
        private String refreshToken;

        /**
         * 授权范围
         * 现在默认auth_all
         */
        private String scope;

        /**
         * 访问令牌过期时间
         * accessToken的过期时间，单位s
         */
        private String expiresIn;

        /**
         * 用户ID
         * 授权的用户ID
         */
        private String userId;

        /**
         * 企业ID
         * 授权的企业ID
         */
        private String orgId;

        /**
         * 应用名称
         * 授权的应用名称
         */
        private String appName;

        /**
         * 刷新令牌过期时间
         * refreshToken的过期时间，单位s
         */
        private String refreshExpiresIn;
    }
}
