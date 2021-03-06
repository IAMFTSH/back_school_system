package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.DormAreaMapper;
import graduation.project.pojo.entity.DormArea;
import graduation.project.pojo.vo.DormAreaVo;
import graduation.project.service.DormAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 宿舍表 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-12-09
 */
@Service
public class DormAreaServiceImpl extends ServiceImpl<DormAreaMapper, DormArea> implements DormAreaService {

    @Autowired
    DormAreaMapper dormAreaMapper;
    @Override
    public List<DormAreaVo> dormAreaAndDorm() {

        return dormAreaMapper.dormAreaAndDorm();
    }
}
