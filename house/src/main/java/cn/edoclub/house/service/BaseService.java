package cn.edoclub.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {

    boolean add(T entity);

    boolean modify(T entity);

    boolean removeById(T entity);
}