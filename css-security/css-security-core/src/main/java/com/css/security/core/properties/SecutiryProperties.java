package com.css.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "css.security")
@Data
public class SecutiryProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties  code = new ValidateCodeProperties();
}
