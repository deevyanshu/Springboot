package com.deevyanshu.auth.model.dto;

public class JwtResponse {

    private String token;

    private String type;

    private String validUntil;

    public JwtResponse() {
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", validUntil='" + validUntil + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public JwtResponse(String token, String type, String validUntil) {
        this.token = token;
        this.type = type;
        this.validUntil = validUntil;
    }
}
