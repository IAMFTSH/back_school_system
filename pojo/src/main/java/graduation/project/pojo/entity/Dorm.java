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
 * 宿舍表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dorm对象", description="宿舍表")
public class Dorm implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "dorm_id", type = IdType.AUTO)
    private Integer dormId;

    @ApiModelProperty(value = "宿舍区id")
    private String dormAreaId;

    @ApiModelProperty(value = "宿舍号")
    private Integer dormNum;


}
