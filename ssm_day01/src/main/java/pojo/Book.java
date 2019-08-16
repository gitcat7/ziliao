package pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yk
 * @date 2019/8/8 - 11:30
 */
public class Book implements Serializable {
    /**
     * 编号
     */
    private Integer bookid;
    /**
     * 书名
     */
    private String book_name;
    /**
     * 出版社
     */
    private String public_dept;
    /**
     * 单价
     */
    private Double book_price;
    /**
     * 出版日期
     */
    private Date public_date;
    /**
     * 作者
     */
    private String book_auth;
    /**
     * 图片路径
     */
    private String img_path;
    /**
     * 简介
     */
    private String summary;

    /**
     * 库存
     * @return
     */
    private StoreHouse storeHouse;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPublic_dept() {
        return public_dept;
    }

    public void setPublic_dept(String public_dept) {
        this.public_dept = public_dept;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
    }

    public String getBook_auth() {
        return book_auth;
    }

    public void setBook_auth(String book_auth) {
        this.book_auth = book_auth;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", book_name='" + book_name + '\'' +
                ", public_dept='" + public_dept + '\'' +
                ", book_price=" + book_price +
                ", public_date=" + public_date +
                ", book_auth='" + book_auth + '\'' +
                ", img_path='" + img_path + '\'' +
                ", summary='" + summary + '\'' +
                ", storeHouse=" + storeHouse +
                '}';
    }
}
