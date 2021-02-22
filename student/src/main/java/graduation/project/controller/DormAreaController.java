package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.vo.DormAreaVo;
import graduation.project.service.DormAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 宿舍表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-12-09
 */
@RestController
@RequestMapping("student/dorm-area")
public class DormAreaController {
    @Autowired
    DormAreaService dormAreaService;
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("dormAreaAndDorm")
    public Result get(){
        List<DormAreaVo> dormAreaVos = (List<DormAreaVo>) redisTemplate.opsForValue().get("dormAreaVos");
        if(dormAreaVos==null) {
            dormAreaVos = dormAreaService.dormAreaAndDorm();
            redisTemplate.opsForValue().set("dormAreaVos",dormAreaVos);
        }
        return Result.success(dormAreaVos);
    }
}

