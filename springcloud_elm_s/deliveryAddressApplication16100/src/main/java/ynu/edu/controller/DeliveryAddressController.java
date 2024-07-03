package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.domin.DeliveryAddress;
import ynu.edu.service.IDeliveryAddressService;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
@CrossOrigin(allowedHeaders = {"*"})
@RefreshScope

public class DeliveryAddressController {
    @Resource
    private IDeliveryAddressService daService;
    @GetMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId) throws Exception{
        return daService.listDeliveryAddressByUserId(userId);
    }
    @GetMapping("/getOneAddressByUserId")
    public DeliveryAddress getOneAddressByUserId(@RequestParam("userId") String userId) throws Exception{
        return daService.getOneAddressByUserId(userId);
    }
    @GetMapping("/getDeliveryAddressById")
    public DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId) throws Exception{
        return daService.getDeliveryAddressById(daId);
    }
    @PostMapping("/saveDeliveryAddress")
    public int saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) throws Exception{
        return daService.saveDeliveryAddress(deliveryAddress);
    }
    @PostMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) throws Exception{
        System.out.println(deliveryAddress.toString());

        return daService.updateDeliveryAddress(deliveryAddress);
    }
    @PostMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(@RequestParam("daId") Integer daId) throws Exception{
        return daService.removeDeliveryAddress(daId);

    }
}
