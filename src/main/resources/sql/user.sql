create table `hospital`.`user`(
    id int not null auto_increment,
    username varchar(10) not null ,
    password varchar (20) not null ,
    role int not null default 0 comment '用户角色：1-普通用户；2-管理员；3-超管',
    avatar varchar (40) not null comment '头像',
    primary key ('id'),
    unique index id_UNIQUE (id ASC) visible
)
engin=InnoDB
DEFAULT character set = utf8
collate = utf8_bin
comment = '用户表';