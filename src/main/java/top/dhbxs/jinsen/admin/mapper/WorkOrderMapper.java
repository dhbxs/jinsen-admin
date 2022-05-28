package top.dhbxs.jinsen.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.dhbxs.jinsen.admin.entity.WorkOrderEntity;

import java.util.List;

/**
 * 工单表持久层接口
 */
public interface WorkOrderMapper extends BaseMapper<WorkOrderEntity> {

    /**
     * 获取所有的野账数据明细
     * @return 野账数据List集合
     */
    List<WorkOrderEntity> getAllWorkOrderAndWildBill();

    /**
     * 通过工单号查询野账数据明细
     * @param number
     * @return
     */
    List<WorkOrderEntity> getWorkOrderAndWildBillByNumber(String number, Integer pageNum, Integer pageSize);

    /**
     * 分页查询野帐数据明细
     * @param pageNum 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查到的数据集合
     */
    List<WorkOrderEntity> findPage(Integer pageNum, Integer pageSize);

}
