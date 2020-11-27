package graduation.project.mapper;

import graduation.project.pojo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import graduation.project.pojo.vo.StudentVo;

import java.util.List;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 搜索学生信息
     *
     * @return
     */
    List<StudentVo> selectStudent(StudentVo studentVo);

    StudentVo selectStudentByUsername(String username);
}
