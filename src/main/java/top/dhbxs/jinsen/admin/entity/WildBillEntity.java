package top.dhbxs.jinsen.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Objects;

/**
 * 野帐表实体类
 */
@TableName("wild_bill")
public class WildBillEntity {

    // 野账id
    @TableId(value = "w_id", type = IdType.AUTO)
    private Integer wId;

    // 工单号
    @TableField(value = "number")
    private String number;

    // 木材种类
    @TableField(value = "wood_type")
    private String woodType;


    // 检尺直径
    @TableField(value = "diameter")
    private double diameter;

    // 根数
    @TableField(value = "amount")
    private Integer amount;

    // 材积
    @TableField(value = "acreage")
    private double acreage;

    // 检尺长
    @TableField(value = "length")
    private double length;

    public WildBillEntity() {
    }

    public WildBillEntity(Integer wId, String number, String woodType, double diameter, Integer amount, double acreage, double length) {
        this.wId = wId;
        this.number = number;
        this.woodType = woodType;
        this.diameter = diameter;
        this.amount = amount;
        this.acreage = acreage;
        this.length = length;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildBillEntity that = (WildBillEntity) o;
        return Double.compare(that.diameter, diameter) == 0 && Double.compare(that.acreage, acreage) == 0 && Double.compare(that.length, length) == 0 && Objects.equals(wId, that.wId) && Objects.equals(number, that.number) && Objects.equals(woodType, that.woodType) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wId, number, woodType, diameter, amount, acreage, length);
    }

    @Override
    public String toString() {
        return "WildBillEntity{" +
                "wId=" + wId +
                ", number='" + number + '\'' +
                ", woodType='" + woodType + '\'' +
                ", diameter=" + diameter +
                ", amount=" + amount +
                ", acreage=" + acreage +
                ", length=" + length +
                '}';
    }
}
