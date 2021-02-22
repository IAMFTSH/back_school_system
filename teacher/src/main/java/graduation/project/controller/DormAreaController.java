package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.DormArea;
import graduation.project.service.DormAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 宿舍表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-12-09
 */
@RestController
@RequestMapping("teacher/dorm-area")
public class DormAreaController {
    @Autowired
    DormAreaService dormAreaService;
    @GetMapping
    public Result get(int id){
        DormArea dormArea = dormAreaService.getById(id);
        return Result.success(dormArea);
    }
    @PostMapping
    public void post(@RequestBody DormArea dormArea){
        boolean result = dormAreaService.save(dormArea);
    }
    @PutMapping
    public void put(@RequestBody DormArea dormArea){
        boolean result = dormAreaService.updateById(dormArea);
    }
    @DeleteMapping
    public void delete(int id){
        boolean result = dormAreaService.removeById(id);
    }
}

