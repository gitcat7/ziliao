package service;

import pojo.StoreHouse;

import java.util.List;

/**
 * @author yk
 * @date 2019/8/9 - 17:05
 */
public interface IStoService {

    /**
     * 获取所有书籍的库存
     */
    List<StoreHouse> getAllSto();

    /**
     * 添加书籍的库存
     */
    boolean addCount(StoreHouse storeHouse);

    /**
     * 添加书籍时,如果书籍存在就修改书籍库存
     * @param storeHouse
     * @return
     */
    boolean updateBookSto(StoreHouse storeHouse);

    /**
     * 根据书籍编号减少一本书库存
     * @param bookid
     * @return
     */
    boolean delSto(Integer bookid);
}
