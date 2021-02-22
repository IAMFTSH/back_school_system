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
public class CityEasyVo implements Serializable {

    private static final long serialVersionUID=1L;


    @ApiModelProperty(value = "市代码")
    @TableField("CITY_CODE")
    private String code;

    @ApiModelProperty(value = "市名称")
    @TableField("CITY_NAME")
    private String name;

    @ApiModelProperty(value = "区")
    private List<AreaEasyVo> areas;
}
