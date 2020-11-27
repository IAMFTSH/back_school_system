package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.StudentMapper;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.StudentVo;
import graduation.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<StudentVo> studentSelect(StudentVo studentVo){
        List<StudentVo> students = studentMapper.selectStudent(studentVo);
        return students;
    }
    @Override
    public StudentVo selectStudentByUsername(String username) {
        return studentMapper.selectStudentByUsername(username);
    }
}
