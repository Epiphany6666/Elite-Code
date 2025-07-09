/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : elite-code

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 09/07/2025 22:36:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member_user
-- ----------------------------
DROP TABLE IF EXISTS `member_user`;
CREATE TABLE `member_user` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员ID',
                               `mobile` varchar(11) NOT NULL COMMENT '手机号',
                               `password` varchar(512) NOT NULL COMMENT '密码',
                               `nick_name` varchar(30) DEFAULT NULL COMMENT '用户昵称',
                               `avatar` varchar(512) DEFAULT NULL COMMENT '会员头像',
                               `sex` char(1) DEFAULT NULL COMMENT '会员性别',
                               `create_by` bigint DEFAULT NULL COMMENT '创建者',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新者',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员信息表';

-- ----------------------------
-- Records of member_user
-- ----------------------------
BEGIN;
INSERT INTO `member_user` (`id`, `mobile`, `password`, `nick_name`, `avatar`, `sex`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '13800138000', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '张三', 'http://localhost:9090/elitecode/20250603/83e7e9c3d49748d289899f3fb105e4e8.jpg', '1', 1, '2024-12-01 10:00:00', 1, '2025-07-09 17:30:13');
INSERT INTO `member_user` (`id`, `mobile`, `password`, `nick_name`, `avatar`, `sex`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '13912345678', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '李四', 'http://localhost:9090/elitecode/20250603/83e7e9c3d49748d289899f3fb105e4e8.jpg', '0', 1, '2024-12-05 11:30:00', 1, '2024-12-05 11:30:00');
INSERT INTO `member_user` (`id`, `mobile`, `password`, `nick_name`, `avatar`, `sex`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, '13012345678', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '王五', 'http://localhost:9090/elitecode/20250603/83e7e9c3d49748d289899f3fb105e4e8.jpg', '1', 1, '2024-12-10 14:45:00', 1, '2024-12-10 14:45:00');
COMMIT;

-- ----------------------------
-- Table structure for resume_problemset
-- ----------------------------
DROP TABLE IF EXISTS `resume_problemset`;
CREATE TABLE `resume_problemset` (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
                                     `title` varchar(256) NOT NULL COMMENT '标题',
                                     `description` text COMMENT '描述',
                                     `picture` varchar(2048) DEFAULT NULL COMMENT '图片',
                                     `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                                     `create_by` bigint DEFAULT NULL COMMENT '创建者',
                                     `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_by` bigint DEFAULT NULL COMMENT '更新者',
                                     `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题库表';

-- ----------------------------
-- Records of resume_problemset
-- ----------------------------
BEGIN;
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '力扣经典题库', '精选力扣热门题目，覆盖算法、数据结构', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '0', 1, '2025-04-07 16:18:00', NULL, '2025-04-07 16:18:00');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '大厂面试真题', '腾讯、阿里、字节等大厂高频考题', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '0', 1, '2025-04-07 16:18:00', NULL, '2025-04-07 16:18:00');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, 'SQL必知必会', '数据库查询与优化实战练习', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '0', 1, '2025-04-07 16:18:00', NULL, '2025-04-07 16:18:00');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 'test', 'xiugai', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '2', NULL, '2025-04-09 09:35:29', 1, '2025-04-09 09:35:29');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, 'test', 'descriptiontest', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '2', NULL, '2025-04-09 09:36:33', NULL, '2025-04-09 09:36:33');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, 'test', 'descriptiontest', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '2', 1, '2025-04-09 09:39:37', NULL, '2025-04-09 09:39:37');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, '3213', 'descriptiontest', NULL, '2', 1, '2025-07-09 20:58:25', 1, '2025-07-09 20:58:25');
INSERT INTO `resume_problemset` (`id`, `title`, `description`, `picture`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, 'test', 'descriptiontest', NULL, '0', 1, '2025-07-09 21:24:06', NULL, '2025-07-09 21:24:06');
COMMIT;

-- ----------------------------
-- Table structure for resume_problemset_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `resume_problemset_question_relation`;
CREATE TABLE `resume_problemset_question_relation` (
                                                       `problemset_id` bigint NOT NULL COMMENT '题库id',
                                                       `question_id` bigint NOT NULL COMMENT '题目id',
                                                       PRIMARY KEY (`problemset_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题目与题库关联表';

-- ----------------------------
-- Records of resume_problemset_question_relation
-- ----------------------------
BEGIN;
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (100, 100);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (100, 101);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (100, 112);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (100, 114);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (101, 100);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (101, 114);
INSERT INTO `resume_problemset_question_relation` (`problemset_id`, `question_id`) VALUES (102, 102);
COMMIT;

-- ----------------------------
-- Table structure for resume_question
-- ----------------------------
DROP TABLE IF EXISTS `resume_question`;
CREATE TABLE `resume_question` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
                                   `title` varchar(256) NOT NULL COMMENT '标题',
                                   `content` text COMMENT '内容',
                                   `answer` text COMMENT '推荐答案',
                                   `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                                   `create_by` bigint DEFAULT NULL COMMENT '创建者',
                                   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_by` bigint DEFAULT NULL COMMENT '更新者',
                                   `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题目表';

-- ----------------------------
-- Records of resume_question
-- ----------------------------
BEGIN;
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '两数之和', '给定一个整数数组 nums 和一个目标值 target...', '使用哈希表存储遍历过的数字，时间复杂度O(n)', '0', 1, '2025-04-07 16:18:01', NULL, '2025-04-07 16:18:01');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '反转链表', '定义一个函数，输入一个链表的头节点...', '迭代或递归实现，注意指针操作', '0', 1, '2025-04-07 16:18:01', NULL, '2025-04-07 16:18:01');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, '统计订单数量', '编写SQL查询，返回每个客户的订单总数...', 'SELECT customer_id, COUNT(*) FROM orders GROUP BY customer_id', '0', 1, '2025-04-07 16:18:01', NULL, '2025-04-07 16:18:01');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 'test1', '1111', '211', '2', NULL, '2025-04-07 17:30:40', NULL, '2025-04-07 17:30:40');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, 'test1', '1111', '11111', '2', NULL, '2025-04-07 17:32:24', NULL, '2025-04-07 17:32:24');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, 'test1', '1111', '11111', '0', 2, '2025-04-07 17:33:20', NULL, '2025-04-07 17:33:20');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, 'add_question_test', 'add_question_content', 'add_question', '0', 1, '2025-04-10 15:55:13', NULL, '2025-04-10 15:55:13');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, 'add_question_test', 'add_question_content', 'add_question', '0', 1, '2025-04-10 15:56:26', NULL, '2025-04-10 15:56:26');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (108, 'add_question_test', 'add_question_content', 'add_question', '0', 1, '2025-04-10 16:00:44', NULL, '2025-04-10 16:00:44');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (109, 'add_question_test', 'add_question_content', 'add_question', '0', 1, '2025-04-10 16:01:50', NULL, '2025-04-10 16:01:50');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (110, 'add_question_test', 'add_question_content', 'add_question', '0', 2, '2025-04-10 16:02:00', NULL, '2025-04-10 16:02:00');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (111, 'add_question_test', 'add_question_content', 'add_question', '2', 1, '2025-04-10 16:04:30', 1, '2025-04-10 16:04:30');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (112, '爬楼梯', '假设你正在爬楼梯。需要 `n` 阶你才能到达楼顶。\n\n每次你可以爬 `1` 或 `2` 个台阶。你有多少种不同的方法可以爬到楼顶呢？\n\n**示例 1：**\n\n```\n输入：n = 2\n输出：2\n解释：有两种方法可以爬到楼顶。\n1. 1 阶 + 1 阶\n2. 2 阶\n```\n\n**示例 2：**\n\n```\n输入：n = 3\n输出：3\n解释：有三种方法可以爬到楼顶。\n1. 1 阶 + 1 阶 + 1 阶\n2. 1 阶 + 2 阶\n3. 2 阶 + 1 阶\n```\n\n**提示：**\n\n- `1 <= n <= 45`', NULL, '0', NULL, '2025-04-11 21:47:05', NULL, '2025-04-11 21:47:05');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (113, 'add_question_test', 'add_question_content', 'add_question', '2', 1, '2025-07-09 21:16:56', 1, '2025-07-09 21:16:56');
INSERT INTO `resume_question` (`id`, `title`, `content`, `answer`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (114, 'add_question_test', 'add_question_content', 'add_question', '0', 1, '2025-07-09 21:23:47', NULL, '2025-07-09 21:23:47');
COMMIT;

-- ----------------------------
-- Table structure for resume_tag
-- ----------------------------
DROP TABLE IF EXISTS `resume_tag`;
CREATE TABLE `resume_tag` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '标签ID，主键',
                              `name` varchar(50) NOT NULL COMMENT '标签名',
                              `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                              `create_by` bigint DEFAULT NULL COMMENT '创建者',
                              `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_by` bigint DEFAULT NULL COMMENT '更新者',
                              `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题目标签表';

-- ----------------------------
-- Records of resume_tag
-- ----------------------------
BEGIN;
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '数组', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '哈希表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, '链表', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, '递归', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, 'SQL', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, '聚合', '0', 1, '2024-11-22 08:36:41', NULL, '2024-11-22 08:36:41');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, 'test', '2', 1, '2025-04-15 11:53:07', NULL, '2025-04-15 11:53:07');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, 'update', '2', 1, '2025-04-15 12:07:28', 1, '2025-04-15 12:07:28');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (108, 'test1', '0', 1, '2025-04-16 17:04:30', NULL, '2025-04-16 17:04:30');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (109, 'test2', '0', 1, '2025-04-16 17:04:34', NULL, '2025-04-16 17:04:34');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (110, 'test3', '0', 1, '2025-04-16 17:04:37', NULL, '2025-04-16 17:04:37');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (111, '999', '2', 1, '2025-07-09 21:18:02', 1, '2025-07-09 21:18:02');
INSERT INTO `resume_tag` (`id`, `name`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (112, '222', '0', 1, '2025-07-09 21:24:24', NULL, '2025-07-09 21:24:24');
COMMIT;

-- ----------------------------
-- Table structure for resume_tag_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `resume_tag_question_relation`;
CREATE TABLE `resume_tag_question_relation` (
                                                `question_id` bigint NOT NULL COMMENT '题目ID（外键，关联题目表ID）',
                                                `tag_id` bigint NOT NULL COMMENT '标签ID（外键，关联标签表ID）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='题目和标签关联表';

-- ----------------------------
-- Records of resume_tag_question_relation
-- ----------------------------
BEGIN;
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (100, 100);
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (100, 101);
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (101, 102);
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (101, 103);
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (102, 104);
INSERT INTO `resume_tag_question_relation` (`question_id`, `tag_id`) VALUES (102, 105);
COMMIT;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单id，主键',
                               `title` varchar(50) NOT NULL COMMENT '菜单标题',
                               `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
                               `sort` int NOT NULL COMMENT '显示顺序',
                               `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
                               `if_frame` int DEFAULT '1' COMMENT '是否为外链 (0是 1否)',
                               `type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
                               `visible` char(1) DEFAULT '' COMMENT '菜单状态（0显示 1隐藏）',
                               `status` char(1) DEFAULT '0' COMMENT '菜单状态 (0正常 1停用)',
                               `create_by` bigint DEFAULT NULL COMMENT '创建者',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新者',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单权限表';

-- ----------------------------
-- Records of system_menu
-- ----------------------------
BEGIN;
INSERT INTO `system_menu` (`id`, `title`, `parent_id`, `sort`, `component`, `if_frame`, `type`, `visible`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '系统', 0, 0, '/system', 1, 'C', '0', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_menu` (`id`, `title`, `parent_id`, `sort`, `component`, `if_frame`, `type`, `visible`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '用户', 100, 2, '/user', 1, 'C', '0', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_menu` (`id`, `title`, `parent_id`, `sort`, `component`, `if_frame`, `type`, `visible`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 'addTest', 0, 0, NULL, 0, '', '', '0', NULL, '2025-05-24 16:48:21', NULL, '2025-05-24 16:48:21');
INSERT INTO `system_menu` (`id`, `title`, `parent_id`, `sort`, `component`, `if_frame`, `type`, `visible`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, 'addTest', 0, 0, NULL, 0, '', '', '0', NULL, '2025-05-24 17:26:58', NULL, '2025-05-24 17:26:58');
COMMIT;

-- ----------------------------
-- Table structure for system_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE `system_resource` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '资源ID',
                                   `name` varchar(50) NOT NULL COMMENT '资源名称',
                                   `url` varchar(200) NOT NULL COMMENT '资源URL',
                                   `category_id` bigint NOT NULL COMMENT '分类ID',
                                   `create_by` bigint DEFAULT NULL COMMENT '创建者',
                                   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_by` bigint DEFAULT NULL COMMENT '更新者',
                                   `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='后台资源表';

-- ----------------------------
-- Records of system_resource
-- ----------------------------
BEGIN;
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '商品品牌管理', '/brand/**', 1, NULL, '2020-02-04 17:04:55', NULL, '2020-02-04 17:04:55');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '商品属性分类管理', '/productAttribute/category/**', 1, NULL, '2020-02-04 17:05:35', NULL, '2020-02-04 17:05:35');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '商品属性管理', '/productAttribute/**', 1, NULL, '2020-02-04 17:06:13', NULL, '2020-02-04 17:06:13');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '商品分类管理', '/productCategory/**', 1, NULL, '2020-02-04 17:07:15', NULL, '2020-02-04 17:07:15');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '商品管理', '/product/**', 1, NULL, '2020-02-04 17:09:16', NULL, '2020-02-04 17:09:16');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, '商品库存管理', '/sku/**', 1, NULL, '2020-02-04 17:09:53', NULL, '2020-02-04 17:09:53');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, '订单管理', '/order/**', 2, NULL, '2020-02-05 14:43:37', NULL, '2020-02-05 14:43:37');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, '订单退货申请管理', '/returnApply/**', 2, NULL, '2020-02-05 14:44:22', NULL, '2020-02-05 14:44:22');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, '退货原因管理', '/returnReason/**', 2, NULL, '2020-02-05 14:45:08', NULL, '2020-02-05 14:45:08');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, '订单设置管理', '/orderSetting/**', 2, NULL, '2020-02-05 14:45:43', NULL, '2020-02-05 14:45:43');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, '收货地址管理', '/companyAddress/**', 2, NULL, '2020-02-05 14:46:23', NULL, '2020-02-05 14:46:23');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, '优惠券管理', '/coupon/**', 3, NULL, '2020-02-07 16:37:22', NULL, '2020-02-07 16:37:22');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, '优惠券领取记录管理', '/couponHistory/**', 3, NULL, '2020-02-07 16:37:59', NULL, '2020-02-07 16:37:59');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, '限时购活动管理', '/flash/**', 3, NULL, '2020-02-07 16:38:28', NULL, '2020-02-07 16:38:28');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, '限时购商品关系管理', '/flashProductRelation/**', 3, NULL, '2020-02-07 16:38:59', NULL, '2020-02-07 16:38:59');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, '限时购场次管理', '/flashSession/**', 3, NULL, '2020-02-07 16:39:22', NULL, '2020-02-07 16:39:22');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, '首页轮播广告管理', '/home/advertise/**', 3, NULL, '2020-02-07 16:40:07', NULL, '2020-02-07 16:40:07');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (19, '首页品牌管理', '/home/brand/**', 3, NULL, '2020-02-07 16:40:34', NULL, '2020-02-07 16:40:34');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (20, '首页新品管理', '/home/newProduct/**', 3, NULL, '2020-02-07 16:41:06', NULL, '2020-02-07 16:41:06');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (21, '首页人气推荐管理', '/home/recommendProduct/**', 3, NULL, '2020-02-07 16:42:16', NULL, '2020-02-07 16:42:16');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (22, '首页专题推荐管理', '/home/recommendSubject/**', 3, NULL, '2020-02-07 16:42:48', NULL, '2020-02-07 16:42:48');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (23, '商品优选管理', '/prefrenceArea/**', 5, NULL, '2020-02-07 16:44:56', NULL, '2020-02-07 16:44:56');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (24, '商品专题管理', '/subject/**', 5, NULL, '2020-02-07 16:45:39', NULL, '2020-02-07 16:45:39');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (25, '后台用户管理', '/admin/**', 4, NULL, '2020-02-07 16:47:34', NULL, '2020-02-07 16:47:34');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (26, '后台用户角色管理', '/role/**', 4, NULL, '2020-02-07 16:48:24', NULL, '2020-02-07 16:48:24');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (27, '后台菜单管理', '/menu/**', 4, NULL, '2020-02-07 16:48:48', NULL, '2020-02-07 16:48:48');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (28, '后台资源分类管理', '/resourceCategory/**', 4, NULL, '2020-02-07 16:49:18', NULL, '2020-02-07 16:49:18');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (29, '后台资源管理', '/resource/**', 4, NULL, '2020-02-07 16:49:45', NULL, '2020-02-07 16:49:45');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (30, '会员等级管理', '/memberLevel/**', 7, NULL, '2020-09-19 15:47:57', NULL, '2020-09-19 15:47:57');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (31, '获取登录用户信息', '/admin/info', 4, NULL, '2020-09-19 15:51:29', NULL, '2020-09-19 15:51:29');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (32, '用户登出', '/admin/logout', 4, NULL, '2020-09-19 15:53:34', NULL, '2020-09-19 15:53:34');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '22', '33', 1, 1, '2025-05-13 20:36:21', 1, '2025-05-13 20:36:21');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, '11', '111', 1, 1, '2025-05-14 17:07:40', NULL, '2025-05-14 17:07:40');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, '11', '111', 1, 1, '2025-05-14 17:08:34', NULL, '2025-05-14 17:08:34');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 'getInfo', '/getInfo', 4, 1, '2025-05-25 20:36:23', NULL, '2025-05-25 20:36:23');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, '题库管理', '/problemset/**', 4, NULL, '2025-06-01 16:28:55', NULL, '2025-06-01 16:28:55');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, '后台资源分类管理', '/resourceCategory/**', 4, NULL, '2025-06-01 16:35:48', NULL, '2025-06-01 16:35:48');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, '标签管理', '/tag/**', 4, NULL, '2025-06-01 16:42:24', NULL, '2025-06-01 16:42:24');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, 'minio管理', '/minio/**', 4, NULL, '2025-06-02 21:24:09', NULL, '2025-06-02 21:24:09');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (108, '获取个人信息', '/getInfo', 4, 1, '2025-07-09 17:00:21', NULL, '2025-07-09 17:00:21');
INSERT INTO `system_resource` (`id`, `name`, `url`, `category_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (109, '所有', '/**', 4, NULL, '2025-07-09 17:17:38', NULL, '2025-07-09 17:17:38');
COMMIT;

-- ----------------------------
-- Table structure for system_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `system_resource_category`;
CREATE TABLE `system_resource_category` (
                                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类ID',
                                            `name` varchar(50) NOT NULL COMMENT '分类名称',
                                            `sort` int NOT NULL COMMENT '排序',
                                            `create_by` bigint DEFAULT NULL COMMENT '创建者',
                                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `update_by` bigint DEFAULT NULL COMMENT '更新者',
                                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='后台资源分类表';

-- ----------------------------
-- Records of system_resource_category
-- ----------------------------
BEGIN;
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '商品模块', 0, NULL, '2020-02-05 10:21:44', NULL, '2020-02-05 10:21:44');
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '订单模块', 0, NULL, '2020-02-05 10:22:34', NULL, '2020-02-05 10:22:34');
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '营销模块', 0, NULL, '2020-02-05 10:22:48', NULL, '2020-02-05 10:22:48');
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '权限模块', 0, NULL, '2020-02-05 10:23:04', NULL, '2020-02-05 10:23:04');
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '内容模块', 0, NULL, '2020-02-07 16:34:27', NULL, '2020-02-07 16:34:27');
INSERT INTO `system_resource_category` (`id`, `name`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, '其他模块', 0, NULL, '2020-09-19 15:49:08', NULL, '2020-09-19 15:49:08');
COMMIT;

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID，主键',
                               `name` varchar(30) NOT NULL COMMENT '角色名称',
                               `sort` int NOT NULL COMMENT '显示顺序',
                               `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联',
                               `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                               `create_by` bigint DEFAULT NULL COMMENT '创建者',
                               `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新者',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';

-- ----------------------------
-- Records of system_role
-- ----------------------------
BEGIN;
INSERT INTO `system_role` (`id`, `name`, `sort`, `menu_check_strictly`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'admin', 1, 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_role` (`id`, `name`, `sort`, `menu_check_strictly`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 'user', 2, 1, '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_role` (`id`, `name`, `sort`, `menu_check_strictly`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, '333', 0, 0, '0', 1, '2025-07-09 17:30:26', 1, '2025-07-09 17:30:26');
COMMIT;

-- ----------------------------
-- Table structure for system_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu_relation`;
CREATE TABLE `system_role_menu_relation` (
                                             `role_id` bigint NOT NULL COMMENT '角色ID',
                                             `menu_id` bigint NOT NULL COMMENT '菜单ID',
                                             PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of system_role_menu_relation
-- ----------------------------
BEGIN;
INSERT INTO `system_role_menu_relation` (`role_id`, `menu_id`) VALUES (1, 100);
INSERT INTO `system_role_menu_relation` (`role_id`, `menu_id`) VALUES (1, 101);
INSERT INTO `system_role_menu_relation` (`role_id`, `menu_id`) VALUES (2, 101);
INSERT INTO `system_role_menu_relation` (`role_id`, `menu_id`) VALUES (100, 103);
COMMIT;

-- ----------------------------
-- Table structure for system_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `system_role_resource_relation`;
CREATE TABLE `system_role_resource_relation` (
                                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                                 `resource_id` bigint NOT NULL COMMENT '资源ID',
                                                 PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色资源关联表';

-- ----------------------------
-- Records of system_role_resource_relation
-- ----------------------------
BEGIN;
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 1);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 2);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 3);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 4);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 5);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 6);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 23);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 24);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 27);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 31);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 32);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 103);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 104);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 105);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 106);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 107);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 108);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (1, 109);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 8);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 9);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 10);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 11);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 12);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 31);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (2, 32);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 1);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 2);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 3);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 4);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 5);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 6);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 8);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 9);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 10);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 11);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 12);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 13);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 14);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 15);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 16);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 17);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 18);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 19);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 20);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 21);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 22);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 23);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 24);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 25);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 26);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 27);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 28);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 29);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (5, 30);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 1);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 2);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 3);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 4);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 5);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 6);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 23);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 24);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 31);
INSERT INTO `system_role_resource_relation` (`role_id`, `resource_id`) VALUES (100, 32);
COMMIT;

-- ----------------------------
-- Table structure for system_user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `system_user_login_info`;
CREATE TABLE `system_user_login_info` (
                                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
                                          `username` varchar(50) DEFAULT NULL COMMENT '用户账号',
                                          `ip` varchar(128) DEFAULT NULL COMMENT '登录IP地址',
                                          `address` varchar(100) DEFAULT NULL COMMENT '登陆地点',
                                          `browser` varchar(50) DEFAULT NULL COMMENT '浏览器类型',
                                          `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
                                          `status` char(1) DEFAULT '0' COMMENT '登录状态 (0成功 1失败)',
                                          `msg` varchar(255) DEFAULT NULL COMMENT '提示消息',
                                          `login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统访问记录';

-- ----------------------------
-- Records of system_user_login_info
-- ----------------------------
BEGIN;
INSERT INTO `system_user_login_info` (`id`, `username`, `ip`, `address`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (100, 'luoyan', '192.168.1.101', '上海', 'Chrome', 'Windows 10', '0', '登录成功', '2024-11-22 09:00:00');
INSERT INTO `system_user_login_info` (`id`, `username`, `ip`, `address`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (101, 'testuser', '192.168.1.102', '北京', 'Firefox', 'MacOS', '1', '密码错误', '2024-11-22 09:05:00');
INSERT INTO `system_user_login_info` (`id`, `username`, `ip`, `address`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (102, 'luoyantst', '192.168.1.103', '广州', 'Edge', 'Windows 11', '0', '登录成功', '2024-12-06 08:15:00');
INSERT INTO `system_user_login_info` (`id`, `username`, `ip`, `address`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (103, 'luoyantest1', '192.168.1.104', '深圳', 'Safari', 'iOS', '0', '登录成功', '2024-12-06 17:20:00');
INSERT INTO `system_user_login_info` (`id`, `username`, `ip`, `address`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (104, 'luoyantest3', '192.168.1.105', '杭州', 'Chrome', 'Android', '1', '账户被锁定', '2024-12-08 23:30:00');
COMMIT;

-- ----------------------------
-- Table structure for system_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role_relation`;
CREATE TABLE `system_user_role_relation` (
                                             `user_id` bigint NOT NULL COMMENT '用户ID',
                                             `role_id` bigint NOT NULL COMMENT '角色ID',
                                             PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of system_user_role_relation
-- ----------------------------
BEGIN;
INSERT INTO `system_user_role_relation` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `system_user_role_relation` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `system_user_role_relation` (`user_id`, `role_id`) VALUES (112, 1);
COMMIT;

-- ----------------------------
-- Table structure for system_users
-- ----------------------------
DROP TABLE IF EXISTS `system_users`;
CREATE TABLE `system_users` (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                                `username` varchar(256) NOT NULL COMMENT '账号',
                                `password` varchar(512) NOT NULL COMMENT '密码',
                                `nick_name` varchar(256) DEFAULT NULL COMMENT '用户昵称',
                                `avatar` varchar(1024) DEFAULT NULL COMMENT '用户头像',
                                `profile` varchar(512) DEFAULT NULL COMMENT '用户简介',
                                `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在，2代表删除）',
                                `create_by` bigint DEFAULT NULL COMMENT '创建者',
                                `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_by` bigint DEFAULT NULL COMMENT '更新者',
                                `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of system_users
-- ----------------------------
BEGIN;
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'luoyan', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'www1', 'http://111.230.63.162:9090/elitecode/20250602/91b7cbd957e046c2bb6e5033ee9ebdec.jpg', '系统管理员', '0', 1, '2024-11-22 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 'testuser', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', '测试用户', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '测试人员', '0', 1, '2024-11-27 08:36:41', 1, '2024-11-27 08:36:41');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, 'luoyantst', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantst', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-06 08:10:43', 1, '2024-12-06 08:10:43');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, 'luoyantest', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-06 16:49:27', 1, '2024-12-06 16:49:27');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, 'luoyantest1', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest1', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-06 17:13:38', 1, '2024-12-06 17:13:38');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 'luoyantest2', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest2', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-06 19:58:42', 1, '2024-12-06 19:58:42');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, 'luoyantest4', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest4', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-08 23:12:54', 1, '2024-12-08 23:12:54');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, 'luoyantest3', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', 'luoyantest3', 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', '', '0', 1, '2024-12-08 23:22:03', 1, '2024-12-08 23:22:03');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, '2123', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', NULL, '0', NULL, '2025-01-02 14:04:29', NULL, '2025-01-02 14:04:29');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (108, '21321312', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', NULL, '0', NULL, '2025-02-26 09:16:26', NULL, '2025-02-26 09:16:26');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (109, '341341', '$2a$10$QRahICxJnpkrbd9HAQ/hCumW2/F2fVvJYhPpJcWGHMipkKbFwHdI2', NULL, 'https://luo-shang-yan.oss-cn-guangzhou.aliyuncs.com/%E6%9F%AF%E5%8D%97.jpg', NULL, '2', NULL, '2025-02-26 09:20:45', NULL, '2025-02-26 09:20:45');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (110, 'addUserRoleTest1', '$2a$10$oBeVK5vO0K.M5YKxx91VSu1whS2Cfe4o7cs7z5vGDGJlQ4SFu4WgG', NULL, NULL, NULL, '2', NULL, '2025-04-23 22:51:47', NULL, '2025-04-23 22:51:47');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (111, 'addUserRoleTest2', '$2a$10$VbB.syLGRjm1jICwegk8buIoeyM03HJeickptntBrLYxaFagphfI6', NULL, NULL, NULL, '0', NULL, '2025-04-23 22:56:41', NULL, '2025-04-23 22:56:41');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (112, 'addUserRoleTest3', '$2a$10$HcgUfQ1Mz25PAOc8Z4Ol6ekPEksZLm.b7Vjoqmqkl9OKluzTgOTMa', NULL, NULL, NULL, '0', NULL, '2025-04-23 22:57:42', NULL, '2025-04-23 22:57:42');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (113, '453153', '$2a$10$.k99vUf/XgYxzocs.JOksO6XMf6Hm3/6ecadNbhQG8hHbHWNCPG7S', NULL, NULL, NULL, '0', NULL, '2025-07-09 17:23:43', NULL, '2025-07-09 17:23:43');
INSERT INTO `system_users` (`id`, `username`, `password`, `nick_name`, `avatar`, `profile`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (114, 'addUserRoleTest4', '$2a$10$8ulSP.FhVQ4UMg5VdCvD1O/CZNuPHZJIT698.0YIf7IUttTKmP5qe', NULL, '11', NULL, '2', 1, '2025-07-09 17:32:19', 1, '2025-07-09 17:32:19');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
