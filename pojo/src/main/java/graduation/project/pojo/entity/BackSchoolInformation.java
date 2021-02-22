package graduation.project.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value="BackSchoolInformation对象", description="回校信息表")
public class BackSchoolInformation implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "back_school_information_id", type = IdType.AUTO)
    private Integer backSchoolInformationId;

    @ApiModelProperty(value = "学号")
    private String username;

    @ApiModelProperty(value = "统计号")
    private Integer statisticsVersionId;

    private String areaCode;

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

}
