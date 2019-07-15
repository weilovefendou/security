package cn.edoclub.house.controller;


import cn.edoclub.house.bean.Result;
import cn.edoclub.house.entity.House;
import cn.edoclub.house.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
* <p>
*  前端控制器
* </p>
*
* @author wang wei
* @since 2019-07-15
*/
@Api(tags = {"房源信息表操作"})
@Slf4j
@Validated
@RestController
@RequestMapping("/house")
public class HouseController extends BaseController< IHouseService, House>  {


    @GetMapping("addHouse")
    @ApiOperation("自定义添加")
    public Result addHouse(){
        int i = 1/0;
        return null;
    }


    @Override
    public Result<Boolean> add(@RequestBody @Validated House entity) {
        log.info("我是重写的方法！！！");
        return super.add(entity);
    }

    @GetMapping("findById1")
    @ApiOperation("也是新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType="String")
    })
    public Result<House> findById(@NotNull(message = "id不能为空") String id) {
        return Result.build(() -> baseService.findOne(id));
    }
}

