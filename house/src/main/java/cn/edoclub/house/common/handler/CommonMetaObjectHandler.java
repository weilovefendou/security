package cn.edoclub.house.common.handler;

import cn.edoclub.house.util.UserInfoUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createUserId", UserInfoUtil.getUserId(), metaObject);
        setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        log.debug("新增的时候记录创建时间和创建人");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateUserId", UserInfoUtil.getUserId(), metaObject);
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        log.debug("更新的时候记录更新时间和更新人");
    }
}
