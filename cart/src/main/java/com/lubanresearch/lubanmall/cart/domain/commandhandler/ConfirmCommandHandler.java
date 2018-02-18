package com.lubanresearch.lubanmall.cart.domain.commandhandler;

import com.lubanmall.orderserviceapi.bean.CreateDealDTO;
import com.lubanmall.orderserviceapi.bean.OrderItemDTO;
import com.lubanresearch.lubanmall.cart.domain.command.ConfirmCommand;
import com.lubanresearch.lubanmall.cart.infrastructure.persistence.db.entity.CartItemEntity;
import com.lubanresearch.lubanmall.cart.infrastructure.persistence.db.mapper.CartItemEntityMapper;
import com.lubanresearch.lubanmall.cart.infrastructure.persistence.db.query.condition.CartItemEntityQueryCondition;
import com.lubanresearch.lubanmall.cart.infrastructure.remote.OrderService;
import com.lubanresearch.lubanmall.common.exception.ServiceException;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hilbertcao on 2018/2/11.
 */
public class ConfirmCommandHandler {

    @Autowired
    private CartItemEntityMapper cartItemEntityMapper;
    @Autowired
    private OrderService orderService;

    @CommandHandler
    public void handle(ConfirmCommand command)throws ServiceException {

        CartItemEntityQueryCondition queryCondition = new CartItemEntityQueryCondition();
        queryCondition.createCriteria().andIdIn(command.getProductIds()).andCustomerIdEqualTo(command.getCustomerId());
        List<CartItemEntity> cartItemEntityList = cartItemEntityMapper.selectByExample(queryCondition);

        CreateDealDTO createDealDTO = new CreateDealDTO();
        createDealDTO.setCustomerId(command.getCustomerId());

        createDealDTO.setItems(cartItemEntityList.stream().map(
                cartItemEntity -> {
                    OrderItemDTO orderItemDTO = new OrderItemDTO();
                    orderItemDTO.setProductId(cartItemEntity.getProductId());
                    orderItemDTO.setProductNum((cartItemEntity.getProductNum()));
                    return  orderItemDTO;
                }
        ).collect(Collectors.toList()));
        orderService.createDeal(createDealDTO);

        cartItemEntityMapper.deleteByExample(queryCondition);

    }
}