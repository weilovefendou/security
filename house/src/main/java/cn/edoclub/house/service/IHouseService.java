package cn.edoclub.house.service;

import cn.edoclub.house.entity.House;
import cn.edoclub.house.service.BaseService;

/**
* <p>
    *  服务类
    * </p>
*
* @author wang wei
* @since 2019-07-15
*/
public interface IHouseService extends BaseService<House> {


    House findOne(String id);
}
