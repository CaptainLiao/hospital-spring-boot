package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

  @PostMapping("/upload")
  public ServerResponse<String> upload(@RequestParam MultipartFile file) throws IOException {
    if (file.isEmpty()) return ServerResponse.error("上传文件不能为空");

    String contentType = file.getContentType();
    String fileName = file.getName();
    System.out.println(fileName);
    String originFileName = file.getOriginalFilename();

    Long fileSize = file.getSize();

    // 保存文件
    file.transferTo(new File("G://Icons/spring-" + originFileName));

    return ServerResponse.success(String.format(
          file.getClass().getName() +
          "方式文件上传成功！\n新文件名：%s，文件名:%s,文件类型:%s,文件大小:%s",
          fileName, originFileName, contentType,fileSize
        )
    );
  }
}















