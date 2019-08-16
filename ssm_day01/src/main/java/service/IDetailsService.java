package service;

import pojo.Details;

/**
 * @author yk
 * @date 2019/8/14 - 14:18
 */
public interface IDetailsService {

    /**
     * 添加订单详情数据
     * @param details
     * @return
     */
    boolean addDetails(Details details);

    /**
     * 根据订单详情编号,查看详情
     * @param detId
     * @return
     */
    Details findDetailsById(Integer detId);
}
