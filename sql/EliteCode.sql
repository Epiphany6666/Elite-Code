create database if not exists `elite-code`;
use `elite-code`;

-- ----------------------------
-- 用户信息表
-- ----------------------------
drop table if exists user;
create table if not exists user
(
    user_id       bigint(20)                              not null auto_increment comment '用户ID',
    user_account  varchar(256)                            not null comment '账号',
    user_password varchar(512)                            not null comment '密码',
    nick_name     varchar(256)  default NULL comment '用户昵称',
    user_avatar   varchar(1024) default NULL comment '用户头像',
    user_profile  varchar(512)  default NULL comment '用户简介',
    user_roles    varchar(256)  default '["user"]' comment '用户角色：user/admin/ban',
    del_flag      char(1)       default '0' comment '删除标志（0代表存在，2代表删除）',
    create_by     bigint(20)    default NULL comment '创建者',
    create_time   datetime      default current_timestamp comment '创建时间',
    update_by     bigint(20)    default NULL comment '更新者',
    update_time   datetime      default current_timestamp comment '编辑时间',
    primary key (user_id)
) engine = innodb
  auto_increment = 100 comment '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'luoyan', '05356905ea85829918968f841e5a0944', '管理员', 'https://pic.luo-yan.cn/elitecode/avatar.jpg',
        '系统管理员', '[\"admin\", \"user\"]', 1, '2024-11-22 08:36:41', 0, 1, '2024-11-27 08:36:41');
INSERT INTO `user`
VALUES (2, 'testuser', '05356905ea85829918968f841e5a0944', '测试用户', 'https://pic.luo-yan.cn/elitecode/avatar.jpg',
        '测试人员', '[\"user\"]', 0,  1, '2024-11-27 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user`
VALUES (100, 'luoyantst', '25d55ad283aa400af464c76d713c07ad', 'luoyantst', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', 0,  1,
        '2024-12-06 08:10:43', 1, '2024-12-06 08:10:43');
INSERT INTO `user`
VALUES (101, 'luoyantest', '25d55ad283aa400af464c76d713c07ad', 'luoyantest', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', 0,  1,
        '2024-12-06 16:49:27', 1, '2024-12-06 16:49:27');
INSERT INTO `user`
VALUES (102, 'luoyantest1', '25d55ad283aa400af464c76d713c07ad', 'luoyantest1', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', 0,  1,
        '2024-12-06 17:13:38', 1, '2024-12-06 17:13:38');
INSERT INTO `user`
VALUES (103, 'luoyantest2', '25d55ad283aa400af464c76d713c07ad', 'luoyantest2', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', 0,  1,
        '2024-12-06 19:58:42', 1, '2024-12-06 19:58:42');
INSERT INTO `user`
VALUES (105, 'luoyantest4', '25d55ad283aa400af464c76d713c07ad', 'luoyantest4', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', 0,  1,
        '2024-12-08 23:12:54', 1, '2024-12-08 23:12:54');
INSERT INTO `user`
VALUES (106, 'luoyantest3', '25d55ad283aa400af464c76d713c07ad', 'luoyantest3', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\",\"admin\"]', 0,  1,
        '2024-12-08 23:22:03', 1, '2024-12-08 23:22:03');
