package service;

import pojo.T_Account;

import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @date 2019/8/11 - 16:45
 */
public interface IAccountService {
    /**
     * 根据用户查看所有账户
     * @param uid
     * @return
     */
     List<T_Account> findAccountByUserid(Integer uid);

    /**
     * 根据账户id查看余额
     * @param aid
     * @return
     */
     Double getBalanceByAccid(Integer aid);

    /**
     * 根据用户选择的账户扣款书的单价
     * @param map
     * @return
     */
     Boolean delMoney(Map<String,Object> map);
}
