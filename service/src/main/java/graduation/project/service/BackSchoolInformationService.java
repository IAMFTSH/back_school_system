package graduation.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.pojo.vo.BackSchoolInformationVO;

import java.util.List;

/**
 * <p>
 * 回校信息表 服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface BackSchoolInformationService extends IService<BackSchoolInformation> {
    public List<BackSchoolInformationAndStudentVO> selectBackSchoolInformationMapperAndStudent(BackSchoolInformationAndStudentVO backSchoolInformationAndStudentVO);

    BackSchoolInformationVO selectBackSchoolInformation(String username);
}
