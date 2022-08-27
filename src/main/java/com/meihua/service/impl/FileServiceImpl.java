package com.meihua.service.impl;

import com.meihua.dto.FileDto;
import com.meihua.dto.FileUploadDto;
import com.meihua.dto.FileUploadRequest;
import com.meihua.entity.File;
import com.meihua.enums.FileStatus;
import com.meihua.enums.Storage;
import com.meihua.exception.BizException;
import com.meihua.exception.ExceptionType;
import com.meihua.mapper.FileMapper;
import com.meihua.repository.FileRepository;
import com.meihua.service.FileService;
import com.meihua.service.StorageService;
import com.meihua.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private Map<String, StorageService> storageServices;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
        //创建File实体
        File file = fileMapper.createEntity(fileUploadRequest);
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        File saveFile = fileRepository.save(file);
        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setFileKey(saveFile.getFileKey());
        fileUploadDto.setFileId(saveFile.getId());
        return fileUploadDto;
    }

    @Override
    public FileDto finishUpload(String id) {
        Optional<File> fileOptional = fileRepository.findById(id);
        if (!fileOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }
        //TODO: 只有上传者才能给更新finish；权限判断

        //TODO: 验证远程文件是否存在
        File file = fileOptional.get();
        file.setStatus(FileStatus.UPLOADED);
        return fileMapper.toDto(fileRepository.save(file));
    }

    // TODO: 后台设置当前storage
    @Override
    public Storage getDefaultStorage() {
        return Storage.COS;
    }
}
