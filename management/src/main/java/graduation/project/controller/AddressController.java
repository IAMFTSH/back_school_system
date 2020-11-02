package graduation.project.controller;


import graduation.project.common.result.Result;
import graduation.project.pojo.entity.Address;
import graduation.project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地址 前端控制器
 * </p>
 *
 * @author 邝明山
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping
    public Result getAddress(int id){
        Address address = addressService.getById(id);
        return Result.success(address);
    }
    @PostMapping
    public void postAddress(@RequestBody Address address){
        boolean result = addressService.save(address);
    }
    @PutMapping
    public void putAddress(@RequestBody Address address){
        boolean result = addressService.save(address);
    }
    @DeleteMapping
    public void deleteAddress(int id){
        boolean result = addressService.removeById(id);
    }
}

