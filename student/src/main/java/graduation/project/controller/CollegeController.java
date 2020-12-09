package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.College;
import graduation.project.pojo.entity.Specialty;
import graduation.project.pojo.vo.CollegeVo;
import graduation.project.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学院 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("student/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("collegeToClass")
    public Result collegeToClass(){
        List<CollegeVo> collegeVos = (List<CollegeVo>)redisTemplate.opsForValue().get("collegeVos");
        if(collegeVos==null) {
            collegeVos = collegeService.selectCollegeToClass();
            redisTemplate.opsForValue().set("collegeVos",collegeVos);
        }
        return Result.success(collegeVos);
    }
}

