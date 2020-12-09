package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import graduation.project.pojo.entity.ClassTable;
import graduation.project.pojo.entity.Dorm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 邝明山
 * on 2020/11/27 12:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StudentVo", description="")
public class StudentVo {

    private static final long serialVersionUID=1L;

    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    @ApiModelProperty(value = "学号")
    private String username;

    @ApiModelProperty(value = "名字")
    private String studentName;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "班级表id")
    private Integer classTableId;

    @ApiModelProperty(value = "班级名")
    private String classTableName;

    @ApiModelProperty(value = "是否毕业班")
    private Boolean isGraduate;

    private Integer specialtyId;

    @ApiModelProperty(value = "专业")
    private String specialtyName;

    private Integer collegeId;

    @ApiModelProperty(value = "学院名")
    private String collegeName;

    @ApiModelProperty(value = "宿舍表id")
    private Integer dormId;

    @ApiModelProperty(value = "宿舍区Id")
    private String dormAreaId;

    @ApiModelProperty(value = "宿舍号")
    private Integer dormNum;

    @ApiModelProperty(value = "宿舍号")
    private String dormAreaName;

    @ApiModelProperty(value = "父母电话号码")
    private String parentsPhone;
}
