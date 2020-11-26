package graduation.project.controller;

import graduation.project.common.result.Result;
import graduation.project.common.status.HttpStatus;
import graduation.project.pojo.entity.Account;
import graduation.project.service.AccountService;
import graduation.project.util.JWTUtils;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 邝明山
 * on 2020/11/22 20:19
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    AccountService accountService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    JWTUtils jwtUtils;
    @GetMapping()
    public Result get() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Account account= (Account) redisTemplate.opsForValue().get("account"+username);
        if(account==null) {
            account = accountService.accountSelectOne(username);
        }
        return Result.success(ToVo.Account(account));
    }
    @PutMapping("putAccountPhone")
    public Result putAccountPhone(@RequestParam("phone") String phone) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Account account= (Account) redisTemplate.opsForValue().get("account"+username);
        if(account==null) {
            account = accountService.accountSelectOne(username);
        }
        account.setPhone(phone);
        Boolean result =accountService.updateById(account);
        if (result == true) {
            redisTemplate.opsForValue().set("account:" + account.getUsername(), account, 1, TimeUnit.DAYS);
            return Result.success();
        } else {
            return Result.error(HttpStatus.MOVED_PERM, account.getUsername()+"账户不存在");
        }
    }
    @PutMapping("putAccountPassword")
    public Result putAccountPassword(@RequestParam("password") String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Account account= (Account) redisTemplate.opsForValue().get("account"+username);
        if(account==null) {
            account = accountService.accountSelectOne(username);
        }
        account.setPassword(passwordEncoder.encode(password));
        Boolean result =accountService.updateById(account);
        if (result == true) {
            redisTemplate.opsForValue().set("account:" + account.getUsername(), account, 1, TimeUnit.DAYS);
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(Integer.toString(account.getRole()));
            UserDetails userDetails = User.builder().username(account.getUsername()).password(password).authorities(grantedAuthorities).build();
            String jwt = jwtUtils.createToken(userDetails);
            return Result.success(jwt);
        } else {
            return Result.error(HttpStatus.MOVED_PERM, account.getUsername()+"账户不存在");
        }
    }
}
