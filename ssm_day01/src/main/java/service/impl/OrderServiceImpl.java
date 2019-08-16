package service.impl;

import dao.IDetailsDAO;
import dao.IOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Details;
import pojo.Order;
import service.IOrderService;

import java.util.List;

/**
 * @author yk
 * @date 2019/8/14 - 11:23
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderDAO orderDAO;
    private IDetailsDAO detailsDAO;

    @Autowired
    public OrderServiceImpl(IOrderDAO orderDAO,IDetailsDAO detailsDAO) {
        this.orderDAO = orderDAO;
        this.detailsDAO = detailsDAO;
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDAO.addOrder(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDAO.getOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrder(Integer userid,Integer currentPage,Integer pageSize) {
        return orderDAO.getAllOrder(userid,currentPage,pageSize);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public boolean addOrderAndDetails(Order order, Details details){
        boolean flag_ord = addOrder(order);
        boolean flag_det = detailsDAO.addDetails(details);
        return flag_ord&&flag_det;
    }
}
