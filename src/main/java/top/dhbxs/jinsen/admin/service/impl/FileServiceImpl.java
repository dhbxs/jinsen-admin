package top.dhbxs.jinsen.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dhbxs.jinsen.admin.entity.FileEntity;
import top.dhbxs.jinsen.admin.mapper.FileMapper;
import top.dhbxs.jinsen.admin.service.IFileService;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public void fileUpload(FileEntity fileEntity) {

        int result = fileMapper.insert(fileEntity);
    }
}
