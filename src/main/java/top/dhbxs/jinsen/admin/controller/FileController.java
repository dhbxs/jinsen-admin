package top.dhbxs.jinsen.admin.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dhbxs.jinsen.admin.entity.FileEntity;
import top.dhbxs.jinsen.admin.service.IFileService;
import top.dhbxs.jinsen.admin.util.JsonResult;

import java.io.File;
import java.io.IOException;

/**
 * 文件相关操作控制层
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController{

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Autowired
    IFileService iFileService;

    /**
     * 文件上传接口
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public JsonResult<String> upload(@RequestBody MultipartFile file) throws IOException {
        // 获取文件名
        System.out.println(file);
        String originalFilename = file.getOriginalFilename();
        // 获取文件类型
        String type = FileUtil.extName(originalFilename);

        // 先存储到磁盘
        // 父文件夹
        File uploadParentFile = new File(fileUploadPath);
        // 判断父文件夹是否存在，如果不存在，则新建父文件夹
        if(!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }

        // 定义文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();

        String fileName = uuid + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + uuid + StrUtil.DOT + type);
        // 把获取到的文件存储到目录中
        file.transferTo(uploadFile);

        FileEntity fileEntity = new FileEntity();

        fileEntity.setFileName(fileName);
        fileEntity.setFilePath(fileUploadPath);
        fileEntity.setRecognitionId(1);

        iFileService.fileUpload(fileEntity);

        return new JsonResult<String>(OK, "C:/Users/cooper/Desktop/BYSJ_code/upload/" + fileName);
    }
}
