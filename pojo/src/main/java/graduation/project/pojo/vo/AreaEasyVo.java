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
public class AreaEasyVo implements Serializable {

    private static final long serialVersionUID=1L;



    @ApiModelProperty(value = "区代码")
    @TableField("AREA_CODE")
    private String code;

    @ApiModelProperty(value = "区名称")
    @TableField("AREA_NAME")
    private String name;


}
