package graduation.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.pojo.entity.College;
import graduation.project.pojo.vo.CollegeVo;

import java.util.List;

/**
 * <p>
 * 学院 服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface CollegeService extends IService<College> {
    List<CollegeVo> selectCollegeToClass();
}
