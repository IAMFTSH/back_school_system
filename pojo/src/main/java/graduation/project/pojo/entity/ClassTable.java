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
 * 班级表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ClassTable对象", description="班级表")
public class ClassTable implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "class_table_id", type = IdType.AUTO)
    private Integer classTableId;

    @ApiModelProperty(value = "专业id")
    private Integer specialtyId;

    @ApiModelProperty(value = "班级名")
    private String classTableName;

    @ApiModelProperty(value = "是否毕业班")
    private Boolean isGraduate;

    @ApiModelProperty(value = "专业")
    private Specialty specialty;


}
