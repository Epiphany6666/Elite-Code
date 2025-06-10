drop database if exists `elite-code`;
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
    id                      bigint(20)    not null auto_increment     comment '角色ID，主键',
    name                    varchar(30)   not null                    comment '角色名称',
    sort                    int(4)        not null                    comment '显示顺序',
    menu_check_strictly     tinyint(1)    default 1                   comment '菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）',
    del_flag                char(1)       default '0'                 comment '删除标志（0代表存在，2代表删除）',
    create_by               bigint(20)    default null                comment '创建者',
    create_time             datetime      default current_timestamp   comment '创建时间',
    update_by               bigint(20)    default null                comment '更新者',
    update_time             datetime      default current_timestamp   comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
INSERT INTO `role` (id, name, sort, del_flag, role.menu_check_strictly, create_by, create_time, update_by, update_time)
VALUES (1, 'admin', 1, '0', 1, 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `role` (id, name, sort, menu_check_strictly, del_flag, create_by, create_time, update_by, update_time)
VALUES (2, 'user', 2, 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');

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
-- 菜单表
-- ----------------------------
drop table if exists `menu`;
create table if not exists `menu` (
  id            bigint(20)    not null auto_increment     comment '菜单id，主键',
  title         varchar(50)       not null                    comment '菜单标题',
  parent_id     bigint(20)    default 0                   comment '父菜单ID',
  sort          int(4)        not null                    comment '显示顺序',
  component     varchar(255)  default null                comment '组件路径',
  if_frame      int(1)        default 1                   comment '是否为外链 (0是 1否)',
  type          char(1)       default ''                  comment '菜单类型（M目录 C菜单）',
  visible       char(1)       default ''                  comment '菜单状态（0显示 1隐藏）',
  status        char(1)       default '0'                 comment '菜单状态 (0正常 1停用)',
  create_by     bigint(20)    default null                comment '创建者',
  create_time   datetime      default current_timestamp   comment '创建时间',
  update_by     bigint(20)    default null                comment '更新者',
  update_time   datetime      default current_timestamp   comment '编辑时间',
  primary key (id)
) engine = innodb
  auto_increment = 100 comment '菜单权限表';

-- ----------------------------
-- 初始化-菜单表数据
-- ----------------------------
INSERT INTO `menu` (id, title, parent_id, sort, component, if_frame, type, visible, status, create_by, create_time, update_by, update_time)
VALUES (100, '系统', 0, 1, '/system', 1, 'C', 0, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `menu` (id, title, parent_id, sort, component, if_frame, type, visible, status, create_by, create_time, update_by, update_time)
VALUES (101, '用户', 100, 2, '/user', 1, 'C', 0, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');

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
-- 后台资源表
-- 用于控制后台用户可以访问的接口，使用了Ant路径的匹配规则，可以使用通配符定义一系列接口的权限
-- ----------------------------
drop table if exists `resource`;
create table if not exists `resource` (
    id              bigint(20)      not null auto_increment     comment '资源ID',
    name            varchar(50)     not null                    comment '资源名称',
    url             varchar(200)    not null                    comment '资源URL',
    category_id     bigint(20)      not null                    comment '分类ID',
    create_by       bigint(20)      default null                comment '创建者',
    create_time     datetime        default current_timestamp   comment '创建时间',
    update_by       bigint(20)      default null                comment '更新者',
    update_time     datetime        default current_timestamp   comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '后台资源表';

-- ----------------------------
-- 初始化-后台资源表数据
-- ----------------------------
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '商品品牌管理', '/brand/**', 1, NULL, '2020-02-04 17:04:55', NULL, '2020-02-04 17:04:55');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '商品属性分类管理', '/productAttribute/category/**', 1, NULL, '2020-02-04 17:05:35', NULL, '2020-02-04 17:05:35');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '商品属性管理', '/productAttribute/**', 1, NULL, '2020-02-04 17:06:13', NULL, '2020-02-04 17:06:13');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '商品分类管理', '/productCategory/**', 1, NULL, '2020-02-04 17:07:15', NULL, '2020-02-04 17:07:15');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '商品管理', '/product/**', 1, NULL, '2020-02-04 17:09:16', NULL, '2020-02-04 17:09:16');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, '商品库存管理', '/sku/**', 1, NULL, '2020-02-04 17:09:53', NULL, '2020-02-04 17:09:53');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, '订单管理', '/order/**', 2, NULL, '2020-02-05 14:43:37', NULL, '2020-02-05 14:43:37');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, '订单退货申请管理', '/returnApply/**', 2, NULL, '2020-02-05 14:44:22', NULL, '2020-02-05 14:44:22');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, '退货原因管理', '/returnReason/**', 2, NULL, '2020-02-05 14:45:08', NULL, '2020-02-05 14:45:08');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, '订单设置管理', '/orderSetting/**', 2, NULL, '2020-02-05 14:45:43', NULL, '2020-02-05 14:45:43');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, '收货地址管理', '/companyAddress/**', 2, NULL, '2020-02-05 14:46:23', NULL, '2020-02-05 14:46:23');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, '优惠券管理', '/coupon/**', 3, NULL, '2020-02-07 16:37:22', NULL, '2020-02-07 16:37:22');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, '优惠券领取记录管理', '/couponHistory/**', 3, NULL, '2020-02-07 16:37:59', NULL, '2020-02-07 16:37:59');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, '限时购活动管理', '/flash/**', 3, NULL, '2020-02-07 16:38:28', NULL, '2020-02-07 16:38:28');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, '限时购商品关系管理', '/flashProductRelation/**', 3, NULL, '2020-02-07 16:38:59', NULL, '2020-02-07 16:38:59');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, '限时购场次管理', '/flashSession/**', 3, NULL, '2020-02-07 16:39:22', NULL, '2020-02-07 16:39:22');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, '首页轮播广告管理', '/home/advertise/**', 3, NULL, '2020-02-07 16:40:07', NULL, '2020-02-07 16:40:07');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (19, '首页品牌管理', '/home/brand/**', 3, NULL, '2020-02-07 16:40:34', NULL, '2020-02-07 16:40:34');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (20, '首页新品管理', '/home/newProduct/**', 3, NULL, '2020-02-07 16:41:06', NULL, '2020-02-07 16:41:06');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (21, '首页人气推荐管理', '/home/recommendProduct/**', 3, NULL, '2020-02-07 16:42:16', NULL, '2020-02-07 16:42:16');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (22, '首页专题推荐管理', '/home/recommendSubject/**', 3, NULL, '2020-02-07 16:42:48', NULL, '2020-02-07 16:42:48');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (23, '商品优选管理', '/prefrenceArea/**', 5, NULL, '2020-02-07 16:44:56', NULL, '2020-02-07 16:44:56');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (24, '商品专题管理', '/subject/**', 5, NULL, '2020-02-07 16:45:39', NULL, '2020-02-07 16:45:39');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (25, '后台用户管理', '/admin/**', 4, NULL, '2020-02-07 16:47:34', NULL, '2020-02-07 16:47:34');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (26, '后台用户角色管理', '/role/**', 4, NULL, '2020-02-07 16:48:24', NULL, '2020-02-07 16:48:24');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (27, '后台菜单管理', '/menu/**', 4, NULL, '2020-02-07 16:48:48', NULL, '2020-02-07 16:48:48');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (28, '后台资源分类管理', '/resourceCategory/**', 4, NULL, '2020-02-07 16:49:18', NULL, '2020-02-07 16:49:18');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (29, '后台资源管理', '/resource/**', 4, NULL, '2020-02-07 16:49:45', NULL, '2020-02-07 16:49:45');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (30, '会员等级管理', '/memberLevel/**', 7, NULL, '2020-09-19 15:47:57', NULL, '2020-09-19 15:47:57');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (31, '获取登录用户信息', '/admin/info', 4, NULL, '2020-09-19 15:51:29', NULL, '2020-09-19 15:51:29');
INSERT INTO `resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (32, '用户登出', '/admin/logout', 4, NULL, '2020-09-19 15:53:34', NULL, '2020-09-19 15:53:34');

-- ----------------------------
-- 后台资源分类表
-- 在细粒度权限控制时，可能资源会比较多，所以设计了个资源分类的概念，便于给角色分配资源
-- ----------------------------
drop table if exists `resource_category`;
create table if not exists `resource_category` (
    id              bigint(20)      not null auto_increment     comment '分类ID',
    name            varchar(50)     not null                    comment '分类名称',
    sort            int(4)          not null                    comment '排序',
    create_by       bigint(20)      default null                comment '创建者',
    create_time     datetime        default current_timestamp   comment '创建时间',
    update_by       bigint(20)      default null                comment '更新者',
    update_time     datetime        default current_timestamp   comment '编辑时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment '后台资源分类表';

-- ----------------------------
-- 初始化-后台资源分类表数据
-- ----------------------------
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '商品模块', 0, NULL, '2020-02-05 10:21:44', NULL, '2020-02-05 10:21:44');
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '订单模块', 0, NULL, '2020-02-05 10:22:34', NULL, '2020-02-05 10:22:34');
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '营销模块', 0, NULL, '2020-02-05 10:22:48', NULL, '2020-02-05 10:22:48');
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '权限模块', 0, NULL, '2020-02-05 10:23:04', NULL, '2020-02-05 10:23:04');
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '内容模块', 0, NULL, '2020-02-07 16:34:27', NULL, '2020-02-07 16:34:27');
INSERT INTO `resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, '其他模块', 0, NULL, '2020-09-19 15:49:08', NULL, '2020-09-19 15:49:08');

-- ----------------------------
-- 角色资源关系表
-- ----------------------------
drop table if exists `role_resource`;
create table if not exists `role_resource` (
    role_id         bigint(20)      not null        comment '角色ID',
    resource_id     bigint(20)      not null        comment '资源ID',
    primary key (role_id, resource_id)
) engine = innodb comment '角色资源关联表';

-- ----------------------------
-- 初始化-角色资源关系表数据
-- ----------------------------
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 1);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 2);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 3);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 4);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 5);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 6);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 8);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 9);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 10);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 11);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 12);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 13);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 14);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 15);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 16);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 17);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 18);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 19);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 20);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 21);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 22);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 23);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 24);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 25);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 26);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 27);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 28);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 29);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (5, 30);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 8);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 9);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 10);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 11);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 12);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 31);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (2, 32);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 1);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 2);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 3);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 4);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 5);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 6);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 23);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 24);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 31);
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES (1, 32);

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
    problemset_id  bigint(20)    not null   comment '题库id',
    question_id    bigint(20)    not null   comment '题目id',
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
drop table if exists tag;
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
INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (100, '数组', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (101, '哈希表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (102, '链表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (103, '递归', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (104, 'SQL', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');

INSERT INTO tag (id, name, del_flag, create_by, create_time, update_by, update_time)
VALUES (105, '聚合', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');


-- ----------------------------
-- 题目和标签关联表
-- ----------------------------
drop table if exists tag_question;
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