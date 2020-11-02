package graduation.project.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回校信息表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BackSchoolInformation对象", description="回校信息表")
public class BackSchoolInformation implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学号")
    private String username;

    @ApiModelProperty(value = "统计号")
    private Integer statisticalVersionId;

    private Integer addId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "预期返校时间")
    private LocalDate backTime;

    @ApiModelProperty(value = "是否健康")
    @TableField("is_healthy")
    private Boolean healthy;

    @ApiModelProperty(value = "体温温度")
    private String temperature;

    @ApiModelProperty(value = "是否联系上")
    @TableField("is_contact")
    private Boolean contact;

    @ApiModelProperty(value = "是否请假")
    @TableField("leave")
    private Boolean leave;

    @ApiModelProperty(value = "请假原因")
    private String leaveReason;

    @ApiModelProperty(value = "是否已回校")
    @TableField("is_back_school")
    private Boolean backSchool;

    @ApiModelProperty(value = "状态")
    private Integer state;


}
