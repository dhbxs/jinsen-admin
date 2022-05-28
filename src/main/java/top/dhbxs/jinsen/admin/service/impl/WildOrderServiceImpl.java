package top.dhbxs.jinsen.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dhbxs.jinsen.admin.entity.WildBillEntity;
import top.dhbxs.jinsen.admin.entity.WorkOrderAndWildBillEntity;
import top.dhbxs.jinsen.admin.entity.WorkOrderEntity;
import top.dhbxs.jinsen.admin.mapper.WildBillMapper;
import top.dhbxs.jinsen.admin.mapper.WorkOrderMapper;
import top.dhbxs.jinsen.admin.service.IWildOrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * 野账数据业务层实现类
 */
@Service
public class WildOrderServiceImpl implements IWildOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Autowired
    private WildBillMapper wildBillMapper;

    /**
     * 获取所有工单表详情
     * @return 返回List数据集
     */
    @Override
    public List<WorkOrderAndWildBillEntity> getAllWorkOrder() {
        List<WorkOrderEntity> allWorkOrderAndWildBill = workOrderMapper.getAllWorkOrderAndWildBill();

        List<WorkOrderAndWildBillEntity> workOrderAndWildBills = new ArrayList<>();


        for (WorkOrderEntity workOrder: allWorkOrderAndWildBill) {

            List<WildBillEntity> wildBillEntities = workOrder.getWildBillEntities();

            for (WildBillEntity wildBill : wildBillEntities) {
                WorkOrderAndWildBillEntity workOrderAndWildBill = new WorkOrderAndWildBillEntity();
                workOrderAndWildBill.setoId(workOrder.getoId());
                workOrderAndWildBill.setNumber(workOrder.getNumber());
                workOrderAndWildBill.setPlate(workOrder.getPlate());
                workOrderAndWildBill.setwId(wildBill.getwId());
                workOrderAndWildBill.setWoodType(wildBill.getWoodType());
                workOrderAndWildBill.setLength(wildBill.getLength());
                workOrderAndWildBill.setAmount(wildBill.getAmount());

                // 计算材积
                double acreage = (Math.PI * Math.pow((wildBill.getDiameter() / 100.0), 2) / 4.0) * wildBill.getAmount();

                workOrderAndWildBill.setAcreage(acreage);
                workOrderAndWildBill.setDiameter(wildBill.getDiameter());
                workOrderAndWildBills.add(workOrderAndWildBill);
            }
        }

        return workOrderAndWildBills;
    }

    /**
     * 分页查询数据的实现类
     * @param pageNum 当前页码
     * @param pageSize 每页展示内容条数
     * @return
     */
    @Override
    public List<WorkOrderAndWildBillEntity> getWorkOrderByPage(Integer pageNum, Integer pageSize) {

        pageNum = (pageNum - 1) * pageSize;
        List<WorkOrderEntity> result = workOrderMapper.findPage(pageNum, pageSize);

        List<WorkOrderAndWildBillEntity> workOrderAndWildBills = new ArrayList<>();


        for (WorkOrderEntity workOrder: result) {

            List<WildBillEntity> wildBillEntities = workOrder.getWildBillEntities();

            for (WildBillEntity wildBill : wildBillEntities) {
                WorkOrderAndWildBillEntity workOrderAndWildBill = new WorkOrderAndWildBillEntity();
                workOrderAndWildBill.setoId(workOrder.getoId());
                workOrderAndWildBill.setNumber(workOrder.getNumber());
                workOrderAndWildBill.setPlate(workOrder.getPlate());
                workOrderAndWildBill.setwId(wildBill.getwId());
                workOrderAndWildBill.setWoodType(wildBill.getWoodType());
                workOrderAndWildBill.setLength(wildBill.getLength());
                workOrderAndWildBill.setAmount(wildBill.getAmount());

                // 计算材积
                double acreage = (Math.PI * Math.pow((wildBill.getDiameter() / 100.0), 2) / 4.0) * wildBill.getAmount();

                workOrderAndWildBill.setAcreage(acreage);
                workOrderAndWildBill.setDiameter(wildBill.getDiameter());
                workOrderAndWildBills.add(workOrderAndWildBill);
            }
        }
        return workOrderAndWildBills;
    }

    /**
     * 更新野账详细信息
     * @param workOrderAndWildBill 野账详细信息实体
     */
    @Override
    public void updateWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill) {
        WorkOrderEntity workOrder = new WorkOrderEntity();
        WildBillEntity wildBill = new WildBillEntity();

        Integer oId = workOrderAndWildBill.getoId();
        Integer wId = workOrderAndWildBill.getwId();
        workOrder.setoId(oId);
        workOrder.setNumber(workOrderAndWildBill.getNumber());
        wildBill.setAcreage(workOrderAndWildBill.getAcreage());
        wildBill.setAmount(workOrderAndWildBill.getAmount());
        wildBill.setDiameter(workOrderAndWildBill.getDiameter());
        wildBill.setLength(workOrderAndWildBill.getLength());
        wildBill.setWoodType(workOrderAndWildBill.getWoodType());
        wildBill.setwId(wId);

        workOrderMapper.updateById(workOrder);
        wildBillMapper.updateById(wildBill);
    }

    /**
     * 删除野账数据
     * @param workOrderAndWildBill 工单实体数据
     */
    @Override
    public void deleteWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill) {
        Integer wId = workOrderAndWildBill.getwId();
        workOrderMapper.deleteById(wId);
    }

    /**
     * 新增野帐数据
     * @param workOrderAndWildBill 野帐数据实体
     */
    @Override
    public void addWorkOrderAndWildBill(WorkOrderAndWildBillEntity workOrderAndWildBill) {
        WorkOrderEntity workOrder = new WorkOrderEntity();
        WildBillEntity wildBill = new WildBillEntity();

        workOrder.setoId(workOrderAndWildBill.getoId());
        workOrder.setNumber(workOrderAndWildBill.getNumber());
        wildBill.setNumber(workOrderAndWildBill.getNumber());
        wildBill.setAcreage(workOrderAndWildBill.getAcreage());
        wildBill.setAmount(workOrderAndWildBill.getAmount());
        wildBill.setDiameter(workOrderAndWildBill.getDiameter());
        wildBill.setLength(workOrderAndWildBill.getLength());
        wildBill.setWoodType(workOrderAndWildBill.getWoodType());
        wildBill.setwId(workOrderAndWildBill.getwId());

        workOrderMapper.insert(workOrder);
        wildBillMapper.insert(wildBill);

    }

    @Override
    public List<WorkOrderAndWildBillEntity> getWorkOrderAndWildBillByNumber(String number, Integer pageNum, Integer pageSize) {
        List<WorkOrderEntity> allWorkOrderAndWildBill = workOrderMapper.getWorkOrderAndWildBillByNumber(number, pageNum, pageSize);

        List<WorkOrderAndWildBillEntity> workOrderAndWildBills = new ArrayList<>();


        for (WorkOrderEntity workOrder: allWorkOrderAndWildBill) {

            List<WildBillEntity> wildBillEntities = workOrder.getWildBillEntities();

            for (WildBillEntity wildBill : wildBillEntities) {
                WorkOrderAndWildBillEntity workOrderAndWildBill = new WorkOrderAndWildBillEntity();
                workOrderAndWildBill.setoId(workOrder.getoId());
                workOrderAndWildBill.setNumber(workOrder.getNumber());
                workOrderAndWildBill.setPlate(workOrder.getPlate());
                workOrderAndWildBill.setwId(wildBill.getwId());
                workOrderAndWildBill.setWoodType(wildBill.getWoodType());
                workOrderAndWildBill.setLength(wildBill.getLength());
                workOrderAndWildBill.setAmount(wildBill.getAmount());

                // 计算材积
                double acreage = (Math.PI * Math.pow((wildBill.getDiameter() / 100.0), 2) / 4.0) * wildBill.getAmount();

                workOrderAndWildBill.setAcreage(acreage);
                workOrderAndWildBill.setDiameter(wildBill.getDiameter());
                workOrderAndWildBills.add(workOrderAndWildBill);
            }
        }
        return workOrderAndWildBills;
    }
}
