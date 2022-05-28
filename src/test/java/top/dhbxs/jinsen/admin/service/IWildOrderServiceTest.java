package top.dhbxs.jinsen.admin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dhbxs.jinsen.admin.entity.WorkOrderAndWildBillEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IWildOrderServiceTest {

    @Autowired
    private IWildOrderService iWildOrderService;

    @Test
    void getAllWorkOrder() {
        List<WorkOrderAndWildBillEntity> allWorkOrder = iWildOrderService.getAllWorkOrder();
        for (WorkOrderAndWildBillEntity workOrderAndWildBill : allWorkOrder) {
            System.out.println(workOrderAndWildBill);
        }
    }

    @Test
    void findPage() {
        List<WorkOrderAndWildBillEntity> result = iWildOrderService.getWorkOrderByPage(1, 3);
        for (WorkOrderAndWildBillEntity workOrderAndWildBill : result) {
            System.out.println(workOrderAndWildBill);
        }
    }
}