package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Order;

import java.util.List;

/**
 * @author yk
 * @date 2019/8/14 - 11:01
 */
public interface IOrderDAO {

    /**
     * 添加订单
     * @param order
     * @return
     */
    boolean addOrder(Order order);

    /**
     * 获取订单
     * @param orderId
     * @return
     */
    Order getOrderById(Integer orderId);

    /**
     * 根据用户编号查看所有订单+分页显示
     * @return
     */
    List<Order> getAllOrder(@Param("userId") Integer userid,@Param("cp") Integer currentPage,@Param("ps") Integer pageSize);
}
