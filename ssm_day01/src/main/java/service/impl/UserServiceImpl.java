package service.impl;

import dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.T_User;
import service.IUserService;

/**
 * @author yk
 * @date 2019/8/9 - 17:09
 */
@Service
public class UserServiceImpl implements IUserService {

    private final IUserDAO userDAO;

    @Autowired
    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public T_User islogin(String loginname, String loginpwd) {
        return userDAO.islogin(loginname,loginpwd);
    }
}
