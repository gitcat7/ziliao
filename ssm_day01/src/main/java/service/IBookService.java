package service;

import pojo.Book;

import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @date 2019/8/9 - 17:05
 */
public interface IBookService {

    /**
     * 分页查询所有书籍+模糊(根据书名)
     * @return
     */
    public List<Book> getAllBook(Map<String,Object> map);

    /**
     * 获取数据总数
     */
    public int getCount();

    /**
     * 查看书籍详情
     */
    public Book bookInfo(String bookName);

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public boolean addBook(Book book);

    /**
     * 通过编号查看书籍
     * @param bookid
     * @return
     */
    public Book findBookById(Integer bookid);

}
