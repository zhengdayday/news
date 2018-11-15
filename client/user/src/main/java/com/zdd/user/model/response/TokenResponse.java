package com.zdd.user.model.response;

import com.zdd.common.model.response.BaseResponse;

public class TokenResponse extends BaseResponse{

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
