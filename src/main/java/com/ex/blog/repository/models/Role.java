package com.ex.blog.repository.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,ADMIN;
    @Override
    public String getAuthority(){
        return name();
    }
}