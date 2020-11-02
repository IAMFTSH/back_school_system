package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.City;
import graduation.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 城市设置 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;
    @GetMapping
    public Result getCity(int id){
        City city = cityService.getById(id);
        return Result.success(city);
    }
    @PostMapping
    public void postCity(@RequestBody City city){
        boolean result = cityService.save(city);
    }
    @PutMapping
    public void putCity(@RequestBody City city){
        boolean result = cityService.save(city);
    }
    @DeleteMapping
    public void deleteCity(int id){
        boolean result = cityService.removeById(id);
    }
}
