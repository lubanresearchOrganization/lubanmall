package com.lubanresearch.lubanmall.cart.infrastructure.remote;


import com.lubanmall.orderserviceapi.bean.CreateDealDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hilbertcao on 2018/2/11.
 */
@FeignClient(name = "orderservice")
public interface OrderService {
    @RequestMapping(value = "/v/0.1/deals/", method = RequestMethod.POST)
    boolean createDeal(CreateDealDTO createDealDTO);
}

