package com.css.security.core.properties;

import lombok.Data;

import java.lang.ref.PhantomReference;

@Data
public class BrowserProperties {
    private String loginPage = "/default_login.html";
    private LoginType loginType = LoginType.JSON;
    private int rememberMeSeconds = 3600;
}
