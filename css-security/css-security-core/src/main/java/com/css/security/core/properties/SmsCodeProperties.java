/**
 * 
 */
package com.css.security.core.properties;

import lombok.Data;

/**
 * 图片验证码配置项
 * 
 * @author zhailiang
 *
 */
@Data
public class SmsCodeProperties {

	private int length=6;
	private int expireIn = 60;
	private String url;
	

}
