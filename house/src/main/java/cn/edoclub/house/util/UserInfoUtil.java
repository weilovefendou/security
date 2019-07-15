package cn.edoclub.house.util;

import cn.edoclub.house.hystrix.UserContextHolder;
import org.apache.commons.lang3.StringUtils;

public class UserInfoUtil {

    public static String getUserId(){
        String userId = UserContextHolder.getContext().getUserId();
        if(StringUtils.isNotBlank(userId)){
            return userId;
        }
        return "";
    }

}
