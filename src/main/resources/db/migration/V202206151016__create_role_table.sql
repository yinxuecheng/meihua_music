create table role (
    id              varchar(32)        not null
                    primary key                       comment '角色id',
    name            varchar(128)       null           comment '角色名称',
    title           varchar(128)       null           comment '角色标识',
    created_time    datetime(6)        not null       comment '创建时间',
    updated_time    datetime(6)        not null       comment '更新时间'
) engine = InnoDb default charset=utf8mb4 collate=utf8mb4_bin comment '角色表';