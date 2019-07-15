package cn.edoclub.house.service.impl;

import cn.edoclub.house.entity.WebBaseModel;
import cn.edoclub.house.service.BaseService;
import cn.edoclub.house.util.UserInfoUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

public class BaseServiceImpl<M extends BaseMapper<T>, T extends WebBaseModel> extends ServiceImpl<M, T> implements BaseService<T> {

    @Transactional
    public boolean add(T entity) {
        entity.setCreateUserId(UserInfoUtil.getUserId());
        return this.save(entity);
    }

    @Transactional
    public boolean modify(T entity) {
        entity.setUpdateUserId(UserInfoUtil.getUserId());
        return this.updateById(entity);
    }
    @Transactional
    @Override
    public boolean removeById(T entity){
        entity.setUpdateUserId(UserInfoUtil.getUserId());
        entity.setDelFlag(1);
        return this.updateById(entity);
    }
}