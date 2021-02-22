package graduation.project.mapper;

import graduation.project.pojo.entity.BackSchoolInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.pojo.vo.BackSchoolInformationVO;

import java.util.List;

/**
 * <p>
 * 回校信息表 Mapper 接口
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface BackSchoolInformationMapper extends BaseMapper<BackSchoolInformation> {

    List<BackSchoolInformationAndStudentVO> selectBackSchoolInformationMapperAndStudent(BackSchoolInformationAndStudentVO backSchoolInformationAndStudentVO);

    BackSchoolInformationVO selectBackSchoolInformation(String username,int statisticsVersionId);
}
