/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : xzshop

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 23/06/2024 02:55:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for keeper
-- ----------------------------
DROP TABLE IF EXISTS `keeper`;
CREATE TABLE `keeper`  (
  `keeper_id` int(11) NOT NULL AUTO_INCREMENT,
  `keeper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`keeper_id`) USING BTREE,
  UNIQUE INDEX `keeper_name`(`keeper_name`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of keeper
-- ----------------------------
INSERT INTO `keeper` VALUES (1, '小仲购物', '111', '131544846142', '18946975729@qq.com', 1);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `destination` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (47, 8, '2024-06-22T21:42:37.465', '2024-06-23T00:47:43.647', '广州市海珠区仲恺农业工程学院东沙街24号', '已接单,订单完成');
INSERT INTO `order` VALUES (48, 9, '2024-06-22T21:42:37.465', '2024-06-23T01:33:15.576', '广州市海珠区仲恺农业工程学院东沙街24号', '已接单,订单完成');
INSERT INTO `order` VALUES (49, 8, '2024-06-23T01:51:33.469', '2024-06-23T02:32:13.895', '广州市海珠区仲恺农业工程学院东沙街24号', '已接单,订单完成');
INSERT INTO `order` VALUES (50, 8, '2024-06-23T01:51:52.456', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (51, 8, '2024-06-23T01:57:37.908', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (52, 8, '2024-06-23T01:58:29.335', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (53, 8, '2024-06-23T01:59:27.019', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (54, 8, '2024-06-23T02:00:19.541', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (55, 8, '2024-06-23T02:02:35.388', '2024-06-23T02:47:57.538', '广州市海珠区仲恺农业工程学院东沙街24号', '商家已拒单');
INSERT INTO `order` VALUES (56, 10, '2024-06-23T02:44:47.463', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '商家已拒单');
INSERT INTO `order` VALUES (57, 10, '2024-06-23T02:44:49.961', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (58, 10, '2024-06-23T02:45:03.654', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');
INSERT INTO `order` VALUES (59, 10, '2024-06-23T02:45:06.130', '订单尚未完成,完成时间未定..', '广州市海珠区仲恺农业工程学院东沙街24号', '已支付,正在等待店主接单...');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_price` decimal(10, 2) NULL DEFAULT NULL,
  `product_num` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (31, 'Samsung Galaxy S22 Ultra', 1199.99, 30, '三星最新旗舰，配备超清屏幕和强大相机系统。', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.5OTkfgYmNzp3t_PF1xxOmwHaEa?w=267&h=180&c=7&r=0&o=5&dpr=1.1&pid=1.7', '电子产品');
INSERT INTO `product` VALUES (32, 'Kindle Paperwhite', 149.99, 100, '亚马逊电子书阅读器，轻薄设计，长时间续航。', 'https://tse1-mm.cn.bing.net/th/id/OIP-C._r_Tsv5Twdu-1CgqHE2LtAHaF0?w=203&h=180&c=7&r=0&o=5&dpr=1.1&pid=1.7', '电子产品');
INSERT INTO `product` VALUES (33, 'Sony WH-1000XM4', 299.99, 20, '索尼降噪耳机，行业领先的主动降噪技术。', 'https://tse4-mm.cn.bing.net/th/id/OIP-C.0TGUWEpAb9VhS-VacPvBAwHaEK?w=328&h=184&c=7&r=0&o=5&dpr=1.1&pid=1.7', '电子产品');
INSERT INTO `product` VALUES (34, 'Le Creuset Cast Iron Dutch Oven', 249.99, 40, '法国制造铸铁炖锅，厨房必备烹饪神器。', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.x4OGTHsAE8Wab5fqWXkADwHaHa?w=186&h=186&c=7&r=0&o=5&dpr=1.1&pid=1.7', '厨具');
INSERT INTO `product` VALUES (35, 'Instant Pot Duo', 59.99, 80, '多功能电压力锅，快速烹饪各种美食。', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.FP0wL3VQUN9gSHY8I9NS_AHaHa?w=186&h=186&c=7&r=0&o=5&dpr=1.1&pid=1.7', '厨具');
INSERT INTO `product` VALUES (36, 'Adidas Ultraboost 21', 180.00, 60, '阿迪达斯跑鞋，提供出色的缓震和回弹力。', 'https://tse3-mm.cn.bing.net/th/id/OIP-C.qA5e_1cNlQUfBECCaUaa_AHaHa?w=188&h=188&c=7&r=0&o=5&dpr=1.1&pid=1.7', '体育');
INSERT INTO `product` VALUES (37, 'Nike Air Force 1', 99.99, 70, '耐克经典款运动鞋，时尚百搭。', 'https://tse1-mm.cn.bing.net/th/id/OIP-C.6y-4tAUdau7e9iE353JPrAHaDJ?w=89&h=90&c=1&rs=1&qlt=90&r=0&dpr=1.1&pid=InlineBlock', '体育');
INSERT INTO `product` VALUES (38, 'LEGO Star Wars Millennium Falcon', 199.99, 5, '乐高星球大战系列，拼装千年隼号。', 'https://tse1-mm.cn.bing.net/th/id/OIP-C.Eq7JHS4sp3yu_YbcTp0Z0gAAAA?w=186&h=186&c=7&r=0&o=5&dpr=1.1&pid=1.7', '玩具');
INSERT INTO `product` VALUES (39, 'Barbie Dreamhouse', 149.99, 15, '芭比梦想豪宅，小女孩的梦想玩具屋。', 'https://tse1-mm.cn.bing.net/th/id/OIP-C.1L_vuW1RJMZs7FAhWLC-5AHaHa?w=184&h=184&c=7&r=0&o=5&dpr=1.1&pid=1.7', '玩具');

-- ----------------------------
-- Table structure for product_cart
-- ----------------------------
DROP TABLE IF EXISTS `product_cart`;
CREATE TABLE `product_cart`  (
  `product_cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) NOT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`product_cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 269 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_cart
-- ----------------------------
INSERT INTO `product_cart` VALUES (208, 15, 30, 1099.99);
INSERT INTO `product_cart` VALUES (209, 15, 31, 1199.99);
INSERT INTO `product_cart` VALUES (210, 15, 33, 299.99);
INSERT INTO `product_cart` VALUES (211, 15, 33, 299.99);
INSERT INTO `product_cart` VALUES (212, 15, 33, 299.99);
INSERT INTO `product_cart` VALUES (213, 15, 33, 299.99);
INSERT INTO `product_cart` VALUES (214, 15, 30, 1099.99);
INSERT INTO `product_cart` VALUES (215, 15, 30, 1099.99);
INSERT INTO `product_cart` VALUES (216, 15, 31, 1199.99);
INSERT INTO `product_cart` VALUES (217, 15, 32, 149.99);
INSERT INTO `product_cart` VALUES (218, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (219, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (220, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (221, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (222, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (223, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (224, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (225, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (226, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (227, 16, 31, 1199.99);
INSERT INTO `product_cart` VALUES (228, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (229, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (230, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (231, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (232, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (233, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (234, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (235, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (236, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (237, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (238, 16, 31, 1199.99);
INSERT INTO `product_cart` VALUES (239, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (240, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (241, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (242, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (243, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (244, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (245, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (246, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (247, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (248, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (249, 16, 31, 1199.99);
INSERT INTO `product_cart` VALUES (250, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (251, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (252, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (253, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (254, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (255, 16, 32, 149.99);
INSERT INTO `product_cart` VALUES (256, 16, 37, 99.99);
INSERT INTO `product_cart` VALUES (257, 16, 33, 299.99);
INSERT INTO `product_cart` VALUES (258, 17, 32, 149.99);
INSERT INTO `product_cart` VALUES (259, 17, 32, 149.99);
INSERT INTO `product_cart` VALUES (260, 18, 32, 149.99);
INSERT INTO `product_cart` VALUES (262, 19, 33, 299.99);
INSERT INTO `product_cart` VALUES (263, 19, 33, 299.99);
INSERT INTO `product_cart` VALUES (264, 19, 32, 149.99);
INSERT INTO `product_cart` VALUES (265, 20, 31, 1199.99);
INSERT INTO `product_cart` VALUES (266, 20, 33, 299.99);
INSERT INTO `product_cart` VALUES (267, 20, 33, 299.99);
INSERT INTO `product_cart` VALUES (268, 21, 33, 299.99);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'user1', '1', '18946975729', '14312223618@qq.com');
INSERT INTO `user` VALUES (9, 'user2', '1', '18946975722', '14312223617@qq.com');
INSERT INTO `user` VALUES (10, 'user3', '1', '18946975724', '14312223517@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
