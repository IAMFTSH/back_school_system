package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.BackSchoolInformationMapper;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.pojo.vo.BackSchoolInformationVO;
import graduation.project.service.BackSchoolInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 回校信息表 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class BackSchoolInformationServiceImpl extends ServiceImpl<BackSchoolInformationMapper, BackSchoolInformation> implements BackSchoolInformationService {

    @Autowired
    private BackSchoolInformationMapper backSchoolInformationMapper;

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public List<BackSchoolInformationAndStudentVO> selectBackSchoolInformationMapperAndStudent(BackSchoolInformationAndStudentVO backSchoolInformationAndStudentVO) {
        System.out.println(backSchoolInformationAndStudentVO);
        return backSchoolInformationMapper.selectBackSchoolInformationMapperAndStudent(backSchoolInformationAndStudentVO);
    }
    @Override
    public BackSchoolInformationVO selectBackSchoolInformation(String username) {
        int statisticsVersionId=(int)redisTemplate.opsForValue().get("statisticsVersionId");
        return backSchoolInformationMapper.selectBackSchoolInformation(username,statisticsVersionId);
    }
}
