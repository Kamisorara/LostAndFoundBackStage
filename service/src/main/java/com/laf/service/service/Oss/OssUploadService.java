package com.laf.service.service.Oss;

import org.springframework.web.multipart.MultipartFile;

public interface OssUploadService {

    String uploadFile(MultipartFile multipartFile);
}
