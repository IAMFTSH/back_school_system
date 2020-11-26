package graduation.project.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-29
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AccountVo对象", description="")
public class AccountVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotBlank
    @ApiModelProperty(value = "工号/学号")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank
    @ApiModelProperty(value = "电话")
    private String phone;

    @NotNull
    @ApiModelProperty(value = "权限等级,0学生,1老师,2管理员")
    @TableField("role")
    private int role;


}
