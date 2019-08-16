package dao;

import pojo.Book;

import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @date 2019/8/8 - 11:30
 */
public interface IBookDAO {

    /**
     * 分页查询所有书籍+模糊(根据书名)
     * @return
     */
    List<Book> getAllBook(Map<String,Object> map);

    /**
     * 获取数据总数
     */
    int getCount();

    /**
     * 通过名字查看书籍详情
     */
    Book bookInfo(String bookName);

    /**
     * 添加书籍
     * @param book
     * @return
     */
    boolean addBook(Book book);

    /**
     * 通过编号查看书籍
     * @param bookid
     * @return
     */
    Book findBookById(Integer bookid);

}
