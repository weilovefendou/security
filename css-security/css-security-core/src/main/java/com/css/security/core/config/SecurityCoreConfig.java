package com.css.security.core.config;

import com.css.security.core.properties.SecutiryProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecutiryProperties.class)
public class SecurityCoreConfig {
}
