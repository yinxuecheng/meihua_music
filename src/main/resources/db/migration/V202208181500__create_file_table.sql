create table file (
                       `id`              varchar(32)        not null      primary key       comment '文件id',
                       `name`            varchar(128)       not null       comment '文件名',
                       `file_key`           varchar(64)          not null        comment '文件hash值，即ObjectKey',
                       `ext`          varchar(12)         not null         comment '文件后缀名',
                       `size`          int     default 0   not null         comment '文件大小,单位byte',
                       `type`          varchar(32)        default 'OTHER'      not null         comment '文件类型;AUDIO-音频，IMAGE-图片,VIDEO-视频，OTHER-其他',
                       `storage`          varchar(16)        default 'COS'   not null         comment '存储供应商;COS-腾讯云存储，OSS-阿里云存储',
                       `status`          varchar(32)         default 'UPLOADING'    not null         comment '文件状态;UPLOADING-上传中 ,UPLOADED-已上传 ,CANCEL-已取消',
                       `created_time`    datetime(6)        not null       comment '创建时间',
                       `updated_time`    datetime(6)        not null       comment '更新时间'
) engine = InnoDb default charset=utf8mb4 collate=utf8mb4_bin comment '文件表';