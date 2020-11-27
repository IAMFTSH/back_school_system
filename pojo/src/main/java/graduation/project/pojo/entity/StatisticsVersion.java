package graduation.project.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 统计表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StatisticsVersion对象", description="统计表")
public class StatisticsVersion implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "statistics_version_id", type = IdType.AUTO)
    private Integer statisticsVersionId;

    @ApiModelProperty(value = "统计名")
    private String statisticsVersionName;

    @ApiModelProperty(value = "是否启用")
    private Boolean enable;

}
