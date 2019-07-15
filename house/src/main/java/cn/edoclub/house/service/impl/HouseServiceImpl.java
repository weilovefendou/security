package cn.edoclub.house.service.impl;

import cn.edoclub.house.entity.House;
import cn.edoclub.house.mapper.HouseMapper;
import cn.edoclub.house.service.IHouseService;
import cn.edoclub.house.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wang wei
* @since 2019-07-15
*/
@Service
public class HouseServiceImpl extends BaseServiceImpl<HouseMapper, House> implements IHouseService {

    @Override
    public House findOne(String id) {
       House house =  baseMapper.findOne(id+"");
        return null;
    }
}
