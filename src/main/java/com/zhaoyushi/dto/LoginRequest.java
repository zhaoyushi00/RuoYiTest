package com.zhaoyushi.dto;

import lombok.Data;

/**
 * 登录请求实体类
 * 用于封装向开放平台发送登录请求所需的参数
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
@Data
public class LoginRequest {
    /**
     * 账套ID
     * 用于标识要登录的具体账套
     */
    private String bookId;

    /**
     * 过滤器名称
     * 用于指定登录时的过滤条件
     */
    private String filterName;
}
