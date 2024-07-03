package ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ynu.edu.domin.DeliveryAddress;

import java.util.List;


@FeignClient("da-server")
public interface DaService {
    @GetMapping("/DeliveryAddressController/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId);

    @GetMapping("/DeliveryAddressController/getOneAddressByUserId")
    public DeliveryAddress getOneAddressByUserId(@RequestParam("userId") String userId) ;

    @GetMapping("/DeliveryAddressController/getDeliveryAddressById")
    public DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId) ;

    @PostMapping("/DeliveryAddressController/saveDeliveryAddress")
    public int saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) ;

    @PostMapping("/DeliveryAddressController/updateDeliveryAddress")
    public int updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress);

    @PostMapping("/DeliveryAddressController/removeDeliveryAddress")
    public int removeDeliveryAddress(@RequestParam("daId") Integer daId);
}
