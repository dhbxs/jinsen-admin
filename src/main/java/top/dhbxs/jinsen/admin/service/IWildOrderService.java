package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.entity.WorkOrderAndWildBillEntity;

import java.util.List;

/**
 * 野账表业务层接口
 */
public interface IWildOrderService {

    /**
     * 获取所有的野账详细数据
     * @return 返回查询到的数据集合
     */
    List<WorkOrderAndWildBillEntity> getAllWorkOrder();

    /**
     * 分页查询野账详细数据
     * @param pageNum 当前页码
     * @param pageSize 每页展示内容条数
     * @return 返回查询到的数据集合
     */
    List<WorkOrderAndWildBillEntity> getWorkOrderByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过工单号查询野账
     * @param number 工单号
     * @param pageNum 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询结果集合
     */
    List<WorkOrderAndWildBillEntity> getWorkOrderAndWildBillByNumber(String number, Integer pageNum, Integer pageSize);

    /**
     * 更新野账详细信息
     * @param workOrderAndWildBill 野账详细信息实体
     */
    void updateWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill);

    /**
     * 删除野账信息
     * @param workOrderAndWildBill 工单实体数据
     */
    void deleteWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill);

    /**
     * 添加野帐数据接口
     * @param workOrderAndWildBill 野帐数据实体
     */
    void addWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill);
}
