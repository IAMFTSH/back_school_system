package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.common.status.HttpStatus;
import graduation.project.pojo.entity.Account;
import graduation.project.common.exception.XlsxException;
import graduation.project.service.AccountService;
import graduation.project.util.ToEntity;
import graduation.project.pojo.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/register")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("postAccount")
    public Result postAccount(@Valid @RequestBody AccountVo accountVo) {
        accountVo.setPassword(passwordEncoder.encode(accountVo.getPassword()));
        Account account = ToEntity.Account(accountVo);
        try {
            accountService.save(account);
        } catch (DuplicateKeyException e) {
            return Result.error(HttpStatus.MOVED_PERM, account.getUsername() + "用户已存在");
        }
        ;

        return Result.success();
    }

    @PostMapping("PostAccountByFile")
    public Result PostAccountByFile(@RequestParam("file") MultipartFile file, @RequestParam("defaultPassword") String defaultPassword, @RequestParam("class_information_id") int classTableId) throws XlsxException {

        return accountService.createAccountByFile(file, defaultPassword, classTableId);
    }

    @PutMapping("putAccount")
    public Result putAccount(@Valid @RequestBody AccountVo accountVo) {
        accountVo.setPassword(passwordEncoder.encode(accountVo.getPassword()));
        Account account = ToEntity.Account(accountVo);
        //让token失效
        redisTemplate.delete("account:" + account.getUsername());
        redisTemplate.delete("accountUsername:" + account.getUsername());
        Boolean result =accountService.updateById(account);
        if (result == true) {
            return Result.success();
        } else {
            return Result.error(HttpStatus.MOVED_PERM, accountVo.getUsername()+"账户不存在");
        }
    }

    @DeleteMapping("deleteAccount")
    public Result deleteAccount(@RequestParam("username") String username) {
        //让token失效
        redisTemplate.delete("account:" + username);
        redisTemplate.delete("accountUsername:" + username);
        Map map = new HashMap();
        map.put("username", username);

        boolean result = accountService.removeByMap(map);
        if (result == true) {
            return Result.success();
        } else {
            return Result.error(HttpStatus.MOVED_PERM, username+"账户不存在");
        }
    }
}

