/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3305
 Source Schema         : ltt

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 20/04/2022 19:36:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `send_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送人账号',
  `receive_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '接收人账号',
  `information` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '信息内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `send_account`(`send_account`) USING BTREE,
  INDEX `receive_account`(`receive_account`) USING BTREE,
  INDEX `information`(`information`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`send_account`) REFERENCES `user` (`account`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`receive_account`) REFERENCES `user` (`account`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `auth_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '身份编号',
  `auth_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份名称',
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '老师');
INSERT INTO `role` VALUES (3, '学生');

-- ----------------------------
-- Table structure for stu_task
-- ----------------------------
DROP TABLE IF EXISTS `stu_task`;
CREATE TABLE `stu_task`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生真实姓名',
  `task_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `task_type_id` int(255) NOT NULL COMMENT '任务类型',
  `task_status_id` int(255) NOT NULL COMMENT '任务状态',
  `priority_id` int(255) NOT NULL COMMENT '任务优先级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_type`(`task_type_id`) USING BTREE,
  INDEX `task_status`(`task_status_id`) USING BTREE,
  INDEX `stu_task_ibfk_1`(`realname`) USING BTREE,
  INDEX `stu_task_ibfk_2`(`task_name`) USING BTREE,
  CONSTRAINT `stu_task_ibfk_1` FOREIGN KEY (`realname`) REFERENCES `student_info` (`realname`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_task_ibfk_2` FOREIGN KEY (`task_name`) REFERENCES `task` (`task_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_task
-- ----------------------------
INSERT INTO `stu_task` VALUES (1, '张三三', '测试任务2', 3, 1, 2);
INSERT INTO `stu_task` VALUES (3, '阿贝多', '测试任务1', 8, 2, 2);
INSERT INTO `stu_task` VALUES (4, '张三三', '第一章做题', 3, 3, 2);
INSERT INTO `stu_task` VALUES (5, NULL, '看网课', 1, 2, 3);
INSERT INTO `stu_task` VALUES (6, NULL, '复习今日上课内容', 3, 1, 1);
INSERT INTO `stu_task` VALUES (7, NULL, '刷题练习册', 2, 1, 1);
INSERT INTO `stu_task` VALUES (10, '张123', '背书', 2, 1, 2);

-- ----------------------------
-- Table structure for stu_tea
-- ----------------------------
DROP TABLE IF EXISTS `stu_tea`;
CREATE TABLE `stu_tea`  (
  `sid` int(8) NOT NULL COMMENT '学生id',
  `tid` int(8) NULL DEFAULT NULL COMMENT '老师id',
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `stu_tea_ibfk_2`(`tid`) USING BTREE,
  CONSTRAINT `stu_tea_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_tea_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacher_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_tea
-- ----------------------------
INSERT INTO `stu_tea` VALUES (4, NULL);
INSERT INTO `stu_tea` VALUES (6, NULL);
INSERT INTO `stu_tea` VALUES (1, 1);
INSERT INTO `stu_tea` VALUES (2, 1);
INSERT INTO `stu_tea` VALUES (3, 1);
INSERT INTO `stu_tea` VALUES (5, 1);
INSERT INTO `stu_tea` VALUES (8, 1);
INSERT INTO `stu_tea` VALUES (9, 1);
INSERT INTO `stu_tea` VALUES (10, 1);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '电话号码',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `regist_date` date NOT NULL COMMENT '注册时间',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  INDEX `realname`(`realname`) USING BTREE,
  CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (1, 'student', '张三三', '男', '13333333333', '2022-03-19', '2022-03-07', 'http://localhost:8081/5008acfd-e9ad-413a-8942-1df51deaa8673.png');
INSERT INTO `student_info` VALUES (2, 'wretwert', '张四', '男', '13444444444', '2022-03-01', '2022-03-15', 'http://localhost:8081/0b52dc4d-d65e-4d79-873f-da6d139bc250pic1874.jpg');
INSERT INTO `student_info` VALUES (3, '11223344', '张继科', '女', '17688445938', '2022-02-09', '2022-03-16', 'http://localhost:8081/87e01786-ab3f-49e3-bb9a-0d1c9f62a6d6g.jpg');
INSERT INTO `student_info` VALUES (4, '4354376574', '华生', '男', '19577438345', '2022-03-16', '2022-03-16', 'http://localhost:8081/cb23657f-3139-4e25-a2c5-d2c5f7440511zzpic23859.jpg');
INSERT INTO `student_info` VALUES (5, '376837456', '阿贝多', '女', '13222222223', '2022-03-02', '2022-03-16', 'http://localhost:8081/a2e4bcc0-928d-4917-a40f-dd505f7a4332apic26488.jpg');
INSERT INTO `student_info` VALUES (6, '4359867834', '卡萨丁', '女', '17432324656', '2022-03-17', '2022-03-16', 'http://localhost:8081/f5ef993b-9286-417d-882c-923636071e28Shui1Zhu11i1Pao1pptB-173234_109.jpg');
INSERT INTO `student_info` VALUES (8, 'df98ugj3', '张123', '女', '13455675676', NULL, '2022-03-29', 'http://localhost:8081/30f736df-0719-4738-869d-af1fc1443d5620130816031331766.jpg');
INSERT INTO `student_info` VALUES (9, 'dfkhn45g', '张三', '男', '13456647785', NULL, '2022-03-29', 'http://localhost:8081/e818728d-a4a8-4d00-8aa0-ef423e7ecc5f24110307_8.jpg');
INSERT INTO `student_info` VALUES (10, 'fdgh9845', '张哈哈', '女', '17866948575', NULL, '2022-03-29', 'http://localhost:8081/d505871c-a1d9-4473-af33-9f02e0e6a42024110307_35.jpg');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `task_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `task_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务描述',
  `task_type_id` int(8) NOT NULL COMMENT '任务类型id',
  `task_status_id` int(8) NOT NULL COMMENT '任务状态id',
  `priority_id` int(8) NOT NULL COMMENT '优先度编号',
  `start_time` date NOT NULL COMMENT '开始时间',
  `deadline` date NOT NULL COMMENT '截止时间',
  `t_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属老师',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_name`(`task_name`) USING BTREE,
  INDEX `task_ibfk_1`(`task_type_id`) USING BTREE,
  INDEX `task_ibfk_2`(`task_status_id`) USING BTREE,
  INDEX `task_ibfk_3`(`priority_id`) USING BTREE,
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`task_type_id`) REFERENCES `task_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`task_status_id`) REFERENCES `task_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_ibfk_3` FOREIGN KEY (`priority_id`) REFERENCES `task_priority` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (2, '测试任务2', '测试用', 3, 2, 2, '2018-04-12', '2018-04-25', 'teacher');
INSERT INTO `task` VALUES (11, '测试任务1', '测试任务1234578890！@#@%%￥5', 8, 2, 2, '2022-04-01', '2022-04-02', 'teacher');
INSERT INTO `task` VALUES (12, '第一章做题', '完成课本1-1习题', 3, 3, 2, '2022-04-07', '2022-04-09', 'teacher');
INSERT INTO `task` VALUES (13, '看网课', '看网课第一章第五节、第六节', 1, 2, 3, '2022-04-03', '2022-04-10', 'teacher');
INSERT INTO `task` VALUES (14, '复习今日上课内容', '第5章节', 3, 1, 1, '2022-04-02', '2022-04-03', 'teacher');
INSERT INTO `task` VALUES (15, '刷题练习册', '60页至64页', 2, 1, 1, '2022-04-08', '2022-04-10', 'teacher');
INSERT INTO `task` VALUES (16, '背书', '背诵古诗10首', 2, 1, 2, '2022-04-08', '2022-04-10', 'teacher');

-- ----------------------------
-- Table structure for task_priority
-- ----------------------------
DROP TABLE IF EXISTS `task_priority`;
CREATE TABLE `task_priority`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '优先度id',
  `priority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '优先度',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `priorty`(`priority`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_priority
-- ----------------------------
INSERT INTO `task_priority` VALUES (2, '中');
INSERT INTO `task_priority` VALUES (3, '低');
INSERT INTO `task_priority` VALUES (1, '高');

-- ----------------------------
-- Table structure for task_status
-- ----------------------------
DROP TABLE IF EXISTS `task_status`;
CREATE TABLE `task_status`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '任务状态id',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_status
-- ----------------------------
INSERT INTO `task_status` VALUES (4, '已完成');
INSERT INTO `task_status` VALUES (2, '已开始');
INSERT INTO `task_status` VALUES (3, '待审核');
INSERT INTO `task_status` VALUES (1, '未开始');
INSERT INTO `task_status` VALUES (5, '未通过');

-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '任务类型id',
  `typename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type_name`(`typename`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_type
-- ----------------------------
INSERT INTO `task_type` VALUES (9, 'xx任务');
INSERT INTO `task_type` VALUES (8, '一般任务');
INSERT INTO `task_type` VALUES (2, '假期任务');
INSERT INTO `task_type` VALUES (1, '平时任务');
INSERT INTO `task_type` VALUES (3, '课后任务');

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '老师编号',
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `regist_date` date NOT NULL COMMENT '不为空',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  CONSTRAINT `teacher_info_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (1, 'teacher', '测试老师', '男', '13333333333', '2014-11-30', '2022-03-07', 'http://localhost:8081/dfa7858f-186e-4010-b8a3-c98f22d2d81f1.png');
INSERT INTO `teacher_info` VALUES (6, 'xiaowang', '小王', '男', '13333335678', NULL, '2022-03-15', NULL);
INSERT INTO `teacher_info` VALUES (8, 'noname', '无名氏123', '男', '13457645346', '2020-03-23', '2022-04-06', NULL);
INSERT INTO `teacher_info` VALUES (9, 'testrealname', '真实姓名', NULL, NULL, NULL, '2022-04-10', NULL);
INSERT INTO `teacher_info` VALUES (10, 'ioweurht', '李元', NULL, NULL, NULL, '2022-04-10', NULL);
INSERT INTO `teacher_info` VALUES (11, '2312qq', '钟小花', NULL, NULL, NULL, '2022-04-10', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `auth_id` int(1) NOT NULL COMMENT '身份编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_2`(`account`) USING BTREE,
  INDEX `auth_id`(`auth_id`) USING BTREE,
  INDEX `account`(`account`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`auth_id`) REFERENCES `role` (`auth_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `user` VALUES (2, 'teacher', 'teacher', 2);
INSERT INTO `user` VALUES (3, 'student', 'student', 3);
INSERT INTO `user` VALUES (9, 'xiaowang', 'laoshi', 2);
INSERT INTO `user` VALUES (10, 'wretwert', '12345', 3);
INSERT INTO `user` VALUES (11, '11223344', '12345', 3);
INSERT INTO `user` VALUES (12, '4354376574', '12345', 3);
INSERT INTO `user` VALUES (13, '376837456', '12345', 3);
INSERT INTO `user` VALUES (14, '4359867834', '12345', 3);
INSERT INTO `user` VALUES (17, 'df98ugj3', '778899', 3);
INSERT INTO `user` VALUES (18, 'dfkhn45g', '12345', 3);
INSERT INTO `user` VALUES (19, 'fdgh9845', '567567', 3);
INSERT INTO `user` VALUES (21, 'noname', '12345', 2);
INSERT INTO `user` VALUES (25, 'testrealname', '12345', 2);
INSERT INTO `user` VALUES (26, 'ioweurht', '12345', 2);
INSERT INTO `user` VALUES (27, '2312qq', '12345', 2);

-- ----------------------------
-- Table structure for user_notice
-- ----------------------------
DROP TABLE IF EXISTS `user_notice`;
CREATE TABLE `user_notice`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `information` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '信息内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `account`(`account`) USING BTREE,
  INDEX `information`(`information`) USING BTREE,
  CONSTRAINT `user_notice_ibfk_1` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_notice_ibfk_2` FOREIGN KEY (`information`) REFERENCES `notice` (`information`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_notice
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
