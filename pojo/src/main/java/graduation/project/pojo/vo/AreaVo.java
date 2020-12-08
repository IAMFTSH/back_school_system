package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 地区设置
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AreaVo对象", description="地区设置")
public class AreaVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增列")
    @TableId(value = "AREA_ID", type = IdType.AUTO)
    private Integer areaId;

    @ApiModelProperty(value = "区代码")
    @TableField("AREA_CODE")
    private String areaCode;

    @ApiModelProperty(value = "父级市代码")
    @TableField("CITY_CODE")
    private String cityCode;

    @ApiModelProperty(value = "区名称")
    @TableField("AREA_NAME")
    private String areaName;

    @ApiModelProperty(value = "经度")
    @TableField("LNG")
    private String lng;

    @ApiModelProperty(value = "纬度")
    @TableField("LAT")
    private String lat;

    @ApiModelProperty(value = "状态")
    @TableField("DATA_STATE")
    private Integer dataState;


}
