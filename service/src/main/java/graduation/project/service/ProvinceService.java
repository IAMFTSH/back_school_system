package graduation.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import graduation.project.pojo.entity.Province;
import graduation.project.pojo.vo.ProvinceEasyVo;
import graduation.project.pojo.vo.ProvinceVo;

import java.util.List;

/**
 * <p>
 * 省份设置 服务类
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
public interface ProvinceService extends IService<Province> {

    List<ProvinceEasyVo> all();
}
