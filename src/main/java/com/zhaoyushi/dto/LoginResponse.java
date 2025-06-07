package com.zhaoyushi.dto;

import lombok.Data;

/**
 * 登录响应实体类
 * 用于接收开放平台返回的登录结果
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
@Data
public class LoginResponse {
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
    private ErrorResponse error;

    /**
     * 响应信息
     * 当请求成功时，包含登录相关的详细信息
     */
    private ValueResponse value;

    /**
     * 错误信息内部类
     * 用于封装具体的错误详情
     */
    @Data
    public static class ErrorResponse {
        /**
         * 错误码
         * 用于标识具体的错误类型
         */
        private Integer code;

        /**
         * 错误信息
         * 描述具体的错误原因
         */
        private String msg;
    }

    /**
     * 响应值内部类
     * 用于封装登录成功后的详细信息
     */
    @Data
    public static class ValueResponse {
        /**
         * 登录URL
         * 用户需要访问的登录页面地址
         */
        private String loginUrl;
    }
}
