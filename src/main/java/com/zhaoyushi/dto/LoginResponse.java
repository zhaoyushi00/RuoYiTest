package com.zhaoyushi.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private Boolean result;
    private ErrorResponse error;
    private ValueResponse value;

    @Data
    public static class ErrorResponse {

        private Integer code;
        private String msg;

    }

    @Data
    public static class ValueResponse{

        private String loginUrl;

    }

}
