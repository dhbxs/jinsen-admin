package top.dhbxs.jinsen.admin.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 工单和野账结合实体类
 */
public class WorkOrderAndWildBillEntity {

    private Integer oId;

    private String number;

    private String plate;

    private Date createdTime;

    private Date modifiedTime;

    private Integer wId;

    // 木材种类
    private String woodType;

    // 检尺直径
    private double diameter;

    // 根数
    private Integer amount;

    // 材积
    private double acreage;

    // 检尺长
    private double length;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
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
        WorkOrderAndWildBillEntity that = (WorkOrderAndWildBillEntity) o;
        return Double.compare(that.diameter, diameter) == 0 && Double.compare(that.acreage, acreage) == 0 && Objects.equals(oId, that.oId) && Objects.equals(number, that.number) && Objects.equals(plate, that.plate) && Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(wId, that.wId) && Objects.equals(woodType, that.woodType) && Objects.equals(amount, that.amount) && Objects.equals(length, that.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, number, plate, createdTime, modifiedTime, wId, woodType, diameter, amount, acreage, length);
    }

    @Override
    public String toString() {
        return "WorkOrderAndWildBillEntity{" +
                "oId=" + oId +
                ", number='" + number + '\'' +
                ", plate='" + plate + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", wId=" + wId +
                ", woodType='" + woodType + '\'' +
                ", diameter=" + diameter +
                ", amount=" + amount +
                ", acreage=" + acreage +
                ", length=" + length +
                '}';
    }
}
