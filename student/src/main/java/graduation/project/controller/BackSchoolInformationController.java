package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.pojo.vo.BackSchoolInformationVO;
import graduation.project.service.BackSchoolInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 回校信息表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("student/back-school-information")
public class BackSchoolInformationController {
    @Autowired
    BackSchoolInformationService backSchoolInformationService;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping
    public Result get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        BackSchoolInformationVO backSchoolInformationVO = backSchoolInformationService.selectBackSchoolInformationByUsername(username);
        if (backSchoolInformationVO != null) {
            return Result.success(backSchoolInformationVO);
        } else {
            BackSchoolInformation backSchoolInformation = new BackSchoolInformation();
            backSchoolInformation.setUsername(username);
            backSchoolInformation.setStatisticsVersionId((Integer) redisTemplate.opsForValue().get("statistics_version_id"));
            backSchoolInformationVO = backSchoolInformationService.selectBackSchoolInformationByUsername(username);
            return Result.success(backSchoolInformationVO);
        }
    }

    @PutMapping
    public void putBackSchoolInformation(@RequestBody BackSchoolInformation BackSchoolInformation) {
        boolean result = backSchoolInformationService.updateById(BackSchoolInformation);
    }
}

