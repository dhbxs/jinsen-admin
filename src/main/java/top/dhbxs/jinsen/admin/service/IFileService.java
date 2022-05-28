package top.dhbxs.jinsen.admin.service;

import top.dhbxs.jinsen.admin.entity.FileEntity;

public interface IFileService {

    /**
     * 文件上传接口
     */
    void fileUpload(FileEntity fileEntity);
}
