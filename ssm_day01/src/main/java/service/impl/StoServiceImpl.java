package service.impl;

import dao.IStoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.StoreHouse;
import service.IStoService;

import java.util.List;

/**
 * @author yk
 * @date 2019/8/9 - 17:08
 */
@Service
public class StoServiceImpl implements IStoService {

    private final IStoDAO stoDAO;

    @Autowired
    public StoServiceImpl(IStoDAO stoDAO) {
        this.stoDAO = stoDAO;
    }

    @Override
    public List<StoreHouse> getAllSto() {
        return stoDAO.getAllSto();
    }

    @Override
    public boolean addCount(StoreHouse storeHouse) {
        return stoDAO.addCount(storeHouse);
    }

    @Override
    public boolean updateBookSto(StoreHouse storeHouse) {
        return stoDAO.updateBookSto(storeHouse);
    }

    @Override
    public boolean delSto(Integer bookid) {
        return stoDAO.delSto(bookid);
    }


}
