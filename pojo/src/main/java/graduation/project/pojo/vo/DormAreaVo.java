package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import graduation.project.pojo.entity.Dorm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 宿舍表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DormArea对象", description="宿舍区表")
public class DormAreaVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "dorm_id", type = IdType.AUTO)
    private Integer dormAreaId;

    @ApiModelProperty(value = "宿舍区名")
    private String dormAreaName;

    private List<Dorm> dorms;

}
