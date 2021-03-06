package com.self.sell.modules.order.service.impl;

import com.self.sell.common.service.impl.AbstractBaseService;
import com.self.sell.modules.order.entity.OrderDetail;
import com.self.sell.modules.order.service.OrderDetailService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderDetailServiceImpl extends AbstractBaseService<OrderDetail, Mapper<OrderDetail>> implements OrderDetailService {
    @Override
    public List<OrderDetail> queryOrderByBuyerOrderId(long orderId) {
        Example example = createExample();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
        return queryListByExample(example);
    }


    private Example createExample() {
        return new Example(OrderDetail.class);
    }
}
