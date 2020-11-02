package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.CollegeMapper;
import graduation.project.pojo.entity.College;
import graduation.project.service.CollegeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学院 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {

}
