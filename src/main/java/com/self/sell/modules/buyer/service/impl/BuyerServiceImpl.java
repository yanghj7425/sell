package com.self.sell.modules.buyer.service.impl;

import com.self.sell.common.enums.ResultEnum;
import com.self.sell.common.exception.SellException;
import com.self.sell.modules.buyer.service.BuyerService;
import com.self.sell.modules.order.pojo.dto.OrderDto;
import com.self.sell.modules.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto queryOrderOne(long orderId, String openId) {

        return checkOrderOwner(orderId, openId);
    }


    @Override
    public void cancelOrder(long orderId, String openId) {
        OrderDto orderDto = checkOrderOwner(orderId, openId);
        if (orderDto == null) {
            log.error("【 取消订单 】 该订单不存在, orderId = {}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        orderService.cancel(orderDto);
    }


    private OrderDto checkOrderOwner(long orderId, String openId) {
        OrderDto orderDto = orderService.queryOne(orderId);
        if (orderDto == null) {
            return null;
        }

        if (!orderDto.getBuyerOpenid().equals(openId)) {
            log.error("【 查询订单 】 订单查询错误, 该订单不属于当前用户 openId ={}", openId);
            throw new SellException(ResultEnum.ORDER_OWNER__ERROR);
        }

        return orderDto;
    }

}
