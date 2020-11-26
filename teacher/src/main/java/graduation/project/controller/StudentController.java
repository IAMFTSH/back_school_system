package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Student;
import graduation.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

