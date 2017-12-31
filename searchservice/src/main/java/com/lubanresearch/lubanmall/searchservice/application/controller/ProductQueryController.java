package com.lubanresearch.lubanmall.searchservice.application.controller;

import com.lubanresearch.lubanmall.common.bean.Pagination;
import com.lubanresearch.lubanmall.common.bean.Response;
import com.lubanresearch.lubanmall.searchservice.domain.Product;
import com.lubanresearch.lubanmall.searchservice.infrastructure.persistence.db.mapper.ProductMapper;
import com.lubanresearch.lubanmall.searchservice.infrastructure.persistence.db.query.condition.ProductQueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hilbertcao on 2017/12/16.
 */
@Controller
@RequestMapping("/v/0.1/search/products")
public class ProductQueryController {

    @Autowired
    private ProductMapper productMapper;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Response<Pagination<Product>> findProducts(
            @RequestParam("key") String  key,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {

        ProductQueryCondition condition = new ProductQueryCondition();
        condition.createCriteria().andIf(key != null&&!"".equals(key), new ProductQueryCondition.Criteria.ICriteriaAdd() {
            @Override
            public ProductQueryCondition.Criteria add(ProductQueryCondition.Criteria add) {
                return add.andNameLike(key);
            }
        });
        condition.orderBy("create_time desc");

        Pagination<Product> productPagination = new Pagination<>();
        productPagination.setItems(productMapper.selectByExample(condition));
        productPagination.setTotal((int) productMapper.countByExample(condition));
        productPagination.setPageCount((productPagination.getTotal() % size == 0) ? (productPagination.getTotal() / size) : (productPagination.getTotal() / size + 1));
        productPagination.setPageIndex(page);
        return new Response<>(0, "success", productPagination);
    }
}