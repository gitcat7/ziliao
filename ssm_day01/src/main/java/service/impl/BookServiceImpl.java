package service.impl;

import dao.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import service.IBookService;

import java.util.List;
import java.util.Map;

/**
 * @author yk
 * @date 2019/8/9 - 17:07
 */
@Service
public class BookServiceImpl implements IBookService {

    private final IBookDAO bookDAO;

    @Autowired
    public BookServiceImpl(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBook(Map<String, Object> map) {
        return bookDAO.getAllBook(map);
    }

    @Override
    public int getCount() {
        return bookDAO.getCount();
    }

    @Override
    public Book bookInfo(String bookName) {
        return bookDAO.bookInfo(bookName);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    @Override
    public Book findBookById(Integer bookid) {
        return bookDAO.findBookById(bookid);
    }
}
