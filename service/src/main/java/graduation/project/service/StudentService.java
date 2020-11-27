package graduation.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.StudentVo;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface StudentService extends IService<Student> {
    public List<StudentVo> studentSelect(StudentVo studentVo);

    StudentVo selectStudentByUsername(String username);
}
