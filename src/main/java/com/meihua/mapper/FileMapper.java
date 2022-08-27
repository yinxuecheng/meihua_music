package com.meihua.mapper;

import com.meihua.dto.FileDto;
import com.meihua.dto.FileUploadRequest;
import com.meihua.entity.File;
import com.meihua.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
