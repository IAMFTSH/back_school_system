package graduation.project.register.util;

import graduation.project.register.entity.Account;
import graduation.project.register.vo.AccountVo;
import org.springframework.stereotype.Component;

/**
 * @author 邝明山
 * on 2020/10/29 17:55
 */
public class ToEntity {

    public static Account Account(AccountVo accountVo){
        return new Account(accountVo.getId(),accountVo.getUsername(),accountVo.getPassword(),accountVo.getPhone(),accountVo.getAdministrator());
    }
}
