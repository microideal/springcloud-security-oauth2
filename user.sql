/*
 Navicat Premium Data Transfer

 Source Server         : microideal
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : springcloud

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 15/10/2018 20:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11adsada', 'microideal', '$2a$10$S1d8RuS.hFEKKZ3l45UBSOdjDcA.Kg3RR5OzP.2tY70BiTVodSARC', 'admin');
INSERT INTO `user` VALUES ('212qdadadsad', 'hujun', '123456', 'super');
INSERT INTO `user` VALUES ('40288188637ca6e201637cb4561e0002', 'test', 'test', 'microideal');
INSERT INTO `user` VALUES ('4028818863ac34cc0163ac35ec060000', '123456789', '123456789', 'hujun');
INSERT INTO `user` VALUES ('4028818863ac34cc0163ac36cd140001', '0123456789', '123456', 'student');

SET FOREIGN_KEY_CHECKS = 1;
