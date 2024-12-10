package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.common.AjaxResult;
import cn.luoyan.elitecode.common.constant.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 文件接口
 */
@RestController
@RequestMapping("/file")
public class ImageUploadController {

    @Value("${file.upload.path}")
    private String uploadPath;
    @Value("${file.upload.subdirectory}")
    private String uploadSubdirectory;

    @Value("${file.access.url}")
    private String accessURL;
    @Value("${file.access.subdirectory}")
    private String accessSubdirectory;

    //上传图片
    @PostMapping("/upload")
    public AjaxResult<String> uploadImg(MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return AjaxResult.error(HttpStatus.PARAMS_ERROR, "请选择文件");
        }
        // 按月份存储，获取存储目录
        String dir = DateTimeFormatter.ofPattern("yyyy-MM").format(Instant.now().atZone(ZoneId.of("Asia/Shanghai")));
        File targetLocation = Paths.get(uploadPath, uploadSubdirectory, dir).toFile();
        if (!targetLocation.exists()) {
            targetLocation.mkdirs();
        }
        // 获取上传图片名称
        String originalFilename = uploadFile.getOriginalFilename();
        // 获取文件扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 拼接的图片路径，使用UUID命名避免文件发生覆盖
        String newFileName = UUID.randomUUID().toString() + extName;
        File filePath = new File(targetLocation, newFileName);
        //上传图片
        try {
            uploadFile.transferTo(filePath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回图片访问url
        return AjaxResult.success(accessURL + "/" + accessSubdirectory + "/" + dir + "/" + newFileName);
    }
}