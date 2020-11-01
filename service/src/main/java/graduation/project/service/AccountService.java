package graduation.project.service;


import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Account;
import graduation.project.common.exception.XlsxException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 用于登录，获取一个用户信息
     * @param username
     * @return
     */
    public Account accountSelectOne(String username);

    /**
     * 批量生成班级成员账号
     * @param file
     * @param defaultPassword
     * @param classTableId
     * @return
     * @throws XlsxException
     */
    public Result createAccountByFile(MultipartFile file, String defaultPassword, int classTableId) throws XlsxException;
}
