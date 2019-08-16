package service.impl;

import dao.IDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Details;
import service.IDetailsService;

/**
 * @author yk
 * @date 2019/8/14 - 14:19
 */
@Service
public class DetailsServiceImpl implements IDetailsService {

    private final IDetailsDAO detailsDAO;

    @Autowired
    public DetailsServiceImpl(IDetailsDAO detailsDAO) {
        this.detailsDAO = detailsDAO;
    }

    @Override
    public boolean addDetails(Details details) {
        return detailsDAO.addDetails(details);
    }

    @Override
    public Details findDetailsById(Integer detId) {
        return detailsDAO.findDetailsById(detId);
    }
}
