package service;

import utils.BalanceLessException;
import utils.StoLessException;

/**
 * @author yk
 * @date 2019/8/12 - 21:05
 */
public interface IPayService {

    /**
     * 按照用户选择的账户扣款,减去对应的书籍
     * @param bookid
     * @param accid
     * @return
     */
    boolean pay(Integer bookid,Integer accid,Integer detailsId) throws StoLessException, BalanceLessException;
}
