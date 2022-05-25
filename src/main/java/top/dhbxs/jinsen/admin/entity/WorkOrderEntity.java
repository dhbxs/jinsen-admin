package top.dhbxs.jinsen.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;

/**
 * 工单表实体类
 */
@TableName("work_order")
public class WorkOrderEntity {

    @TableId(value = "o_id", type = IdType.AUTO)
    private Integer oId;

    @TableField(value = "number")
    private String number;

    @TableField(value = "plate")
    private String plate;

    @TableField(value = "created_time")
    private Date createdTime;

    @TableField(value = "modified_time")
    private Date modifiedTime;

    @TableField(exist = false)
    private List<WildBillEntity> wildBillEntities;

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

    public List<WildBillEntity> getWildBillEntities() {
        return wildBillEntities;
    }

    public void setWildBillEntities(List<WildBillEntity> wildBillEntities) {
        this.wildBillEntities = wildBillEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkOrderEntity)) return false;

        WorkOrderEntity that = (WorkOrderEntity) o;

        if (getoId() != null ? !getoId().equals(that.getoId()) : that.getoId() != null) return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        if (getPlate() != null ? !getPlate().equals(that.getPlate()) : that.getPlate() != null) return false;
        if (getCreatedTime() != null ? !getCreatedTime().equals(that.getCreatedTime()) : that.getCreatedTime() != null)
            return false;
        return getModifiedTime() != null ? getModifiedTime().equals(that.getModifiedTime()) : that.getModifiedTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getoId() != null ? getoId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getPlate() != null ? getPlate().hashCode() : 0);
        result = 31 * result + (getCreatedTime() != null ? getCreatedTime().hashCode() : 0);
        result = 31 * result + (getModifiedTime() != null ? getModifiedTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkOrderEntity{" +
                "oId=" + oId +
                ", number='" + number + '\'' +
                ", plate='" + plate + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", wildBillEntities=" + wildBillEntities +
                '}';
    }
}
