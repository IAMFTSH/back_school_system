package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.College;
import graduation.project.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学院 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("teacher/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;
    @GetMapping
    public Result getCollege(int id){
        College college = collegeService.getById(id);
        return Result.success(college);
    }
    @PostMapping
    public void postCollege(@RequestBody College college){
        boolean result = collegeService.save(college);
    }
    @PutMapping
    public void putCollege(@RequestBody College college){
        boolean result = collegeService.updateById(college);
    }
    @DeleteMapping
    public void deleteCollege(int id){
        boolean result = collegeService.removeById(id);
    }
}

