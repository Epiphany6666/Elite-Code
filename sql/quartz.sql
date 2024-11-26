create database if not exists `elite-code`;
use `elite-code`;

-- ----------------------------
-- 用户信息表
-- ----------------------------
drop table if exists sys_user;
create table if not exists sys_user
(
    user_id       bigint                                 not null auto_increment comment '用户ID',
    user_account  varchar(256)                           not null comment '账号',
    user_password varchar(512)                           not null comment '密码',
    nick_name     varchar(256)                           not null comment '用户昵称',
    user_avatar   varchar(1024)                          not null comment '用户头像',
    user_profile  varchar(512)                           not null comment '用户简介',
    user_role     varchar(256) default 'user'        not null comment '用户角色：user/admin/ban',
    create_by     varchar(64)  default '' comment '创建者',
    create_time   datetime     default current_timestamp not null comment '创建时间',
    update_by     varchar(64)  default '' comment '更新者',
    update_time   datetime     default current_timestamp not null comment '编辑时间',
    primary key (user_id)
) engine = innodb auto_increment = 100 comment '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO sys_user VALUES (1, '洛言', 'b0dd3697a192885d7c055db46155b26a', '管理员', 'https://pic.luo-yan.cn/avatar.jpg', '系统管理员', 'admin', 'admin', NOW(), '', NOW());
INSERT INTO sys_user VALUES (2, 'testuser', 'b0dd3697a192885d7c055db46155b26a', '测试用户', 'https://pic.luo-yan.cn/avatar.jpg', '测试人员', 'user', 'admin', NOW(), '', NOW());
