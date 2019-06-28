package com.css.security.browser.controller;

import com.css.security.browser.support.SimpleResponse;
import com.css.security.core.properties.SecutiryProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SecutiryProperties secutiryProperties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code= HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request,response);

        if(savedRequest!=null){
            String targetURL = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是：：：" + targetURL);
            if(StringUtils.endsWithIgnoreCase(targetURL,".html")){
                log.info("最终跳转的路径：：："+secutiryProperties.getBrowser().getLoginPage());
                redirectStrategy.sendRedirect(request,response,secutiryProperties.getBrowser().getLoginPage());
            }
        }
        return  new SimpleResponse("访问的服务需要身份认证！");
    }
}
