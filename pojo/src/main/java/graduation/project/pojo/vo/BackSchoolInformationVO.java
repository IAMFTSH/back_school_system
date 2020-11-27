package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "BackSchoolInformationAndStudentVO", description = "回校信息表")
public class BackSchoolInformationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学号")
    private String username;

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

    @ApiModelProperty(value = "是否健康")
    private Boolean isHealthy;

    @ApiModelProperty(value = "体温温度")
    private String temperature;

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


}
