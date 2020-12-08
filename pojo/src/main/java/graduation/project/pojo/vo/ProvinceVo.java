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
 * 省份设置
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Province对象", description="省份")
public class ProvinceVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增列")
    private Integer provinceId;

    @ApiModelProperty(value = "省份代码")
    private String provinceCode;

    @ApiModelProperty(value = "省份名称")
    private String provinceName;

    @ApiModelProperty(value = "经度")
    private String lng;

    @ApiModelProperty(value = "纬度")
    private String lat;

    @ApiModelProperty(value = "状态")
    private Integer dataState;

    @ApiModelProperty(value = "市")
    private List<CityVo> cityVo;

}
