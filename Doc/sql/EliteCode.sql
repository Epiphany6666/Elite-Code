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
VALUES (1, 'luoyan', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '管理员', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '系统管理员', '[\"admin\", \"user\"]', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (2, 'testuser', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '测试用户', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '测试人员', '[\"user\"]', '0', 1, '2024-11-27 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, 'luoyantst', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantst', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 08:10:43', 1, '2024-12-06 08:10:43');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, 'luoyantest', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 16:49:27', 1, '2024-12-06 16:49:27');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, 'luoyantest1', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest1', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 17:13:38', 1, '2024-12-06 17:13:38');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (103, 'luoyantest2', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest2', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-06 19:58:42', 1, '2024-12-06 19:58:42');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (105, 'luoyantest4', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest4', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\"]', '0', 1, '2024-12-08 23:12:54', 1, '2024-12-08 23:12:54');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (106, 'luoyantest3', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest3', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '[\"user\",\"admin\"]', '0', 1, '2024-12-08 23:22:03', 1, '2024-12-08 23:22:03');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (107, '2123', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-01-02 14:04:29', NULL, '2025-01-02 14:04:29');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (108, '21321312', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-02-26 09:16:26', NULL, '2025-02-26 09:16:26');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, roles, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (109, '341341', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, NULL, NULL, '[\"user\"]', '0', NULL, '2025-02-26 09:20:45', NULL, '2025-02-26 09:20:45');

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

-- ----------------------------
-- 初始化-题库表数据
-- ----------------------------
INSERT INTO `question_bank` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, '力扣经典题库', '精选力扣热门题目，覆盖算法、数据结构', NULL, '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);
INSERT INTO `question_bank` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, '大厂面试真题', '腾讯、阿里、字节等大厂高频考题', NULL, '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);
INSERT INTO `question_bank` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, 'SQL必知必会', '数据库查询与优化实战练习', NULL, '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

-- ----------------------------
-- 题目表
-- ----------------------------
drop table if exists `question`;
create table if not exists `question` (
  id            bigint(20)       not null auto_increment        comment '用户ID，主键',
  title         varchar(256)     not null                       comment '标题',
  content       text             default NULL                   comment '内容',
  tags          varchar(1024)    default NULL                   comment '标签列表（JSON数组）',
  answer        text             default NULL                   comment '推荐答案',
  del_flag      char(1)          default '0'                    comment '删除标志（0代表存在，2代表删除）',
  create_by     bigint(20)       default NULL                   comment '创建者',
  create_time   datetime         default current_timestamp      comment '创建时间',
  update_by     bigint(20)       default NULL                   comment '更新者',
  update_time   datetime         default current_timestamp      comment '编辑时间',
  primary key (id)
) engine = innodb
  auto_increment = 100 comment '题目表';

-- ----------------------------
-- 初始化-题目表数据
-- ----------------------------
INSERT INTO `question` (`id`, `title`, `content`, `tags`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, '两数之和', '给定一个整数数组 nums 和一个目标值 target...', '["数组", "哈希表"]', '使用哈希表存储遍历过的数字，时间复杂度O(n)', '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);
INSERT INTO `question` (`id`, `title`, `content`, `tags`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, '反转链表', '定义一个函数，输入一个链表的头节点...', '["链表", "递归"]', '迭代或递归实现，注意指针操作', '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);
INSERT INTO `question` (`id`, `title`, `content`, `tags`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, '统计订单数量', '编写SQL查询，返回每个客户的订单总数...', '["SQL", "聚合"]', 'SELECT customer_id, COUNT(*) FROM orders GROUP BY customer_id', '0', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP);

-- ----------------------------
-- 题目题库关联表
-- ----------------------------
drop table if exists `question_bank_question`;
create table `question_bank_question` (
  question_id       bigint(20)    not null   comment '题目id',
  question_bank_id  bigint(20)    not null   comment '题库id',
  primary key (question_id, question_bank_id)
) engine = innodb comment '题目与题库关联表';

-- ----------------------------
-- 初始化-题目题库关联表数据
-- ----------------------------
INSERT INTO `question_bank_question` (`question_id`, `question_bank_id`) VALUES (100, 101);
INSERT INTO `question_bank_question` (`question_id`, `question_bank_id`) VALUES (101, 100);
INSERT INTO `question_bank_question` (`question_id`, `question_bank_id`) VALUES (102, 102);