package graduation.project.util;

import graduation.project.pojo.entity.Account;
import graduation.project.pojo.vo.AccountVo;
import org.springframework.stereotype.Component;

/**
 * @author 邝明山
 * on 2020/10/29 17:55
 */
public class ToEntity {

    public static Account Account(AccountVo accountVo){
        return new Account(accountVo.getId(),accountVo.getUsername(),accountVo.getPassword(),accountVo.getPhone(),accountVo.getRole());
    }
}
