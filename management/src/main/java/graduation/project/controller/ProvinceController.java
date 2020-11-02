package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Province;
import graduation.project.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 省份设置 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping
    public Result getProvince(int id){
        Province province = provinceService.getById(id);
        return Result.success(province);
    }
    @PostMapping
    public void postProvince(@RequestBody Province province){
        boolean result = provinceService.save(province);
    }
    @PutMapping
    public void putProvince(@RequestBody Province province){
        boolean result = provinceService.updateById(province);
    }
    @DeleteMapping
    public void deleteProvince(int id){
        boolean result = provinceService.removeById(id);
    }
}

