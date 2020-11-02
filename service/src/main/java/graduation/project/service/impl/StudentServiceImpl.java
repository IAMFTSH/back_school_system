package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.StudentMapper;
import graduation.project.pojo.entity.Student;
import graduation.project.service.StudentService;
import org.springframework.stereotype.Service;

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

}
