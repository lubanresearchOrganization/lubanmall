package com.lubanresearch.lubanmall.orderservice.infrastructure.remote;

import com.lubanresearch.lubanmall.orderservice.domain.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hilbertcao on 2018/1/4.
 */
@FeignClient(name = "merchantservice")
public interface MerchantService {

    @RequestMapping(value = "/v/0.1/products/{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") Long id);
}
