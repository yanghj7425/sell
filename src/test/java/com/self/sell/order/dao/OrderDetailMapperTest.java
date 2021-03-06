package com.self.sell.order.dao;

import com.self.sell.config.MybatisConfig;
import com.self.sell.modules.order.dao.OrderDetailMapper;
import com.self.sell.modules.order.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MybatisConfig.class)
public class OrderDetailMapperTest {

    @Resource
    private OrderDetailMapper orderDetailMapper;


    @Test
    public void insertTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId((long) 1);
        orderDetail.setOrderId((long) 1);

        orderDetail.setProductId((long) 1);
//        orderDetail.setProductName("asdf");
//        orderDetail.setProductIcon("888");
//        orderDetail.setProductPrice(new BigDecimal(12));
//        orderDetail.setProductQuantity(1123);
//
//        int insert = orderDetailMapper.insert(orderDetail);
//        Assert.notNull(
//                insert, ""
//        );

        OrderDetail orderDetail1 = orderDetailMapper.selectByPrimaryKey(1);

        System.out.println(orderDetail);


    }


}