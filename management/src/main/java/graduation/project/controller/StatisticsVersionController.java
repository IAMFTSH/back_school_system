package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.StatisticsVersion;
import graduation.project.service.StatisticsVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 统计表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/statistics-version")
public class StatisticsVersionController {
    @Autowired
    StatisticsVersionService statisticsVersionService;
    @GetMapping
    public Result getStatisticsVersion(int id){
        StatisticsVersion statisticsVersion = statisticsVersionService.getById(id);
        return Result.success(statisticsVersion);
    }
    @PostMapping
    public void postStatisticsVersion(@RequestBody StatisticsVersion statisticsVersion){
        boolean result = statisticsVersionService.save(statisticsVersion);
    }
    @PutMapping
    public void putStatisticsVersion(@RequestBody StatisticsVersion statisticsVersion){
        boolean result = statisticsVersionService.save(statisticsVersion);
    }
    @DeleteMapping
    public void deleteStatisticsVersion(int id){
        boolean result = statisticsVersionService.removeById(id);
    }
}

