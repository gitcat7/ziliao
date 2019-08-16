package pojo;

import java.io.Serializable;

/**
 * @author yk
 * @date 2019/8/8 - 17:31
 */
public class StoreHouse implements Serializable {
    private Integer bookid;
    private Integer book_count;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getBook_count() {
        return book_count;
    }

    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }

    @Override
    public String toString() {
        return "StoreHouse{" +
                "bookid=" + bookid +
                ", book_count=" + book_count +
                '}';
    }
}
