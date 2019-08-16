package service;

import org.apache.ibatis.annotations.Param;
import pojo.T_User;

/**
 * @author yk
 * @date 2019/8/9 - 17:04
 */
public interface IUserService {

    /**
     * 登录
     * @param loginname
     * @param loginpwd
     * @return
     */
    T_User islogin(@Param("loginname") String loginname, @Param("loginpwd") String loginpwd);
}
