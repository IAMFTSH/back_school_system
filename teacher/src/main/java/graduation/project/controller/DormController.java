package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Dorm;
import graduation.project.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 宿舍表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("teacher/dorm")
public class DormController {
    @Autowired
    DormService dormService;
    @GetMapping
    public Result getDorm(int id){
        Dorm dorm = dormService.getById(id);
        return Result.success(dorm);
    }
    @PostMapping
    public void postDorm(@RequestBody Dorm dorm){
        boolean result = dormService.save(dorm);
    }
    @PutMapping
    public void putDorm(@RequestBody Dorm dorm){
        boolean result = dormService.updateById(dorm);
    }
    @DeleteMapping
    public void deleteDorm(int id){
        boolean result = dormService.removeById(id);
    }
}

