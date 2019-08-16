package pojo;

import java.io.Serializable;

/**
 * @author yk
 * @date 2019/8/14 - 10:58
 */
public class Order implements Serializable {
    private Integer orderId;
    private String bookName;
    private Integer userId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
