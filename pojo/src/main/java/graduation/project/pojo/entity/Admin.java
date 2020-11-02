package graduation.project.pojo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员信息表
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="管理员信息表")
public class Admin implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    @ApiModelProperty(value = "工号")
    private Integer username;

    @ApiModelProperty(value = "管理员姓名")
    private String name;


}
