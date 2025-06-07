package com.zhaoyushi;

import com.zhaoyushi.dto.AuthRequest;
import com.zhaoyushi.dto.AuthResponse;
import com.zhaoyushi.dto.LoginRequest;
import com.zhaoyushi.dto.LoginResponse;
import com.zhaoyushi.service.AuthService;
import com.zhaoyushi.service.LoginService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 应用程序入口类
 * 用于启动Spring Boot应用程序并演示认证和登录功能
 *
 * @author zhaoyushi
 * @since 2024-01-01
 */
@SpringBootApplication
public class RuoYiTestApplication {

	/**
	 * 应用程序入口方法
	 * 演示如何使用AuthService和LoginService进行认证和登录操作
	 *
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		// 创建认证服务实例
		AuthService authService = new AuthService();

		// 构建认证请求参数
		AuthRequest authRequest = new AuthRequest();
		authRequest.setAppTicket("t-c93a53709d5b4df28cee22f3dab63fbd");
		authRequest.setCertificate("Jng211t58sLzWg4VUotlTSbhmzL5LxO7Q17hJL07rnG2vTKK2lJ5Qn2uto2U/2PmA0k39LeCifa9JQAoigP2lV5UDccT5w2GxC81PKk4JN6g8zwxlmJSkIbPLHvi4BrA6JD+Ueh3Dh76eGOP0CDFKQ==");

		try {
			// 获取访问令牌
			AuthResponse authResponse = authService.getToken("DyqLZrdt", "5A42A7B0A5F1C98040AF32DA9E21E638", authRequest);
			System.out.println("Access Token: " + authResponse.getValue().getAccessToken());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		try {
			// 创建登录服务实例
			LoginService loginService = new LoginService();

			// 构建登录请求参数
			LoginRequest request = new LoginRequest();
			request.setBookId("1518784941916160");
			request.setFilterName("exampleFilter");

			// 设置认证信息
			String appKey = "DyqLZrdt";
			String appSecret = "5A42A7B0A5F1C98040AF32DA9E21E638";
			String openToken = "yourOpenToken";

			// 获取登录URL
			LoginResponse response = loginService.getLoginUrl(request, appKey, appSecret, openToken);

			// 处理响应结果
			if (response.getResult()) {
				System.out.println("Login URL: " + response.getValue().getLoginUrl());
			} else {
				System.out.println("Error: " + response.getError().getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
