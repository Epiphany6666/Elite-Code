package cn.elitecode.module.infra.controller.admin.file;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.infra.MinioProperties;
import cn.elitecode.module.infra.controller.admin.file.vo.MinioUploadReqVO;
import cn.elitecode.module.infra.dal.BucketPolicyConfigBo;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import io.minio.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = "MinioController", description = "Minio对象存储管理")
@RestController
@RequestMapping("/minio")
public class MinioController {

    private static final Logger logger = LoggerFactory.getLogger(MinioController.class);

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    private CommonResult<MinioUploadReqVO> upload(MultipartFile file) {

        try {
            // 创建Minio的Java客户端
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(MinioProperties.getEndpoint())
                            .credentials(MinioProperties.getAccessKey(), MinioProperties.getSecretKey())
                            .build();

            // Make bucket if not exist.
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(MinioProperties.getBucketName()).build());
            if (isExist) {
                logger.error("存储桶已存在！");
            } else {
                // 创建桶并设置只读权限
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(MinioProperties.getBucketName()).build());
                BucketPolicyConfigBo.Statement statement = new BucketPolicyConfigBo.Statement(
                        "Allow",
                        "*",
                        "s3:GetObject",
                        "arn:aws:s3:::" + MinioProperties.getBucketName() + "/*"
                );
                BucketPolicyConfigBo bucketPolicyConfigBo = new BucketPolicyConfigBo("2012-10-17", CollUtil.toList(statement));
                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                        .bucket(MinioProperties.getBucketName())
                        .config(JSONUtil.toJsonStr(bucketPolicyConfigBo))
                        .build();
                minioClient.setBucketPolicy(setBucketPolicyArgs);
            }
            String newFileName = IdUtil.simpleUUID() + "." + FileNameUtil.extName(file.getOriginalFilename());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String objectName = sdf.format(new Date()) + "/" + newFileName;
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(MinioProperties.getBucketName())
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE)
                    .build();
            minioClient.putObject(putObjectArgs);
            MinioUploadReqVO minioUploadReqVO = new MinioUploadReqVO();
            minioUploadReqVO.setUrl(MinioProperties.getUrl() + "/" + MinioProperties.getBucketName() + "/" + objectName);
            minioUploadReqVO.setFilename(newFileName);
            return CommonResult.success(minioUploadReqVO);
        } catch (Exception e) {
            logger.error(e.toString());
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "文件上传失败");
        }
    }
}
