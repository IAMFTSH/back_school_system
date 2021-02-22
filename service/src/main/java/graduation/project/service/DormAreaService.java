package graduation.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.pojo.entity.DormArea;
import graduation.project.pojo.vo.DormAreaVo;

import java.util.List;

/**
 * <p>
 * 宿舍表 服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-12-09
 */
public interface DormAreaService extends IService<DormArea> {
    List<DormAreaVo> dormAreaAndDorm();
}
