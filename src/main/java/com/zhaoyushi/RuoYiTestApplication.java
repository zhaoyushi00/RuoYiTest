package com.zhaoyushi;

import com.zhaoyushi.dto.LoginRequest;
import com.zhaoyushi.dto.LoginResponse;
import com.zhaoyushi.service.LoginService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuoYiTestApplication {

	public static void main(String[] args) {
		try {
			LoginService authService = new LoginService();

			LoginRequest request = new LoginRequest();
			request.setBookId("1518784941916160");
			request.setFilterName("exampleFilter");

			String appKey = "DyqLZrdt";
			String appSecret = "5A42A7B0A5F1C98040AF32DA9E21E638";
			String openToken = "yourOpenToken";

			LoginResponse response = authService.getLoginUrl(request, appKey, appSecret, openToken);

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
