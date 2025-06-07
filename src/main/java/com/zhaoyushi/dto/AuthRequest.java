package com.zhaoyushi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认证请求实体类
 * 用于封装向开放平台发送认证请求所需的参数
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    /**
     * 应用票据
     * 需要先在自建应用的"消息订阅"菜单里，把[消息秘钥]和[消息接收地址]配置好
     * 每隔10分钟平台会向应用的消息接收地址发送的appTicket（每个appTicket的有效期是30分钟）
     */
    private String appTicket;

    /**
     * 加密证书
     * 自建应用通过管理员授权后获得
     * 用于验证应用的身份和权限
     */
    private String certificate;
}