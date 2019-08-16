package pojo;

import java.io.Serializable;

/**
 * @author yk
 * @date 2019/8/10 - 17:56
 */
public class T_Account implements Serializable {
    private Integer accid;
    private String accname;
    private Double balance;
    private Integer userid;

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
