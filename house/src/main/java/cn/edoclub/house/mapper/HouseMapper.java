package cn.edoclub.house.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import cn.edoclub.house.entity.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author wang wei
* @since 2019-07-15
*/
@Mapper
public interface HouseMapper extends BaseMapper<House> {

    House findOne(String id);
}
