package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.CollegeMapper;
import graduation.project.pojo.entity.College;
import graduation.project.pojo.vo.CollegeVo;
import graduation.project.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
@Autowired
CollegeMapper collegeMapper;
    @Override
    public List<CollegeVo> selectCollegeToClass() {
        List<CollegeVo> collegeVos = collegeMapper.selectCollegeToClass();
        return collegeVos;
    }
}
