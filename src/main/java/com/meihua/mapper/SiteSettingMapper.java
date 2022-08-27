package com.meihua.mapper;

import com.meihua.dto.SiteSettingDto;
import com.meihua.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {

    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
