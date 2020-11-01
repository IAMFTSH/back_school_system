package graduation.project.register.service;


import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.common.result.Result;
import graduation.project.register.entity.Account;
import graduation.project.register.exception.XlsxException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-29
 */
public interface AccountService extends IService<Account>, UserDetailsService {
    /**
     * Security登录验证
     * @param s
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String s);
    public Account accountSelectOne(String username);
    public Result createAccountByFile(MultipartFile file, String defaultPassword, int classTableId) throws XlsxException;
}
