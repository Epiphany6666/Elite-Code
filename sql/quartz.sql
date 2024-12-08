create database if not exists `elite-code`;
use `elite-code`;

-- ----------------------------
-- 用户信息表
-- ----------------------------
drop table if exists user;
create table if not exists user
(
    user_id       bigint                                  not null auto_increment comment '用户ID',
    user_account  varchar(256)                            not null comment '账号',
    user_password varchar(512)                            not null comment '密码',
    nick_name     varchar(256)  default user.user_account not null comment '用户昵称',
    user_avatar   varchar(1024) default ''                not null comment '用户头像',
    user_profile  varchar(512)  default ''                not null comment '用户简介',
    user_role     varchar(256)  default '["user"]'            not null comment '用户角色：user/admin/ban',
    create_by     varchar(64)   default '' comment '创建者',
    create_time   datetime      default current_timestamp not null comment '创建时间',
    update_by     varchar(64)   default '' comment '更新者',
    update_time   datetime      default current_timestamp not null comment '编辑时间',
    primary key (user_id)
) engine = innodb
auto_increment = 100 comment '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO user
VALUES (1, '洛言', '05356905ea85829918968f841e5a0944', '管理员', 'https://pic.luo-yan.cn/elitecode/avatar.jpg',
        '系统管理员', 'admin', 'admin', NOW(), '', NOW());
INSERT INTO user
VALUES (2, 'testuser', '05356905ea85829918968f841e5a0944', '测试用户', 'https://pic.luo-yan.cn/elitecode/avatar.jpg',
        '测试人员', 'user', 'admin', NOW(), '', NOW());
