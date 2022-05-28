package top.dhbxs.jinsen.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dhbxs.jinsen.admin.entity.WorkOrderAndWildBillEntity;
import top.dhbxs.jinsen.admin.service.IWildOrderService;
import top.dhbxs.jinsen.admin.util.JsonResult;

import java.util.List;

/**
 * 野账报表相关控制层类
 */
@RestController // 组合注解， 相当于@Controller + @ResponseBody
@RequestMapping("/wild-order")
public class WildOrderController extends BaseController{

    @Autowired
    private IWildOrderService iWildOrderService;

    @GetMapping("/getAll")
    public JsonResult<List<WorkOrderAndWildBillEntity>> getAllWildOrder() {
        List<WorkOrderAndWildBillEntity> allWorkOrder = iWildOrderService.getAllWorkOrder();
        return new JsonResult<List<WorkOrderAndWildBillEntity>>(OK, allWorkOrder);
    }

    @GetMapping("/page")
    public JsonResult<List<WorkOrderAndWildBillEntity>> getWildOrderByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<WorkOrderAndWildBillEntity> result = iWildOrderService.getWorkOrderByPage(pageNum, pageSize);
        return new JsonResult<List<WorkOrderAndWildBillEntity>>(OK, result);
    }

    @PostMapping("/update")
    public JsonResult<Void> updateWildOrderAndWorkOrder(@RequestBody WorkOrderAndWildBillEntity workOrderAndWildBill){
        iWildOrderService.updateWorkOrderAndWildBill(workOrderAndWildBill);
        return new JsonResult<>(OK);
    }

    @PostMapping("/delete")
    public JsonResult<Void> deleteWildOrderAndWorkOrder(@RequestBody WorkOrderAndWildBillEntity workOrderAndWildBill) {
        iWildOrderService.deleteWorkOrderAndWildBill(workOrderAndWildBill);
        return new JsonResult<>(OK);
    }

    @PostMapping("/add")
    public JsonResult<Void> addWildOrderAndWorkOrder(@RequestBody WorkOrderAndWildBillEntity workOrderAndWildBill) {
        iWildOrderService.addWorkOrderAndWildBill(workOrderAndWildBill);
        return new JsonResult<>(OK);
    }

    @GetMapping("/search")
    public JsonResult<List<WorkOrderAndWildBillEntity>> searchWildOrderAndWorkOrder(@RequestParam String number) {
        List<WorkOrderAndWildBillEntity> workOrderAndWildBill = iWildOrderService.getWorkOrderAndWildBillByNumber(number, 0, 100);
        return new JsonResult<>(OK, workOrderAndWildBill);
    }
}
