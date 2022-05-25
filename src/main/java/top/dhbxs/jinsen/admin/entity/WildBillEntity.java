package top.dhbxs.jinsen.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
    private Integer diameter;

    // 根数
    @TableField(value = "amount")
    private Integer amount;

    // 材积
    @TableField(value = "acreage")
    private Integer acreage;

    // 检尺长
    @TableField(value = "length")
    private Integer length;

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

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WildBillEntity)) return false;

        WildBillEntity that = (WildBillEntity) o;

        if (getwId() != null ? !getwId().equals(that.getwId()) : that.getwId() != null) return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        if (getWoodType() != null ? !getWoodType().equals(that.getWoodType()) : that.getWoodType() != null)
            return false;
        if (getDiameter() != null ? !getDiameter().equals(that.getDiameter()) : that.getDiameter() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        if (getAcreage() != null ? !getAcreage().equals(that.getAcreage()) : that.getAcreage() != null) return false;
        return getLength() != null ? getLength().equals(that.getLength()) : that.getLength() == null;
    }

    @Override
    public int hashCode() {
        int result = getwId() != null ? getwId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getWoodType() != null ? getWoodType().hashCode() : 0);
        result = 31 * result + (getDiameter() != null ? getDiameter().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getAcreage() != null ? getAcreage().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        return result;
    }


}
