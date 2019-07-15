package cn.edoclub.house.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 *
 * </p>
 *
 * @author wang wei
 * @since 2019-07-15
 */
@ApiModel(value = "房源模型")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class House extends WebBaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * 主键id
     * <p>
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * <p>
     * 房产名称
     * <p>
     */
    @ApiModelProperty(value = "房产名称")
    private String name;
    /**
     * <p>
     * 1:销售，2:出租
     * <p>
     */
    @ApiModelProperty(value = "1:销售，2:出租")
    private Boolean type;
    /**
     * <p>
     * 单位元
     * <p>
     */
    @ApiModelProperty(value = "单位元")
    private Integer price;
    /**
     * <p>
     * 图片地址
     * <p>
     */
    @ApiModelProperty(value = "图片地址")
    private String images;
    /**
     * <p>
     * 面积
     * <p>
     */
    @ApiModelProperty(value = "面积")
    private Integer area;
    /**
     * <p>
     * 卧室数量
     * <p>
     */
    @ApiModelProperty(value = "卧室数量")
    @NotNull(message = "不能为空！")
    private Integer beds;
    /**
     * <p>
     * 卫生间数量
     * <p>
     */
    @ApiModelProperty(value = "卫生间数量")
    private Integer baths;
    /**
     * <p>
     * 评级
     * <p>
     */
    @ApiModelProperty(value = "评级")
    private Double rating;
    /**
     * <p>
     * 房产描述
     * <p>
     */
    @ApiModelProperty(value = "房产描述")
    private String remarks;
    /**
     * <p>
     * 属性
     * <p>
     */
    @ApiModelProperty(value = "属性")
    private String properties;
    /**
     * <p>
     * 户型图
     * <p>
     */
    @ApiModelProperty(value = "户型图")
    private String floorPlan;
    /**
     * <p>
     * 标签
     * <p>
     */
    @ApiModelProperty(value = "标签")
    private String tags;
    /**
     * <p>
     * 城市名称
     * <p>
     */
    @ApiModelProperty(value = "城市名称")
    private Integer cityId;
    /**
     * <p>
     * 小区名称
     * <p>
     */
    @ApiModelProperty(value = "小区名称")
    private Integer communityId;
    /**
     * <p>
     * 房产地址
     * <p>
     */
    @ApiModelProperty(value = "房产地址")
    private String address;
    /**
     * <p>
     * 1-上架，2-下架
     * <p>
     */
    @ApiModelProperty(value = "1-上架，2-下架")
    private Boolean state;


}