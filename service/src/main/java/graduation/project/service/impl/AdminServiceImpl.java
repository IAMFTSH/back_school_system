package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.AdminMapper;
import graduation.project.pojo.entity.Admin;
import graduation.project.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
