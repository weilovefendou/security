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
public class ImageCodeProperties   {

	private int width = 67;
	private int height = 23;
	private int length=4;
	private int expireIn = 60;
	private String url;
	

}
