package graduation.project.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 省份设置
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Province对象", description="省份设置")
public class Province implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增列")
    @TableId(value = "PROVINCE_ID", type = IdType.AUTO)
    private Integer provinceId;

    @ApiModelProperty(value = "省份代码")
    @TableField("PROVINCE_CODE")
    private String provinceCode;

    @ApiModelProperty(value = "省份名称")
    @TableField("PROVINCE_NAME")
    private String provinceName;

    @ApiModelProperty(value = "简称")
    @TableField("SHORT_NAME")
    private String shortName;

    @ApiModelProperty(value = "经度")
    @TableField("LNG")
    private String lng;

    @ApiModelProperty(value = "纬度")
    @TableField("LAT")
    private String lat;

    @ApiModelProperty(value = "排序")
    @TableField("SORT")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @TableField("GMT_CREATE")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField("GMT_MODIFIED")
    private Date gmtModified;

    @ApiModelProperty(value = "备注")
    @TableField("MEMO")
    private String memo;

    @ApiModelProperty(value = "状态")
    @TableField("DATA_STATE")
    private Integer dataState;

    @ApiModelProperty(value = "租户ID")
    @TableField("TENANT_CODE")
    private String tenantCode;


}
