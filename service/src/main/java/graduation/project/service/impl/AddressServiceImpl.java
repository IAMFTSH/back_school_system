package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.AddressMapper;
import graduation.project.pojo.entity.Address;
import graduation.project.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
