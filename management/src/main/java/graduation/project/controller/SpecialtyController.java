package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Specialty;
import graduation.project.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 专业 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/specialty")
public class SpecialtyController {
    @Autowired
    SpecialtyService specialtyService;
    @GetMapping
    public Result getSpecialty(int id){
        Specialty specialty = specialtyService.getById(id);
        return Result.success(specialty);
    }
    @PostMapping
    public void postSpecialty(@RequestBody Specialty specialty){
        boolean result = specialtyService.save(specialty);
    }
    @PutMapping
    public void putSpecialty(@RequestBody Specialty specialty){
        boolean result = specialtyService.save(specialty);
    }
    @DeleteMapping
    public void deleteSpecialty(int id){
        boolean result = specialtyService.removeById(id);
    }
}

