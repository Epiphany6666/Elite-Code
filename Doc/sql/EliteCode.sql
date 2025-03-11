create database if not exists `elite-code`;
use `elite-code`;

-- ----------------------------
-- 用户信息表
-- ----------------------------
drop table if exists `user`;
create table if not exists `user` (
  id            bigint(20)    not null auto_increment     comment '用户ID',
  username      varchar(256)  not null                    comment '账号',
  password      varchar(512)  not null                    comment '密码',
  nick_name     varchar(256)  default NULL                comment '用户昵称',
  avatar        varchar(1024) default NULL                comment '用户头像',
  profile       varchar(512)  default NULL                comment '用户简介',
  roles         varchar(256)  default '["user"]'          comment '用户角色：user/admin/ban',
  del_flag      char(1)       default '0'                 comment '删除标志（0代表存在，2代表删除）',
  create_by     bigint(20)    default NULL                comment '创建者',
  create_time   datetime      default current_timestamp   comment '创建时间',
  update_by     bigint(20)    default NULL                comment '更新者',
  update_time   datetime      default current_timestamp   comment '编辑时间',
  primary key (id)
) engine = innodb
  auto_increment = 100 comment '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (1, 'luoyan', '05356905ea85829918968f841e5a0944', '管理员', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '系统管理员', '[\"admin\", \"user\"]', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (2, 'testuser', '05356905ea85829918968f841e5a0944', '测试用户', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '测试人员', '[\"user\"]', '0', 1, '2024-11-27 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, 'luoyantst', '25d55ad283aa400af464c76d713c07ad', 'luoyantst', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 08:10:43', 1, '2024-12-06 08:10:43');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, 'luoyantest', '25d55ad283aa400af464c76d713c07ad', 'luoyantest', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 16:49:27', 1, '2024-12-06 16:49:27');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, 'luoyantest1', '25d55ad283aa400af464c76d713c07ad', 'luoyantest1', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 17:13:38', 1, '2024-12-06 17:13:38');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (103, 'luoyantest2', '25d55ad283aa400af464c76d713c07ad', 'luoyantest2', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 19:58:42', 1, '2024-12-06 19:58:42');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (105, 'luoyantest4', '25d55ad283aa400af464c76d713c07ad', 'luoyantest4', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-08 23:12:54', 1, '2024-12-08 23:12:54');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (106, 'luoyantest3', '25d55ad283aa400af464c76d713c07ad', 'luoyantest3', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\",\"admin\"]', '0', 1, '2024-12-08 23:22:03', 1, '2024-12-08 23:22:03');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (107, '2123', 'a7d79193c74129f551b9e6def51b8554', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-01-02 14:04:29', NULL, '2025-01-02 14:04:29');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (108, '21321312', '19034a0864adffdac1d9648b43009822', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-02-26 09:16:26', NULL, '2025-02-26 09:16:26');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (109, '341341', '19034a0864adffdac1d9648b43009822', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-02-26 09:20:45', NULL, '2025-02-26 09:20:45');

-- ----------------------------
-- 题库表
-- ----------------------------
drop table if exists `question_bank`;
create table if not exists `question_bank` (
   id               bigint(20)      not null auto_increment         comment '用户ID，主键',
   title            varchar(256)    not null                        comment '标题',
   description      text            default NULL                    comment '描述',
   picture          varchar(2048)   default NULL                    comment '图片',
   del_flag         char(1)         default '0'                     comment '删除标志（0代表存在，2代表删除）',
   create_by        bigint(20)      default NULL                    comment '创建者',
   create_time      datetime        default current_timestamp       comment '创建时间',
   update_by        bigint(20)      default NULL                    comment '更新者',
   update_time      datetime        default current_timestamp       comment '编辑时间',
   primary key (id)
) engine = InnoDB
  auto_increment = 100 comment '题库表';
