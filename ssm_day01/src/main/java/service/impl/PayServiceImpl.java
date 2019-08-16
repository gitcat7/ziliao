package service.impl;

import dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Book;
import pojo.Details;
import service.IPayService;
import utils.BalanceLessException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yk
 * @date 2019/8/13 - 11:59
 */
@Service
public class PayServiceImpl implements IPayService {

    private final IAccountDAO accountDAO;
    private final IStoDAO stoDAO;
    private final IBookDAO bookDAO;
    private final IDetailsDAO detailsDAO;

    @Autowired
    public PayServiceImpl(IAccountDAO accountDAO,IStoDAO stoDAO,IBookDAO bookDAO,IDetailsDAO detailsDAO) {
        this.accountDAO = accountDAO;
        this.stoDAO = stoDAO;
        this.bookDAO = bookDAO;
        this.detailsDAO = detailsDAO;
    }

    //注解配置事务
    //readOnly默认为false
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = BalanceLessException.class)
    @Override
    public boolean pay(Integer bookid, Integer accid,Integer detailsId) throws BalanceLessException {
        //获取订单详情
        Details details = detailsDAO.findDetailsById(detailsId);
        //查询书籍信息
        Book book = bookDAO.findBookById(bookid);
//        不会显示库存小于0的书籍
//        StoreHouse storeHouse = new StoreHouse();
//        if(book.getStoreHouse().getBook_count()<=0){
//            throw new StoLessException("库存不够");
//        }
        double money = accountDAO.getBalanceByAccid(accid)-book.getBook_price();
        if(money<0){
            throw new BalanceLessException("余额不足");
        }
        //减少库存
        boolean flag_sto = stoDAO.delSto(bookid);
        //检查事务是否成功
        //int i = 1/0;
        //扣钱
        Map<String,Object> map = new HashMap<>();
        map.put("balance",book.getBook_price());
        map.put("accid",accid);
        boolean flag_acc = accountDAO.delMoney(map);
        //修改订单详情的状态,改为1;表示已付款
        details.setOrderStatus(1);
        return flag_acc&&flag_sto;
    }
}
