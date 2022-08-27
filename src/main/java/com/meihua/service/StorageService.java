package com.meihua.service;

import com.meihua.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;
}
