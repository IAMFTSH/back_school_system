package graduation.project.mapper;

import graduation.project.pojo.entity.Province;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import graduation.project.pojo.vo.ProvinceEasyVo;
import graduation.project.pojo.vo.ProvinceVo;

import java.util.List;

/**
 * <p>
 * 省份设置 Mapper 接口
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface ProvinceMapper extends BaseMapper<Province> {

    List<ProvinceEasyVo> all();
}
