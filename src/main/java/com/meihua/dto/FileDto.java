package com.meihua.dto;

import com.meihua.enums.FileStatus;
import com.meihua.enums.FileType;
import com.meihua.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private String fileKey;

    private String ext;

    private Long size;

    private FileType type;

    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
