package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import graduation.project.pojo.entity.Specialty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 学院
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="College对象", description="学院")
public class CollegeVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "college_id", type = IdType.AUTO)
    private Integer collegeId;

    @ApiModelProperty(value = "学院名")
    private String collegeName;

    @ApiModelProperty(value = "专业")
    private List<SpecialtyVo> specialtyVo;
}
