package graduation.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import graduation.project.common.result.Result;
import graduation.project.common.status.HttpStatus;
import graduation.project.pojo.entity.Account;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.StudentVo;
import graduation.project.service.AccountService;
import graduation.project.service.StudentService;
import graduation.project.util.JWTUtils;
import graduation.project.util.ToEntity;
import graduation.project.util.ToVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 邝明山
 * on 2020/11/22 20:19
 */
@RestController
@RequestMapping("student/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    AccountService accountService;
    @GetMapping()
    public Result get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        StudentVo studentVo = studentService.selectStudentByUsername(username);
        if(studentVo!=null) {
            return Result.success(studentVo);
        }else {
            Student student = new Student();
            student.setUsername(username);
            studentService.save(student);
            studentVo = studentService.selectStudentByUsername(username);
            return Result.success(studentVo);
        }
    }

    @PutMapping
    @Transactional(rollbackFor = Exception.class)
    public void put(@RequestBody StudentVo studentVo){
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        studentVo.setUsername(username);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        Student student = ToEntity.student(studentVo);
        studentService.update(student, queryWrapper);
        Account account= (Account) redisTemplate.opsForValue().get("account"+username);
        if(account==null) {
            account = accountService.accountSelectOne(username);
        }
        account.setPhone(studentVo.getPhone());
        Boolean result =accountService.updateById(account);
        if (result == true) {
            redisTemplate.opsForValue().set("account:" + account.getUsername(), account, 1, TimeUnit.DAYS);
        }
    }
}
