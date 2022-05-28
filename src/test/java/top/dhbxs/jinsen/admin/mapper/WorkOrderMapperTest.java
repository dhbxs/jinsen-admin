package top.dhbxs.jinsen.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dhbxs.jinsen.admin.entity.WorkOrderEntity;

import java.util.List;
@SpringBootTest
class WorkOrderMapperTest {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Test
    public void getAllWorkOrderAndWildBill() {
        List<WorkOrderEntity> workOrderEntities = workOrderMapper.getAllWorkOrderAndWildBill();
        for (WorkOrderEntity workOrderEntity : workOrderEntities) {
            System.out.println(workOrderEntity);
        }
    }

    @Test
    public void getWorkOrderAndWildBillByNumber() {
//        WorkOrderEntity workOrderAndWildBill = workOrderMapper.getWorkOrderAndWildBillByNumber();

//        System.out.println(workOrderAndWildBill);
    }
}