package graduation.project.mapper;

import graduation.project.pojo.entity.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import graduation.project.pojo.vo.CollegeVo;

import java.util.List;

/**
 * <p>
 * 学院 Mapper 接口
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface CollegeMapper extends BaseMapper<College> {

    List<CollegeVo> selectCollegeToClass();
}
