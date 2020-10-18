/*
 Navicat Premium Data Transfer

 Source Server         : content
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : content_center

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/10/2020 15:52:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mid_user_share
-- ----------------------------
DROP TABLE IF EXISTS `mid_user_share`;
CREATE TABLE `mid_user_share`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `share_id` int(0) NOT NULL COMMENT 'share.id',
  `user_id` int(0) NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_mid_user_share_share1_idx`(`share_id`) USING BTREE,
  INDEX `fk_mid_user_share_user1_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-分享中间表【描述用户购买的分享】' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mid_user_share
-- ----------------------------
INSERT INTO `mid_user_share` VALUES (1, 1, 1);
INSERT INTO `mid_user_share` VALUES (2, 3, 7);
INSERT INTO `mid_user_share` VALUES (3, 1, 7);
INSERT INTO `mid_user_share` VALUES (4, 2, 7);
INSERT INTO `mid_user_share` VALUES (5, 4, 7);
INSERT INTO `mid_user_share` VALUES (6, 5, 7);
INSERT INTO `mid_user_share` VALUES (7, 6, 7);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '关注你我之书，发现更多精彩', 1, '2020-09-29 12:36:49');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) NOT NULL DEFAULT 0 COMMENT '发布人id',
  `title` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  `is_original` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否原创 0:否 1:是',
  `author` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者',
  `cover` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '封面',
  `summary` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '概要信息',
  `price` int(0) NOT NULL DEFAULT 0 COMMENT '价格（需要的积分）',
  `download_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '下载地址',
  `buy_count` int(0) NOT NULL DEFAULT 0 COMMENT '下载数 ',
  `show_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `audit_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `reason` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分享表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES (1, 7, '微服务技术', '2020-09-29 12:35:16', '2020-09-29 12:35:20', 1, '陈蓉琪', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'Spring Cloud从入门到精通', 89, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn\n--来自百度网盘超级会员V1的分享', 30, 1, 'PASSED', '通过');
INSERT INTO `share` VALUES (2, 7, 'SpringBoot', '2020-09-29 16:14:21', '2020-09-29 16:14:24', 0, 'mob', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'SpringBoot实践', 77, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn\n--来自百度网盘超级会员V1的分享', 20, 1, 'PASSED', '通过');
INSERT INTO `share` VALUES (3, 7, 'SpringCloud', '2020-10-14 00:28:22', '2020-10-14 00:28:25', 0, 'ccc', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'SpringCloud实践', 2, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn\n--来自百度网盘超级会员V1的分享', 2, 1, 'PASSED', '通过');
INSERT INTO `share` VALUES (4, 7, 'Docker', '2020-10-15 23:49:48', '2020-10-15 23:49:48', 1, '撒野', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'Docker开源书，涵盖Docker常用命令', 30, 'https://book.douban.com/subject/26285268/', 20, 0, 'PASSED', '无');
INSERT INTO `share` VALUES (5, 7, 'Docker', '2020-10-16 00:41:43', '2020-10-16 00:41:43', 1, '撒野', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'Docker开源书，涵盖Docker常用命令', 30, 'https://book.douban.com/subject/26285268/', 20, 0, 'NOT_YET', '无');
INSERT INTO `share` VALUES (6, 1, 'Docker', '2020-10-16 00:43:20', '2020-10-16 00:43:20', 1, '撒野', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'Docker开源书，涵盖Docker常用命令', 30, 'https://book.douban.com/subject/26285268/', 20, 0, 'NOT_YET', '无');
INSERT INTO `share` VALUES (7, 7, 'gateway', '2020-10-18 13:06:38', '2020-10-18 13:06:38', 1, 'crq', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'API', 20, '无', 20, 0, 'NOT_YET', '无');
INSERT INTO `share` VALUES (8, 7, 'gateway', '2020-10-18 13:09:12', '2020-10-18 13:09:12', 1, 'crq', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', '1', 20, '1', 20, 0, 'NOT_YET', '无');
INSERT INTO `share` VALUES (9, 7, 'API网关', '2020-10-18 13:13:51', '2020-10-18 13:13:51', 1, 'crq', 'https://i2.wp.com/e4developer.com/wp-content/uploads/2018/01/spring-cloud-logo.png?resize=800%2C753&ssl=1', 'gateway', 20, '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn --来自百度网盘超级会员V1的分享', 20, 0, 'PASSED', '无');

SET FOREIGN_KEY_CHECKS = 1;
