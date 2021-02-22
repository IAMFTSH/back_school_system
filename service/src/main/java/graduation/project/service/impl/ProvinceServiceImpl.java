package graduation.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import graduation.project.mapper.ProvinceMapper;
import graduation.project.pojo.entity.Province;
import graduation.project.pojo.vo.ProvinceEasyVo;
import graduation.project.pojo.vo.ProvinceVo;
import graduation.project.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 省份设置 服务实现类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<ProvinceEasyVo> all() {
        return provinceMapper.all();
    }
}
