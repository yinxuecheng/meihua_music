package com.meihua.mapper;

import com.meihua.dto.MusicCreateRequest;
import com.meihua.dto.MusicDto;
import com.meihua.dto.MusicUpdateRequest;
import com.meihua.entity.Music;
import com.meihua.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MusicMapper {

    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);

}
