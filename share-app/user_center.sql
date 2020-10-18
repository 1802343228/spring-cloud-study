/*
 Navicat Premium Data Transfer

 Source Server         : content
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/10/2020 15:51:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bonus_event_log
-- ----------------------------
DROP TABLE IF EXISTS `bonus_event_log`;
CREATE TABLE `bonus_event_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT 'user.id',
  `value` int(0) NULL DEFAULT NULL COMMENT '积分操作值',
  `event` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发生的事件',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_bonus_event_log_user1_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '积分变更记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bonus_event_log
-- ----------------------------
INSERT INTO `bonus_event_log` VALUES (1, 7, 20, '签到', '2020-10-13 22:40:56', '签到');
INSERT INTO `bonus_event_log` VALUES (2, 7, 20, '签到', '2020-10-14 00:43:27', '签到');
INSERT INTO `bonus_event_log` VALUES (3, 7, 120, '签到', '2020-10-14 00:43:38', '签到');
INSERT INTO `bonus_event_log` VALUES (4, 7, -2, '兑换', '2020-10-14 11:24:04', '兑换减积分');
INSERT INTO `bonus_event_log` VALUES (5, 7, -89, '兑换', '2020-10-15 02:24:28', '兑换减积分');
INSERT INTO `bonus_event_log` VALUES (7, 7, -30, '兑换', '2020-10-16 00:19:52', '兑换减积分');
INSERT INTO `bonus_event_log` VALUES (8, 7, -30, '兑换', '2020-10-16 00:42:11', '兑换减积分');
INSERT INTO `bonus_event_log` VALUES (9, 7, -30, '兑换', '2020-10-16 00:43:30', '兑换减积分');
INSERT INTO `bonus_event_log` VALUES (11, 7, 20, '签到', '2020-10-16 09:53:03', '签到加积分');
INSERT INTO `bonus_event_log` VALUES (12, 1, 20, '签到', '2020-10-16 09:55:59', '签到加积分');
INSERT INTO `bonus_event_log` VALUES (17, 7, 20, 'SIGN_IN', '2020-10-18 13:12:40', '签到加积分');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `wx_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信id',
  `wx_nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信昵称',
  `roles` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `bonus` int(0) NOT NULL DEFAULT 300 COMMENT '积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分享' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wxedc274aca2fb67b1', '陈蓉琪', '管理员', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/mqxu.jpg', '2020-10-13 17:43:37', '2020-10-13 17:43:40', 820);
INSERT INTO `user` VALUES (2, 'mqxu', 'mob', '普通用户', 'https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/8.jpg', '2020-10-13 17:45:20', '2020-10-13 17:45:23', 200);
INSERT INTO `user` VALUES (3, '1111', 'mob', 'user', '1', '2020-10-12 13:56:22', '2020-10-12 13:56:22', 100);
INSERT INTO `user` VALUES (4, 'wxedc274aca2fb67b1', '111', 'user', '1', '2020-10-13 16:30:27', '2020-10-13 16:30:27', 100);
INSERT INTO `user` VALUES (5, 'wxedc274aca2fb67b', 'demoData', 'user', 'demoData', '2020-10-13 20:48:43', '2020-10-13 20:48:43', 100);
INSERT INTO `user` VALUES (6, '1', 'demoData', 'user', 'demoData', '2020-10-13 20:49:55', '2020-10-13 20:49:55', 100);
INSERT INTO `user` VALUES (7, 'o3xA542rgEFCMe4ZB_jpjv1dC2kI', '', 'user', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q79HDNx5mGqM7yGuxbDI2lNFtu0QakosbVEzUW7OScJqHDUA9dicKARibzAKaVOQ8M6BuoHBdRMA8BObdryptzRA/132', '2020-10-14 00:26:15', '2020-10-14 00:26:15', 344);

SET FOREIGN_KEY_CHECKS = 1;
