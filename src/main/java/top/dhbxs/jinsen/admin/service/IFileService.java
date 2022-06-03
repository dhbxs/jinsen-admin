package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.entity.FileEntity;

import java.util.List;

public interface IFileService {

    /**
     * 文件上传接口
     */
    void fileUpload(FileEntity fileEntity);

    /**
     * 查询所有文件信息
     * @return 返回查询的集合
     */
    List<FileEntity> getAllFile();
}
