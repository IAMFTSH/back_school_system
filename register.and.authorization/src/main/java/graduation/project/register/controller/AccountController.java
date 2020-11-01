package graduation.project.register.controller;


import graduation.project.common.result.Result;
import graduation.project.common.status.HttpStatus;
import graduation.project.register.component.JWTUtils;
import graduation.project.register.entity.Account;
import graduation.project.register.exception.XlsxException;
import graduation.project.register.service.AccountService;
import graduation.project.register.util.ToEntity;
import graduation.project.register.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *  前端控制器
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
    @PostMapping("account")
    public Result account(@Valid @RequestBody AccountVo accountVo){
        accountVo.setPassword(passwordEncoder.encode(accountVo.getPassword()));
        Account account=ToEntity.Account(accountVo);
        try {
            accountService.save(account);
        }catch (DuplicateKeyException e){
            return Result.error(HttpStatus.ERROR,account.getUsername()+"用户已存在");
        };

        return Result.success();
    }

    @PostMapping("accountByFile")
    public Result accountByFile(@RequestParam("file") MultipartFile file, @RequestParam("defaultPassword") String defaultPassword, @RequestParam("class_information_id") int classTableId) throws XlsxException {

        return accountService.createAccountByFile(file,defaultPassword,classTableId);
    }


}

