package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.ClassTable;
import graduation.project.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 班级表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/class-table")
public class ClassTableController {
    @Autowired
    ClassTableService classTableService;
    @GetMapping
    public Result getClassTable(int id){
        ClassTable classTable = classTableService.getById(id);
        return Result.success(classTable);
    }
    @PostMapping
    public void postClassTable(@RequestBody ClassTable classTable){
        boolean result = classTableService.save(classTable);
    }
    @PutMapping
    public void putClassTable(@RequestBody ClassTable classTable){
        boolean result = classTableService.updateById(classTable);
    }
    @DeleteMapping
    public void deleteClassTable(int id){
        boolean result = classTableService.removeById(id);
    }
}

