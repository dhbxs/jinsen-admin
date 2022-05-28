package top.dhbxs.jinsen.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 上传文件实体类
 */
@TableName("upload_file")
public class FileEntity {

    @TableId(value = "f_id", type = IdType.AUTO)
    // 上传文件表主键
    private Integer fId;

    @TableField(value = "file_name")
    // 文件名
    private String fileName;

    @TableField(value = "file_path")
    // 文件路径
    private String filePath;

    @TableField(value = "recognition_id")
    // 识别后文件的id
    private Integer recognitionId;

    public FileEntity() {
    }

    public FileEntity(Integer fId, String fileName, String filePath, Integer recognitionId) {
        this.fId = fId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.recognitionId = recognitionId;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getRecognitionId() {
        return recognitionId;
    }

    public void setRecognitionId(Integer recognitionId) {
        this.recognitionId = recognitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEntity)) return false;

        FileEntity that = (FileEntity) o;

        if (getfId() != null ? !getfId().equals(that.getfId()) : that.getfId() != null) return false;
        if (getFileName() != null ? !getFileName().equals(that.getFileName()) : that.getFileName() != null)
            return false;
        if (getFilePath() != null ? !getFilePath().equals(that.getFilePath()) : that.getFilePath() != null)
            return false;
        return getRecognitionId() != null ? getRecognitionId().equals(that.getRecognitionId()) : that.getRecognitionId() == null;
    }

    @Override
    public int hashCode() {
        int result = getfId() != null ? getfId().hashCode() : 0;
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        result = 31 * result + (getFilePath() != null ? getFilePath().hashCode() : 0);
        result = 31 * result + (getRecognitionId() != null ? getRecognitionId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UploadFileEntity{" +
                "fId=" + fId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", recognitionId=" + recognitionId +
                '}';
    }
}
