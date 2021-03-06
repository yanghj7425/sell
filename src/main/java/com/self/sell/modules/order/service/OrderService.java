package com.self.sell.modules.order.service;

import com.github.pagehelper.PageInfo;
import com.self.sell.common.pojo.bo.PageParam;
import com.self.sell.common.service.BaseService;
import com.self.sell.modules.order.entity.OrderMaster;
import com.self.sell.modules.order.pojo.dto.OrderDto;

public interface OrderService extends BaseService<OrderMaster> {


    /**
     * @param orderDto
     * @return OrderDto
     * <pre>
     *     创建订单
     * </pre>
     */
    OrderDto create(OrderDto orderDto);


    /**
     * @param orderDto
     * @return OrderDto
     * <pre>
     *     支付订单
     * </pre>
     */
    OrderDto paid(OrderDto orderDto);

    /**
     * @param orderDto
     * @return OrderDto
     * <pre>
     *     取消订单
     * </pre>
     */
    OrderDto cancel(OrderDto orderDto);


    /**
     * @param orderDto
     * @return OrderDto
     * <pre>
     *     完结订单
     * </pre>
     */
    OrderDto finish(OrderDto orderDto);


    /**
     * @param orderId
     * @return OrderDto
     * <pre>
     *     查询单个订单
     * </pre>
     */
    OrderDto queryOne(long orderId);


    /**
     * @param pageParam 分页对象
     * @param openId    微信 openId
     * @return PageInfo
     * <pre>
     *     查询订单列表(个人)
     * </pre>
     */
    PageInfo<OrderDto> queryOrderList(String openId, PageParam pageParam);


    /**
     * @param pageParam 分页对象
     * @param openId    微信 openId
     * @return PageInfo
     * <pre>
     *     查询订单列表(所有人)
     * </pre>
     */
    PageInfo<OrderDto> queryOrderList(PageParam pageParam);

}
