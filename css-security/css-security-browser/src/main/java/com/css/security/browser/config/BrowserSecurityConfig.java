/**
 * 
 */
package com.css.security.browser.config;

import com.css.security.browser.authentication.CssAuthenticationFailureHandler;
import com.css.security.browser.authentication.CssAuthenticationSuccessHandler;
import com.css.security.core.filter.ValidateCodeFilter;
import com.css.security.core.properties.SecutiryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 浏览器环境下安全配置主类
 * 
 * @author  wangwei
 *
 */

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecutiryProperties secutiryProperties;

	@Autowired
	private CssAuthenticationSuccessHandler cssAuthenticationSuccessHandler;
	@Autowired
	private CssAuthenticationFailureHandler cssAuthenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(cssAuthenticationFailureHandler);
		validateCodeFilter.setSecutiryProperties(secutiryProperties);
		validateCodeFilter.afterPropertiesSet();

		http.addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)
				.formLogin()
				.loginPage("/authentication/require")//告诉security 如果没有认证，那么就跳转到这个页面
				.loginProcessingUrl("/authentication/form")//告诉security过滤器（usernamepasswordfilter），校验这个路径传过来的表单信息
				.successHandler(cssAuthenticationSuccessHandler)
				.failureHandler(cssAuthenticationFailureHandler)
				.and()
				.authorizeRequests()
				.antMatchers("/authentication/require",secutiryProperties.getBrowser().getLoginPage(),"/code/image").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf().disable();
	}


	@Bean
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}

}
