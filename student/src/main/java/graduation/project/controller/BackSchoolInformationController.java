package graduation.project.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Account;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.pojo.vo.BackSchoolInformationVO;
import graduation.project.service.AccountService;
import graduation.project.service.BackSchoolInformationService;
import graduation.project.util.ToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    AccountService accountService;
    @GetMapping
    public Result get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        BackSchoolInformationVO backSchoolInformationVO = backSchoolInformationService.selectBackSchoolInformation(username);
        if (backSchoolInformationVO != null) {
            return Result.success(backSchoolInformationVO);
        } else {
            BackSchoolInformation backSchoolInformation = new BackSchoolInformation();
            backSchoolInformation.setUsername(username);
            backSchoolInformation.setIsBackSchool(false);
            backSchoolInformation.setHealthyState(0);
            backSchoolInformation.setTemperature(36.5D);
            backSchoolInformation.setIsLeave(false);
            backSchoolInformation.setIsContact(true);
            backSchoolInformation.setState(0);
            backSchoolInformation.setStatisticsVersionId((Integer) redisTemplate.opsForValue().get("statisticsVersionId"));
            backSchoolInformationService.save(backSchoolInformation);
            backSchoolInformationVO = backSchoolInformationService.selectBackSchoolInformation(username);
            return Result.success(backSchoolInformationVO);
        }
    }

    @PutMapping
    public void put(@RequestBody BackSchoolInformation backSchoolInformation) {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        backSchoolInformation.setUsername(username);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        queryWrapper.eq("statistics_version_id",backSchoolInformation.getStatisticsVersionId());
        backSchoolInformationService.update(backSchoolInformation,queryWrapper);

    }
}

