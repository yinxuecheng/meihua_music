package com.meihua.entity;

import com.meihua.enums.FileStatus;
import com.meihua.enums.FileType;
import com.meihua.enums.Storage;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
public class File extends AbstractEntity{

    private String name;

    private String fileKey;

    private String ext;

    private Integer size;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
}
