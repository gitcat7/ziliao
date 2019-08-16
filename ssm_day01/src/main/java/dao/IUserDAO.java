package dao;

import org.apache.ibatis.annotations.Param;
import pojo.T_User;

/**
 * @author yk
 * @date 2019/8/8 - 14:20
 */
public interface IUserDAO {

    T_User islogin(@Param("loginname") String loginname, @Param("loginpwd") String loginpwd);
}
