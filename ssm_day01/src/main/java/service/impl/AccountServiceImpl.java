package service.impl;

import dao.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.T_Account;
import service.IAccountService;

import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @data 2019/8/11 - 16:46
 */
@Service
public class AccountServiceImpl implements IAccountService {

    private final IAccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<T_Account> findAccountByUserid(Integer uid) {
        return accountDAO.findAccountByUserid(uid);
    }

    @Override
    public Double getBalanceByAccid(Integer aid) {
        return accountDAO.getBalanceByAccid(aid);
    }

    @Override
    public Boolean delMoney(Map map) {
        return accountDAO.delMoney(map);
    }

}
