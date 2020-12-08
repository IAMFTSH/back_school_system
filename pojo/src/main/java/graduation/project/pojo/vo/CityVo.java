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
import java.util.List;

/**
 * <p>
 * 城市设置
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CityVo对象", description="城市")
public class CityVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增列")
    @TableId(value = "CITY_ID", type = IdType.AUTO)
    private Integer cityId;

    @ApiModelProperty(value = "市代码")
    @TableField("CITY_CODE")
    private String cityCode;

    @ApiModelProperty(value = "市名称")
    @TableField("CITY_NAME")
    private String cityName;

    @ApiModelProperty(value = "省代码")
    @TableField("PROVINCE_CODE")
    private String provinceCode;

    @ApiModelProperty(value = "经度")
    @TableField("LNG")
    private String lng;

    @ApiModelProperty(value = "纬度")
    @TableField("LAT")
    private String lat;

    @ApiModelProperty(value = "状态")
    @TableField("DATA_STATE")
    private Integer dataState;

    @ApiModelProperty(value = "区")
    private List<AreaVo> areaVo;
}
