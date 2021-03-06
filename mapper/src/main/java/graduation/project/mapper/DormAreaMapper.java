package graduation.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import graduation.project.pojo.entity.DormArea;
import graduation.project.pojo.vo.DormAreaVo;

import java.util.List;

/**
 * <p>
 * 宿舍表 Mapper 接口
 * </p>
 *
 * @author 邝明山
 * @since 2020-12-09
 */
public interface DormAreaMapper extends BaseMapper<DormArea> {

    List<DormAreaVo> dormAreaAndDorm();
}
