package com.meihua.vo;

import com.meihua.enums.FileStatus;
import com.meihua.enums.FileType;
import lombok.Data;

@Data
public class FileVo extends BaseVo{

    private String name;

    private String fileKey;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}
