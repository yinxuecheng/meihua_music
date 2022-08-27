package com.meihua.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FileUploadRequest {

    @NotBlank(message = "文件名不能为空")
    private String name;

    private Long size;

    @NotBlank(message = "文件扩展名不能为空")
    private String ext;

    @NotBlank(message = "fileKey不能为空")
    private String fileKey;
}
