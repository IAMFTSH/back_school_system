package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Area;
import graduation.project.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地区设置 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("teacher/area")
public class AreaController {
    @Autowired
    AreaService areaService;
    @GetMapping
    public Result getArea(int id){
        Area area = areaService.getById(id);
        return Result.success(area);
    }
    @PostMapping
    public void postArea(@RequestBody Area area){
        boolean result = areaService.save(area);
    }
    @PutMapping
    public void putArea(@RequestBody Area area){
        boolean result = areaService.updateById(area);
    }
    @DeleteMapping
    public void deleteArea(int id){
        boolean result = areaService.removeById(id);
    }
}

