/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50612
Source Host           : 192.168.198.129:3306
Source Database       : online_examination_system

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-05-21 16:53:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `courseName` varchar(255) NOT NULL,
  `courseInformation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  KEY `userID` (`userID`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `examID` int(11) NOT NULL AUTO_INCREMENT,
  `gradeID` int(11) NOT NULL,
  `questionBankID` int(11) NOT NULL,
  `examName` varchar(255) NOT NULL,
  `examTime` varchar(255) NOT NULL,
  `examMinutes` varchar(255) NOT NULL,
  `examStartMinutes` varchar(255) NOT NULL,
  `judgeNumber` int(11) NOT NULL,
  `morechoiceNumber` int(11) NOT NULL,
  `onechoiceNumber` int(11) NOT NULL,
  `judgeScore` float NOT NULL,
  `morechoiceScore` float NOT NULL,
  `onechoiceScore` float NOT NULL,
  PRIMARY KEY (`examID`),
  KEY `gradeID` (`gradeID`),
  KEY `questionBankID` (`questionBankID`),
  CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`questionBankID`) REFERENCES `questionbank` (`questionBankID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`gradeID`) REFERENCES `grade` (`gradeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for examscore
-- ----------------------------
DROP TABLE IF EXISTS `examscore`;
CREATE TABLE `examscore` (
  `examID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `score` float NOT NULL,
  KEY `examID` (`examID`),
  KEY `userID` (`userID`),
  CONSTRAINT `examscore_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `examscore_ibfk_1` FOREIGN KEY (`examID`) REFERENCES `exam` (`examID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examscore
-- ----------------------------

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `gradeName` varchar(255) NOT NULL,
  PRIMARY KEY (`gradeID`),
  KEY `gradeID` (`gradeID`),
  KEY `userID` (`userID`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '1', '管理员组');
INSERT INTO `grade` VALUES ('2', '1', '教师组');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionID` int(11) NOT NULL AUTO_INCREMENT,
  `questionBankID` int(11) NOT NULL,
  `questionType` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `A` varchar(255) DEFAULT NULL,
  `B` varchar(255) DEFAULT NULL,
  `C` varchar(255) DEFAULT NULL,
  `D` varchar(255) DEFAULT NULL,
  `E` varchar(255) DEFAULT NULL,
  `answer` varchar(255) NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `questionBankID` (`questionBankID`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`questionBankID`) REFERENCES `questionbank` (`questionBankID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for questionbank
-- ----------------------------
DROP TABLE IF EXISTS `questionbank`;
CREATE TABLE `questionbank` (
  `questionBankID` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` int(11) NOT NULL,
  `questionBankName` varchar(255) NOT NULL,
  PRIMARY KEY (`questionBankID`),
  KEY `questionBankID` (`questionBankID`),
  KEY `courseID` (`courseID`),
  CONSTRAINT `questionbank_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionbank
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `gradeID` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `identity` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `userID` (`userID`),
  KEY `gradeID` (`gradeID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`gradeID`) REFERENCES `grade` (`gradeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'administrator', 'admin', 'Manager');
INSERT INTO `user` VALUES ('2', '2', 'teacher', '123456', 'Teacher');
