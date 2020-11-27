package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.StudentVo;
import graduation.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("teacher/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public Result getStudent(int id){
        Student student = studentService.getById(id);
        return Result.success(student);
    }
    @GetMapping("list")
    public Result getStudentList(StudentVo studentVo ){
        List<StudentVo> studentVos = studentService.studentSelect(studentVo);
        return Result.success(studentVos);
    }

    @PostMapping
    public void postStudent(@RequestBody Student student){
        boolean result = studentService.save(student);
    }
    @PutMapping
    public void putStudent(@RequestBody Student student){
        boolean result = studentService.updateById(student);
    }
    @DeleteMapping
    public void deleteStudent(int id){
        boolean result = studentService.removeById(id);
    }


}

