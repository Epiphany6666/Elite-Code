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
    nick_name     varchar(256)  default null                comment '用户昵称',
    avatar        varchar(1024) default null                comment '用户头像',
    profile       varchar(512)  default null                comment '用户简介',
    del_flag      char(1)       default '0'                 comment '删除标志（0代表存在，2代表删除）',
    create_by     bigint(20)    default null                comment '创建者',
    create_time   datetime      default current_timestamp   comment '创建时间',
    update_by     bigint(20)    default null                comment '更新者',
    update_time   datetime      default current_timestamp   comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (1, 'luoyan', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '管理员', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '系统管理员', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (2, 'testuser', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '测试用户', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '测试人员', '0', 1, '2024-11-27 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, 'luoyantst', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantst', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-06 08:10:43', 1, '2024-12-06 08:10:43');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, 'luoyantest', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-06 16:49:27', 1, '2024-12-06 16:49:27');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, 'luoyantest1', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest1', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-06 17:13:38', 1, '2024-12-06 17:13:38');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (103, 'luoyantest2', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest2', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-06 19:58:42', 1, '2024-12-06 19:58:42');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (105, 'luoyantest4', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest4', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-08 23:12:54', 1, '2024-12-08 23:12:54');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (106, 'luoyantest3', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest3', 'https://pic.luo-yan.cn/elitecode/avatar.jpg', '', '0', 1, '2024-12-08 23:22:03', 1, '2024-12-08 23:22:03');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (107, '2123', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', null, null, null, '0', null, '2025-01-02 14:04:29', null, '2025-01-02 14:04:29');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (108, '21321312', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', null, null, null, '0', null, '2025-02-26 09:16:26', null, '2025-02-26 09:16:26');
INSERT INTO `user` (id, username, password, `nick_name`, avatar, profile, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (109, '341341', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', null, null, null, '0', null, '2025-02-26 09:20:45', null, '2025-02-26 09:20:45');

-- ----------------------------
-- 系统访问记录
-- ----------------------------
drop table if exists `user_login_info`;
create table if not exists `user_login_info` (
    id           bigint(20)    not null auto_increment     comment 'ID，主键',
    username     varchar(50)   default null                comment '用户账号',
    ip           varchar(128)  default null                comment '登录IP地址',
    address      varchar(100)  default null                comment '登陆地点',
    browser      varchar(50)   default null                comment '浏览器类型',
    os           varchar(50)   default null                comment '操作系统',
    status       char(1)       default '0'                 comment '登录状态 (0成功 1失败)',
    msg          varchar(255)  default null                comment '提示消息',
    login_time   datetime      default current_timestamp   comment '登录时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '系统访问记录';

-- ----------------------------
-- 初始化-系统访问记录数据
-- ----------------------------
INSERT INTO user_login_info (id, username, ip, address, browser, os, status, msg, login_time)
VALUES (100, 'luoyan', '192.168.1.101', '上海', 'Chrome', 'Windows 10', '0', '登录成功', '2024-11-22 09:00:00');

INSERT INTO user_login_info (id, username, ip, address, browser, os, status, msg, login_time)
VALUES (101, 'testuser', '192.168.1.102', '北京', 'Firefox', 'MacOS', '1', '密码错误', '2024-11-22 09:05:00');

INSERT INTO user_login_info (id, username, ip, address, browser, os, status, msg, login_time)
VALUES (102, 'luoyantst', '192.168.1.103', '广州', 'Edge', 'Windows 11', '0', '登录成功', '2024-12-06 08:15:00');

INSERT INTO user_login_info (id, username, ip, address, browser, os, status, msg, login_time)
VALUES (103, 'luoyantest1', '192.168.1.104', '深圳', 'Safari', 'iOS', '0', '登录成功', '2024-12-06 17:20:00');

INSERT INTO user_login_info (id, username, ip, address, browser, os, status, msg, login_time)
VALUES (104, 'luoyantest3', '192.168.1.105', '杭州', 'Chrome', 'Android', '1', '账户被锁定', '2024-12-08 23:30:00');

-- ----------------------------
-- 角色信息表
-- ----------------------------
drop table if exists `role`;
create table if not exists `role` (
    id            bigint(20)    not null auto_increment     comment '角色ID，主键',
    name          varchar(30)   not null                    comment '角色名称',
    sort          int(4)        not null                    comment '显示顺序',
    del_flag      char(1)       default '0'                 comment '删除标志（0代表存在，2代表删除）',
    create_by     bigint(20)    default null                comment '创建者',
    create_time   datetime      default current_timestamp   comment '创建时间',
    update_by     bigint(20)    default null                comment '更新者',
    update_time   datetime      default current_timestamp   comment '编辑时间',
    primary key (id)
) engine = innodb comment '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
INSERT INTO `role` (id, name, sort, del_flag, create_by, create_time, update_by, update_time)
VALUES (1, 'admin', 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `role` (id, name, sort, del_flag, create_by, create_time, update_by, update_time)
VALUES (2, 'user', 2, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');

-- ----------------------------
-- 用户和角色关联表
-- ----------------------------
drop table if exists `user_role`;
create table if not exists `user_role` (
   user_id       bigint(20)    not null                    comment '用户ID',
   role_id       bigint(20)    not null                    comment '角色ID',
   primary key (user_id, role_id)
) engine = innodb comment '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
INSERT INTO `user_role` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 2);

-- ----------------------------
-- 菜单权限表
-- ----------------------------
drop table if exists `menu`;
create table if not exists `menu` (
  id            bigint(20)    not null auto_increment     comment '菜单id，主键',
  title         int(50)       not null                    comment '菜单标题',
  parent_id     bigint(20)    default 0                   comment '父菜单ID',
  sort          int(4)        not null                    comment '显示顺序',
  component     varchar(255)  default null                comment '组件路径',
  if_frame      int(1)        default 1                   comment '是否为外链 (0是 1否)',
  status        char(1)       default '0'                 comment '菜单状态 (0正常 1停用)',
  create_by     bigint(20)    default null                comment '创建者',
  create_time   datetime      default current_timestamp   comment '创建时间',
  update_by     bigint(20)    default null                comment '更新者',
  update_time   datetime      default current_timestamp   comment '编辑时间',
  primary key (id)
) engine = innodb
  auto_increment = 100 comment '菜单权限表';

-- ----------------------------
-- 初始化-菜单权限表数据
-- ----------------------------
INSERT INTO `menu` (id, title, parent_id, sort, component, if_frame, status, create_by, create_time, update_by, update_time)
VALUES (100, 10001, 0, 1, '/system', 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `menu` (id, title, parent_id, sort, component, if_frame, status, create_by, create_time, update_by, update_time)
VALUES (101, 10002, 100, 2, '/user', 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');

-- ----------------------------
-- 角色和菜单关联表
-- ----------------------------
drop table if exists `role_menu`;
create table if not exists `role_menu` (
   role_id       bigint(20)    not null     comment '角色ID',
   menu_id       bigint(20)    not null     comment '菜单ID',
   primary key (role_id, menu_id)
) engine = innodb comment '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
INSERT INTO `role_menu` (role_id, menu_id) VALUES (1, 100);
INSERT INTO `role_menu` (role_id, menu_id) VALUES (1, 101);

-- ----------------------------
-- 题库表
-- ----------------------------
drop table if exists `problemset`;
create table if not exists `problemset` (
    id               bigint(20)      not null auto_increment         comment '用户ID，主键',
    title            varchar(256)    not null                        comment '标题',
    description      text            default null                    comment '描述',
    picture          varchar(2048)   default null                    comment '图片',
    del_flag         char(1)         default '0'                     comment '删除标志（0代表存在，2代表删除）',
    create_by        bigint(20)      default null                    comment '创建者',
    create_time      datetime        default current_timestamp       comment '创建时间',
    update_by        bigint(20)      default null                    comment '更新者',
    update_time      datetime        default current_timestamp       comment '编辑时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 100 comment '题库表';

-- ----------------------------
-- 初始化-题库表数据
-- ----------------------------
INSERT INTO `problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, '力扣经典题库', '精选力扣热门题目，覆盖算法、数据结构', null, '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);
INSERT INTO `problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, '大厂面试真题', '腾讯、阿里、字节等大厂高频考题', null, '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);
INSERT INTO `problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, 'SQL必知必会', '数据库查询与优化实战练习', null, '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);

-- ----------------------------
-- 题目表
-- ----------------------------
drop table if exists `question`;
create table if not exists `question` (
    id            bigint(20)       not null auto_increment        comment '用户ID，主键',
    title         varchar(256)     not null                       comment '标题',
    content       text             default null                   comment '内容',
    answer        text             default null                   comment '推荐答案',
    del_flag      char(1)          default '0'                    comment '删除标志（0代表存在，2代表删除）',
    create_by     bigint(20)       default null                   comment '创建者',
    create_time   datetime         default current_timestamp      comment '创建时间',
    update_by     bigint(20)       default null                   comment '更新者',
    update_time   datetime         default current_timestamp      comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '题目表';

-- ----------------------------
-- 初始化-题目表数据
-- ----------------------------
INSERT INTO `question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (100, '两数之和', '给定一个整数数组 nums 和一个目标值 target...', '使用哈希表存储遍历过的数字，时间复杂度O(n)', '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);
INSERT INTO `question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (101, '反转链表', '定义一个函数，输入一个链表的头节点...', '迭代或递归实现，注意指针操作', '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);
INSERT INTO `question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES (102, '统计订单数量', '编写SQL查询，返回每个客户的订单总数...', 'SELECT customer_id, COUNT(*) FROM orders GROUP BY customer_id', '0', 1, CURRENT_TIMESTAMP, null, CURRENT_TIMESTAMP);

-- ----------------------------
-- 题库题目关联表
-- ----------------------------
drop table if exists `problemset_question`;
create table if not exists `problemset_question` (
    question_id    bigint(20)    not null   comment '题目id',
    problemset_id  bigint(20)    not null   comment '题库id',
    primary key (problemset_id, question_id)
) engine = innodb comment '题目与题库关联表';

-- ----------------------------
-- 初始化-题目题库关联表数据
-- ----------------------------
INSERT INTO `problemset_question` (`question_id`, `problemset_id`) VALUES (100, 101);
INSERT INTO `problemset_question` (`question_id`, `problemset_id`) VALUES (101, 100);
INSERT INTO `problemset_question` (`question_id`, `problemset_id`) VALUES (102, 102);

-- ----------------------------
-- 题目标签
-- ----------------------------
drop table if exists `question_tag`;
create table if not exists `question_tag` (
    id          bigint(20)   not null auto_increment  comment '标签ID，主键',
    name        varchar(50)  not null                 comment '标签名',
    del_flag    char(1)      default '0'              comment '删除标志（0代表存在，2代表删除）',
    create_by   bigint(20)   default null             comment '创建者',
    create_time datetime     default current_timestamp comment '创建时间',
    update_by   bigint(20)   default null             comment '更新者',
    update_time datetime     default current_timestamp comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '题目标签表';

-- ----------------------------
-- 初始化-题目标签表数据
-- ----------------------------
INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (100, '数组', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (101, '哈希表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (102, '链表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (103, '递归', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (104, 'SQL', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO question_tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (105, '聚合', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');


-- ----------------------------
-- 题目和标签关联表
-- ----------------------------
drop table if exists `tag_question`;
create table if not exists `tag_question` (
    question_id  bigint(20)  not null  comment '题目ID（外键，关联题目表ID）',
    tag_id       bigint(20)  not null  comment '标签ID（外键，关联标签表ID）'
) engine = innodb comment '题目和标签关联表';

-- ----------------------------
-- 初始化-标签题目关联表数据
-- ----------------------------
INSERT INTO tag_question (question_id, tag_id)
VALUES (100, 100);

INSERT INTO tag_question (question_id, tag_id)
VALUES (100, 101);

INSERT INTO tag_question (question_id, tag_id)
VALUES (101, 102);

INSERT INTO tag_question (question_id, tag_id)
VALUES (101, 103);

INSERT INTO tag_question (question_id, tag_id)
VALUES (102, 104);

INSERT INTO tag_question (question_id, tag_id)
VALUES (102, 105);