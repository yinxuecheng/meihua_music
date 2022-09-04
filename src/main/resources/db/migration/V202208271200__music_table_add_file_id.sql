alter table `music`
    add column `file_id` varchar(32) null comment '音乐文件id' after `description`,
    ADD constraint  `FK10nwdhsbrm1uhixvee0pasasg`
    foreign key(`file_id`) references  `file`(`id`)