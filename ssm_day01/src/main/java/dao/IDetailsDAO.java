package dao;

import pojo.Details;

/**
 * @author yk
 * @date 2019/8/14 - 13:56
 */
public interface IDetailsDAO {

    /**
     * 添加订单详情数据
     * @param details
     * @return
     */
    boolean addDetails(Details details);

    /**
     * 根据订单编号,查看详情
     * @param detId
     * @return
     */
    Details findDetailsById(Integer detId);
}
