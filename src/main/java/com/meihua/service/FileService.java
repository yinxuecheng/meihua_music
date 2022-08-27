package com.meihua.service;

import com.meihua.dto.FileDto;
import com.meihua.dto.FileUploadDto;
import com.meihua.dto.FileUploadRequest;
import com.meihua.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();
}
