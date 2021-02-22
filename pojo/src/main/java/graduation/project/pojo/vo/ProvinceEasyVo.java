package graduation.project.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class ProvinceEasyVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "省份代码")
    private String code;

    @ApiModelProperty(value = "省份名称")
    private String name;

    @ApiModelProperty(value = "市")
    private List<CityEasyVo> cities;

}
