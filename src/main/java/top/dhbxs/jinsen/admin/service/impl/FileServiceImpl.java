package top.dhbxs.jinsen.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dhbxs.jinsen.admin.entity.FileEntity;
import top.dhbxs.jinsen.admin.mapper.FileMapper;
import top.dhbxs.jinsen.admin.service.IFileService;

import java.util.List;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public void fileUpload(FileEntity fileEntity) {

        int result = fileMapper.insert(fileEntity);
    }

    /**
     * 查询数据库存储的所有文件
     * @return 返回查询结果集合
     */
    @Override
    public List<FileEntity> getAllFile() {
        List<FileEntity> files = fileMapper.selectList(null);
        return files;
    }
}
