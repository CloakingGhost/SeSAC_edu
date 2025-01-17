package com.example.relation.global.security;

public class SecurityPathConfig {
    public static final String[] PUBLIC_GET_URLS = {
            "/posts/**",
            "/tags/**"
    };
    public static final String[] PRIVATE_GET_URLS = {
            "/my/**"
    };
}
