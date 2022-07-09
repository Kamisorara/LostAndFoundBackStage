package com.laf.service.service.Oss.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import com.laf.service.service.Oss.OssUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class OssUploadServiceImpl implements OssUploadService {
    @Override
    public String uploadFile(MultipartFile multipartFile) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "";
        String accessKeySecret = "";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "kamisora-bucker-1";
        // 1.创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            //2.获取文件文件上传流
            InputStream inputStream = multipartFile.getInputStream();
            //3.构建日期目录进行隔离
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());
            //4.获取文件名
            String originName = multipartFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString();
            //获取文件后缀
            String suffix = originName.substring(originName.lastIndexOf("."));
            String newName = filename + suffix;
            //完整路径
            String fileUrl = datePath + "/" + newName;
            //5.将文件信息传输到阿里云 信息传给阿里云要是文件流的形式 inputStream
            ossClient.putObject(bucketName, fileUrl, inputStream);
            //6.最后返回在阿里云oss里的地址 可以直接访问
            return "https://" + bucketName + "." + endpoint + "/" + fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "upload filed";
        } finally {
            //最后关闭ossClient
            ossClient.shutdown();
        }
    }
}
