package graduation.project.util;

import graduation.project.pojo.entity.Account;
import graduation.project.pojo.vo.AccountVo;

/**
 * @author 邝明山
 * on 2020/10/29 17:55
 */
public class ToVo {

    public static AccountVo Account(Account account){
        return new AccountVo(account.getId(),account.getUsername(),account.getPassword(),account.getPhone(),account.getRole());
    }
}
