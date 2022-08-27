package com.meihua.mapper;

import com.meihua.dto.FileUploadDto;
import com.meihua.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {

    FileUploadVo toVo(FileUploadDto fileUploadDto);

}
