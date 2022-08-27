package com.meihua.controller;

import com.meihua.dto.FileUploadRequest;
import com.meihua.mapper.FileMapper;
import com.meihua.mapper.FileUploadMapper;
import com.meihua.service.FileService;
import com.meihua.vo.FileUploadVo;
import com.meihua.vo.FileVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Api(tags = "文件上传")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadMapper fileUploadMapper;
    @Autowired
    private FileMapper fileMapper;

    @PostMapping("/upload_init")
    @ApiOperation("初始化文件上传")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) throws IOException {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @PostMapping("/{id}/upload_finish")
    @ApiOperation("完成文件上传")
    public FileVo finishUpload(@PathVariable String id) {
        return fileMapper.toVo(fileService.finishUpload(id));
    }
}
