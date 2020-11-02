package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.DormMapper;
import graduation.project.pojo.entity.Dorm;
import graduation.project.service.DormService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宿舍表 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class DormServiceImpl extends ServiceImpl<DormMapper, Dorm> implements DormService {

}
