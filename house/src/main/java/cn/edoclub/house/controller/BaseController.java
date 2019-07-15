package cn.edoclub.house.controller;

import cn.edoclub.house.bean.Result;
import cn.edoclub.house.entity.WebBaseModel;
import cn.edoclub.house.service.BaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "客户端请求错误"),
        @ApiResponse(code = 404, message = "找不到路径"),
        @ApiResponse(code = 500, message = "编译异常"),
        @ApiResponse(code=999999,message="系统异常"),
        @ApiResponse(code=000000,message="SUCCESS")
})
public class BaseController<M extends BaseService<T>, T extends WebBaseModel> {

    @Autowired
    protected M baseService;

    @ApiOperation(value="新增")
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody @Validated T entity) {
        return Result.build(() -> baseService.add(entity));
    }
    @ApiOperation(value="根据ID查询详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType="Integer")
    })
    @GetMapping("findById")
    public Result<T> findById(@RequestParam @NotNull(message = "id不能为空") final Integer id) {
        return Result.build(() -> baseService.getById(id));
    }

    @ApiOperation(value="查询全部")
    @GetMapping("list")
    public Result<List<T>> listAll() {
        return Result.build(() -> baseService.list());
    }


    @ApiOperation(value="修改")
    @PostMapping("modify")
    public Result<Boolean> modify(@RequestBody @Validated T entity) {
        return Result.build(() -> baseService.modify(entity));
    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType="Integer")
    })
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestParam @NotNull(message = "id不能为空") final Integer id) {
        return Result.build(() -> baseService.removeById(id));
    }

}