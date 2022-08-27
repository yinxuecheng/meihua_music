package com.meihua.vo;

import com.meihua.enums.MusicStatus;
import lombok.Data;

@Data
public class MusicVo extends BaseVo{

    private String name;

    private MusicStatus status;

    private String description;

}
