package service;

import pojo.Details;
import pojo.Order;

import java.util.List;

/**
 * @author yk
 * @date 2019/8/14 - 11:21
 */
public interface IOrderService {

    /**
     * 添加订单
     * @param order
     * @return
     */
    public boolean addOrder(Order order);

    /**
     * 获取订单
     * @param orderId
     * @return
     */
    Order getOrderById(Integer orderId);

    /**
     * 查看所有订单+分页
     * @return
     */
    List<Order> getAllOrder(Integer userid,Integer currentPage,Integer pageSize);

    /**
     * 同时进行添加订单和订单详情
     * @param order
     * @param details
     * @return
     */
    boolean addOrderAndDetails(Order order, Details details);

}
