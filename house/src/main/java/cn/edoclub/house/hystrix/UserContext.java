package cn.edoclub.house.hystrix;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserContext {

    public static final String AUTH_TOKEN     = "Authorization";
    public static final String USER_ID        = "userId";
    public static final String BEHAVIOUR_ID = "behaviourId";
    public static final String UUID = "uuid";
    public static final String USER_NAME = "userName";

    private String authToken= new String();
    private String userId = new String();
    private String behaviourId = new String();
    private String uuid = new String();
    private String userName = new String();
}
