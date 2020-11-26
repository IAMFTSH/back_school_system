package graduation.project.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Account;
import graduation.project.common.exception.XlsxException;
import graduation.project.mapper.AccountMapper;
import graduation.project.service.AccountService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-10-29
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        Account account = accountMapper.selectOne(wrapper);
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),
                true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(Integer.toString(account.getRole()))
        );
    }

    @Override
    public Account accountSelectOne(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        Account account = accountMapper.selectOne(wrapper);
        return account;
    }

    @Override
    public Result createAccountByFile(MultipartFile file, String defaultPassword, int classTableId) throws XlsxException {
        // @RequestParam("file") MultipartFile file 是用来接收前端传递过来的文件
        // 1.创建输入流，不懂输入流操作。。。。
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取后缀
        String fileNewName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        Workbook wb = null;
        if ("xls".equals(fileNewName)) {
            //从XLS文件(excel2003)读取输入流中数据
            try {
                wb = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("xlsx".equals(fileNewName)) {
            try {
                //从XLSX文件(excel2007)读取输入流中数据
                wb = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //读取xlsx第一个sheet
        Sheet sheetAt = wb.getSheetAt(0);
        int count = 0;
        DecimalFormat df = new DecimalFormat("0");
        for (Row row : sheetAt) {
            count++;
            try {
                String username = null;
                if (row.getCell(0).getCellType().equals(CellType.STRING)) {
                    username = row.getCell(0).getStringCellValue();
                } else if (row.getCell(0).getCellType().equals(CellType.NUMERIC)) {
                    username = df.format(row.getCell(0).getNumericCellValue()) + "";
                } else {
                    throw new XlsxException("请上传格式正确的execl文件，第一类需要数字或字符串，第二列需要字符串,问题在第" + count + "行");
                }
                String name = row.getCell(1).getStringCellValue();
                System.out.println("username:" + username + "名字:" + name + "默认密码" + defaultPassword + "班级id" + classTableId);
            } catch (NullPointerException e) {
                //这个哪怕用第二种方法也是要捕捉这个异常的
                throw new XlsxException("请上传格式正确的execl文件，表格某列中存在空值,问题在第" + count + "行");
            } catch (IllegalStateException e) {
                throw new XlsxException("请上传格式正确的execl文件，表格类型错误,问题在第" + count + "行");
            } catch (XlsxException e) {
                throw e;
            } catch (Exception e) {
                throw new XlsxException("未知错误");
            }
        }
        return Result.success();
    }
}
