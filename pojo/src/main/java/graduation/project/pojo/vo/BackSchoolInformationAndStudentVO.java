package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import graduation.project.pojo.entity.Area;
import graduation.project.pojo.entity.DormArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 回校信息表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BackSchoolInformationAndStudentVO", description = "回校信息和学生信息表")
public class BackSchoolInformationAndStudentVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer dormAreaId;

    @ApiModelProperty(value = "宿舍表id")
    private Integer dormId;

    @ApiModelProperty(value = "宿舍区名字")
    private String dormAreaName;

    @ApiModelProperty(value = "宿舍号")
    private Integer dormNum;

    @ApiModelProperty(value = "父母电话号码")
    private String parentsPhone;

    @TableId(value = "back_school_information_id", type = IdType.AUTO)
    private Integer backSchoolInformationId;

    @ApiModelProperty(value = "统计号")
    private Integer statisticsVersionId;

    @ApiModelProperty(value = "统计名")
    private String statisticsVersionName;

    @ApiModelProperty(value = "是否启用")
    private Boolean enable;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "预期返校时间")
    private Date backTime;

    @ApiModelProperty(value = "健康状态")
    private Integer HealthyState;

    @ApiModelProperty(value = "体温温度")
    private Double temperature;

    @ApiModelProperty(value = "是否联系上")
    private Boolean isContact;

    @ApiModelProperty(value = "是否请假")
    private Boolean isLeave;

    @ApiModelProperty(value = "请假原因")
    private String leaveReason;

    @ApiModelProperty(value = "是否已回校")
    private Boolean isBackSchool;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "区代码")
    private String areaCode;

    @ApiModelProperty(value = "区名称")
    private String areaName;

    @ApiModelProperty(value = "市代码")
    private String cityCode;

    @ApiModelProperty(value = "市名称")
    private String cityName;

    @ApiModelProperty(value = "省份代码")
    private String provinceCode;

    @ApiModelProperty(value = "省份名称")
    private String provinceName;

    @ApiModelProperty(value = "电话")
    private String phone;
}
