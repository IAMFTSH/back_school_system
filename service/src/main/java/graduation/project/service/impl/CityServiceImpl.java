package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.CityMapper;
import graduation.project.pojo.entity.City;
import graduation.project.service.CityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 城市设置 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}
