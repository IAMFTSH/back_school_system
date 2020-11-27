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
 * 专业
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Specialty对象", description="专业")
public class Specialty implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "specialty_id", type = IdType.AUTO)
    private Integer specialtyId;

    private Integer collegeId;

    @ApiModelProperty(value = "专业")
    private String specialtyName;

    @ApiModelProperty(value = "专业")
    private College college;

}
