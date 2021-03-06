package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.vo.BackSchoolInformationAndStudentVO;
import graduation.project.service.BackSchoolInformationService;
import graduation.project.service.BackSchoolInformationService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("teacher/back-school-information")
public class BackSchoolInformationController {
    @Autowired
    BackSchoolInformationService backSchoolInformationService;

    @GetMapping
    public Result getBackSchoolInformation(int id){
        BackSchoolInformation BackSchoolInformation = backSchoolInformationService.getById(id);
        return Result.success(BackSchoolInformation);
    }

    @GetMapping("List")
    public Result getList(BackSchoolInformationAndStudentVO backSchoolInformationAndStudentVO){
        List<BackSchoolInformationAndStudentVO> backSchoolInformationAndStudentVOS = backSchoolInformationService.selectBackSchoolInformationMapperAndStudent(backSchoolInformationAndStudentVO);
        return Result.success(backSchoolInformationAndStudentVOS);
    }
    @PostMapping
    public void postBackSchoolInformation(@RequestBody BackSchoolInformation BackSchoolInformation){
        boolean result = backSchoolInformationService.save(BackSchoolInformation);
    }
    @PutMapping
    public void putBackSchoolInformation(@RequestBody BackSchoolInformation BackSchoolInformation){
        boolean result = backSchoolInformationService.updateById(BackSchoolInformation);
    }
    @DeleteMapping
    public void deleteBackSchoolInformation(int id){
        boolean result = backSchoolInformationService.removeById(id);
    }
}

