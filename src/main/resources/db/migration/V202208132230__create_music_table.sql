create table music (
          id              varchar(32)        not null      primary key       comment '歌曲id',
          name            varchar(128)       not null       comment '歌曲名称',
          description     TEXT               null           comment '歌曲描述',
          status          varchar(32)    DEFAULT 'DRAFT' not null  comment '歌曲状态,DRAFT-草稿，PUBLISHED-已上架,CLOSED-已下架',
          created_time    datetime(6)        not null       comment '创建时间',
          updated_time    datetime(6)        not null       comment '更新时间'
) engine = InnoDb default charset=utf8mb4 collate=utf8mb4_bin comment '歌曲表';