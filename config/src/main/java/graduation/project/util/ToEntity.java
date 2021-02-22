package graduation.project.util;

import graduation.project.pojo.entity.Account;
import graduation.project.pojo.entity.BackSchoolInformation;
import graduation.project.pojo.entity.Student;
import graduation.project.pojo.vo.AccountVo;
import graduation.project.pojo.vo.BackSchoolInformationVO;
import graduation.project.pojo.vo.StudentVo;
import org.springframework.stereotype.Component;

/**
 * @author 邝明山
 * on 2020/10/29 17:55
 */
public class ToEntity {

    public static Account account(AccountVo accountVo){
        return new Account(accountVo.getId(),accountVo.getUsername(),accountVo.getPassword(),accountVo.getPhone(),accountVo.getRole());
    }
    public static BackSchoolInformation backSchoolInformation(BackSchoolInformationVO b){
        return new BackSchoolInformation(b.getBackSchoolInformationId(),b.getUsername(),b.getStatisticsVersionId(),
                b.getAreaCode(),b.getAddress(),b.getBackTime(),b.getHealthyState(),b.getTemperature(),b.getIsContact(),b.getIsLeave(),b.getLeaveReason(),b.getIsBackSchool(),b.getState());
    }
    public static Student student(StudentVo s){
        return new Student(s.getStudentId(),s.getUsername(),s.getStudentName(),s.getNativePlace(),s.getClassTableId(),s.getDormId(),s.getParentsPhone());
    }
}
