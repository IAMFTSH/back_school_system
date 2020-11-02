package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Admin;
import graduation.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员信息表 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping
    public Result getAdmin(int id){
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }
    @PostMapping
    public void postAdmin(@RequestBody Admin admin){
        boolean result = adminService.save(admin);
    }
    @PutMapping
    public void putAdmin(@RequestBody Admin admin){
        boolean result = adminService.save(admin);
    }
    @DeleteMapping
    public void deleteAdmin(int id){
        boolean result = adminService.removeById(id);
    }
}

