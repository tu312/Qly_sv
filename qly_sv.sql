/*
Navicat MySQL Data Transfer

Source Server         : database
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : qly_sv

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2017-04-03 13:59:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_notification
-- ----------------------------
DROP TABLE IF EXISTS `admin_notification`;
CREATE TABLE `admin_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `partner_id` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin_notification
-- ----------------------------
INSERT INTO `admin_notification` VALUES ('1', 'Kiem tra lai sinh vien: Nguyễn Hoàng Khánh-8/6/95-58N khong tim thay sinh vien co MSSV: 13020250', '1', 'NEW', '0', null);
INSERT INTO `admin_notification` VALUES ('2', 'Kiem tra lai sinh vien: Đinh Vũ Nam-8/6/95-58N khong tim thay sinh vien co MSSV: 13020289', '1', 'NEW', '0', null);
INSERT INTO `admin_notification` VALUES ('3', 'Kiem tra lai sinh vien: Nguyễn Anh Tú-8/6/95-58N khong tim thay sinh vien co MSSV: 13020225', '1', 'NEW', '0', null);
INSERT INTO `admin_notification` VALUES ('4', 'asdasd from 13020226', '0', 'NEW', '1', null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filter` int(11) DEFAULT NULL,
  `partner_id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_otystucvhu1v2co05p736xhdb` (`partner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `post_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gse8lsnwrbs911o6lsclobwlt` (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('4', '1', 'FPT Hà Nội tuyển thực tập', '1', '13020226');
INSERT INTO `follow` VALUES ('5', '2', 'FPT Hà Nội tuyển thực tập', '1', '13020226');
INSERT INTO `follow` VALUES ('6', '4', 'fsd fsdf', '1', '13020226');
INSERT INTO `follow` VALUES ('7', '3', 'asdasd', '1', '13020226');

-- ----------------------------
-- Table structure for info_by_school
-- ----------------------------
DROP TABLE IF EXISTS `info_by_school`;
CREATE TABLE `info_by_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gpa` double DEFAULT NULL,
  `diploma` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `graduation_year` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `major` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_class` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_code` int(11) DEFAULT NULL,
  `student_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of info_by_school
-- ----------------------------
INSERT INTO `info_by_school` VALUES ('1', '4', 'Không có', '58', 'Dec-17', 'Mạng và truyền thông', 'N', '13020226', 'Nguyễn Hoàng Khánh');
INSERT INTO `info_by_school` VALUES ('2', '4', 'Không có', '58', 'Jan-18', 'Mạng và truyền thông', 'N', '13020227', 'Đinh Vũ Nam');
INSERT INTO `info_by_school` VALUES ('3', '4', 'Không có', '58', 'Feb-18', 'Mạng và truyền thông', 'N', '13020228', 'Nguyễn Anh Tú');
INSERT INTO `info_by_school` VALUES ('4', '4', 'Không có', '58', 'Mar-18', 'Mạng và truyền thông', 'N', '13020229', 'Cù Xuân Thắng');
INSERT INTO `info_by_school` VALUES ('5', '4', 'Không có', '58', 'Dec-17', 'Mạng và truyền thông', 'N', '13020230', 'Vũ Anh Tuấn');
INSERT INTO `info_by_school` VALUES ('6', '4', 'Không có', '58', 'Jan-18', 'Mạng và truyền thông', 'N', '13020231', 'Phan Khắc Vũ');
INSERT INTO `info_by_school` VALUES ('7', '4', 'Không có', '58', 'Feb-18', 'Mạng và truyền thông', 'N', '13020232', 'Đặng Quang Trung');
INSERT INTO `info_by_school` VALUES ('8', '4', 'Không có', '58', 'Mar-18', 'Mạng và truyền thông', 'N', '13020233', 'Nguyễn Duy Anh');
INSERT INTO `info_by_school` VALUES ('9', '4', 'Không có', '58', 'Dec-17', 'Mạng và truyền thông', 'N', '13020234', 'Lê Việt Hưng');
INSERT INTO `info_by_school` VALUES ('10', '4', 'Không có', '58', 'Jan-18', 'Mạng và truyền thông', 'N', '13020235', 'Mai Văn Chính');
INSERT INTO `info_by_school` VALUES ('11', '4', 'Không có', '58', 'Feb-18', 'Mạng và truyền thông', 'N', '13020236', 'Đinh Xuân Nam');
INSERT INTO `info_by_school` VALUES ('12', '4', 'Không có', '58', 'Mar-18', 'Mạng và truyền thông', 'N', '13020237', 'Nguyễn Khắc Thực');

-- ----------------------------
-- Table structure for internship
-- ----------------------------
DROP TABLE IF EXISTS `internship`;
CREATE TABLE `internship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `partner_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  `supervisor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pu1w01s50pmr4vqesqlrw6lq7` (`partner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of internship
-- ----------------------------
INSERT INTO `internship` VALUES ('1', 'Cty LG Viet Nam', '1970-01-18 12:12:05', '1', '1970-01-18 12:20:16', '4', 'Duong Le Minh');

-- ----------------------------
-- Table structure for job_skill
-- ----------------------------
DROP TABLE IF EXISTS `job_skill`;
CREATE TABLE `job_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `skill` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `student_id` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `about` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `end_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `start_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dpuhil0tajoncfvhv30qox90` (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of job_skill
-- ----------------------------
INSERT INTO `job_skill` VALUES ('1', 'uet', 'java', '1', null, null, null, null, null);
INSERT INTO `job_skill` VALUES ('2', 'etu', 'js', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for partner
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partner_info_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_20ap6716xrrmlnu90ovblpxig` (`partner_info_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of partner
-- ----------------------------
INSERT INTO `partner` VALUES ('1', '1');
INSERT INTO `partner` VALUES ('2', '2');

-- ----------------------------
-- Table structure for partner_contact
-- ----------------------------
DROP TABLE IF EXISTS `partner_contact`;
CREATE TABLE `partner_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `partner_id` int(11) NOT NULL,
  `skype` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `about` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_n37ksadhg4cx7g54hqimagewd` (`partner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of partner_contact
-- ----------------------------
INSERT INTO `partner_contact` VALUES ('1', 'Hà Nội', 'Khánh', 'nkhanh96@gmail.com', '1', 'không có', null, null, null);

-- ----------------------------
-- Table structure for partner_info
-- ----------------------------
DROP TABLE IF EXISTS `partner_info`;
CREATE TABLE `partner_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `average_rating` double DEFAULT NULL,
  `director` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `field_work` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `logo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `partner_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tax_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_rating` int(11) DEFAULT NULL,
  `website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of partner_info
-- ----------------------------
INSERT INTO `partner_info` VALUES ('1', 'Tầng 2, Tòa nhà FPT Cầu Giấy, Phố Duy Tân, Q. Cầu Giấy', null, 'Chu Thị Thanh Hà', 'hr@fpt.com', null, 'developer, tester', 'http://localhost:8000/users_data/partner/fpt/logo/fpt_logo.jpg', 'fpt', '04 73002222', '(84-4) 7300 8889', null, 'www.fpt.vn');
INSERT INTO `partner_info` VALUES ('2', null, null, null, null, null, null, 'http://localhost:8000/users_data/partner/uet/logo/uet_logo.jpg', 'uet', null, null, null, null);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8_unicode_ci,
  `date_post` datetime DEFAULT NULL,
  `describe_post` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `partner_id` int(11) NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `required_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_k4s6wxlb8ec1uqsaw8lnxkr5b` (`partner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '<p>Số lượng cần tuyển dụng : 5 - 7&nbsp;<br>Địa điểm làm việc : Hà Nội ( làm việc tại các quận nội thành )<br><br>Mô tả chi tiết công việc</p><ul style=\"font-size: 0.9em; color: rgb(83, 91, 96);\"><li>Tìm kiếm thông tin, tiếp cận các khách hàng tiềm năng</li><li>Tư vấn, giải thích cho khách hàng về dịch vụ Internet và dịch vụ Truyền Hình FPT do FPT Telecom đang cung cấp</li><li>Đàm phán thương lượng, thực hiện các thủ tục ký kết hợp đồng với khách hàng</li></ul><p>Yêu cầu công việc</p><ul style=\"font-size: 0.9em; color: rgb(83, 91, 96);\"><li>Nam/ Nữ, Tốt nghiệp, Trung Cấp trở lên, từ 20 – 30 tuổi ( Ưu tiên cho các bạn mới tốt nghiệp hoặc là sinh viên năm cuối Cao Đẳng, Đại Học)</li><li>Đam mê kinh doanh, có kiến thức cơ bản về Công nghệ thông tin, mạng Internet</li><li>Có kỹ năng giao tiếp, đàm phán và thuyết phục</li><li>Nhanh nhẹn, linh hoạt, giải quyết tình huống tốt</li><li>Ngoại hình dễ nhìn, không nói ngọng, nói lắp</li><li>Chấp nhận công việc áp lực cao, thường xuyên di chuyển bên ngoài để gặp gỡ khách hàng</li><li>Các ứng viên đã có kinh nghiệm bán hàng hoặc từng làm qua các công việc như: tiếp thị, nghiên cứu thị trường, phỏng vấn viên…là một lợi thế.</li></ul><p>Quyền lợi</p><ul style=\"font-size: 0.9em; color: rgb(83, 91, 96);\"><li>Mức lương và thu nhập hấp dẫn trung bình từ 5 - 10tr/tháng</li><li>Chế độ khen thưởng và phúc lợi phong phú</li><li>Môi trường làm việc trẻ, thân thiện, năng động, chuyên nghiệp</li><li>Cơ hội đào tạo, phát triển và thăng tiến</li><li>Các chế độ theo Luật lao động hiện hành và các phúc lợi theo quy định của Công ty (bảo hiểm FPT Care,…)</li></ul><p>Thông tin liên hệ</p><ul style=\"font-size: 0.9em; color: rgb(83, 91, 96);\"><li>Thông tin liên hệ : Mr Quang</li><li>Email :&nbsp;<a href=\"mailto:quangdx3@fpt.com.vn\">quangvm4@fpt.com.vn</a></li><li>Điện thoại cố định 04.7300.2222/ext 4928</li><li>Di động :&nbsp;0981.979.682</li><li>Địa chỉ : 48 Vạn Bảo - Ba Đình - Hà Nội</li></ul><p>Nộp Hồ Sơ</p><ul style=\"font-size: 0.9em; color: rgb(83, 91, 96);\"><li>Bạn vui lòng liên hệ hotline :&nbsp;0981.979.682&nbsp;để cung cấp thông tin ứng tuyển<br></li><li>Ưu tiên nộp hồ sơ trực tiếp tại :&nbsp;48 Vạn Bảo - Ba Đình - Hà Nội</li><li>Chúng tôi sẽ xem xét và liên hệ với bạn để phỏng vấn trực tiếp nếu như hồ sơ của bạn phù hợp</li><li>Hãy nhấc máy lên và gọi cho chúng tôi để có được cơ hội thử sức làm việc trong môi trường chuyên nghiệp tại FPT Telecom.</li></ul><p>Các bạn có thể tham khảo các dịch vụ mà FPT cung cấp tại trang chủ :&nbsp;<a href=\"http://capquangfpt.pro/\" target=\"_blank\">http://capquangfpt.pro/</a></p>', '2017-03-07 09:38:27', 'FPT Hà Nội tuyển thực tập', 'http://localhost:8000/users_data/partner/fpt/post/1/fpt_1.jpg', '1', 'A', null);
INSERT INTO `post` VALUES ('2', '<p>Số lượng cần tuyển dụng : 5 - 7&nbsp;<br>Địa điểm làm việc : Hà Nội ( làm việc tại các quận nội thành )<br><br>Mô tả chi tiết công việc</p><ul style=\"color: rgb(83, 91, 96);\"><li>Tìm kiếm thông tin, tiếp cận các khách hàng tiềm năng</li><li>Tư vấn, giải thích cho khách hàng về dịch vụ Internet và dịch vụ Truyền Hình FPT do FPT Telecom đang cung cấp</li><li>Đàm phán thương lượng, thực hiện các thủ tục ký kết hợp đồng với khách hàng</li></ul><p>Yêu cầu công việc</p><ul style=\"color: rgb(83, 91, 96);\"><li>Nam/ Nữ, Tốt nghiệp, Trung Cấp trở lên, từ 20 – 30 tuổi ( Ưu tiên cho các bạn mới tốt nghiệp hoặc là sinh viên năm cuối Cao Đẳng, Đại Học)</li><li>Đam mê kinh doanh, có kiến thức cơ bản về Công nghệ thông tin, mạng Internet</li><li>Có kỹ năng giao tiếp, đàm phán và thuyết phục</li><li>Nhanh nhẹn, linh hoạt, giải quyết tình huống tốt</li><li>Ngoại hình dễ nhìn, không nói ngọng, nói lắp</li><li>Chấp nhận công việc áp lực cao, thường xuyên di chuyển bên ngoài để gặp gỡ khách hàng</li><li>Các ứng viên đã có kinh nghiệm bán hàng hoặc từng làm qua các công việc như: tiếp thị, nghiên cứu thị trường, phỏng vấn viên…là một lợi thế.</li></ul><p>Quyền lợi</p><ul style=\"color: rgb(83, 91, 96);\"><li>Mức lương và thu nhập hấp dẫn trung bình từ 5 - 10tr/tháng</li><li>Chế độ khen thưởng và phúc lợi phong phú</li><li>Môi trường làm việc trẻ, thân thiện, năng động, chuyên nghiệp</li><li>Cơ hội đào tạo, phát triển và thăng tiến</li><li>Các chế độ theo Luật lao động hiện hành và các phúc lợi theo quy định của Công ty (bảo hiểm FPT Care,…)</li></ul><p>Thông tin liên hệ</p><ul style=\"color: rgb(83, 91, 96);\"><li>Thông tin liên hệ : Mr Quang</li><li>Email :&nbsp;<a href=\"mailto:quangdx3@fpt.com.vn\">quangvm4@fpt.com.vn</a></li><li>Điện thoại cố định 04.7300.2222/ext 4928</li><li>Di động :&nbsp;0981.979.682</li><li>Địa chỉ : 48 Vạn Bảo - Ba Đình - Hà Nội</li></ul><p>Nộp Hồ Sơ</p><ul style=\"color: rgb(83, 91, 96);\"><li>Bạn vui lòng liên hệ hotline :&nbsp;0981.979.682&nbsp;để cung cấp thông tin ứng tuyển<br></li><li>Ưu tiên nộp hồ sơ trực tiếp tại :&nbsp;48 Vạn Bảo - Ba Đình - Hà Nội</li><li>Chúng tôi sẽ xem xét và liên hệ với bạn để phỏng vấn trực tiếp nếu như hồ sơ của bạn phù hợp</li><li>Hãy nhấc máy lên và gọi cho chúng tôi để có được cơ hội thử sức làm việc trong môi trường chuyên nghiệp tại FPT Telecom.</li></ul><p>Các bạn có thể tham khảo các dịch vụ mà FPT cung cấp tại trang chủ :&nbsp;<a href=\"http://capquangfpt.pro/\" target=\"_blank\">http://capquangfpt.pro/</a></p>', '2017-03-07 09:46:19', 'FPT Hà Nội tuyển thực tập', 'http://localhost:8000/users_data/partner/fpt/post/2/fpt_2.jpg', '1', 'A', null);
INSERT INTO `post` VALUES ('3', '<p>as das d</p>', '2017-03-11 23:39:25', 'asdasd', 'http://localhost:8000/users_data/partner/uet/post/4/uet_4.jpg', '2', 'A', null);
INSERT INTO `post` VALUES ('4', '<p>sdf sdf sdf ưegf ảg a g</p><p>df gg</p><p>&nbsp;ửg ử</p><p>g ẻg ẻg ẻg&nbsp;</p><p>ẻg ửgƯ RGƯ R</p><p>Ử GỬG ỬG&nbsp;</p><p><br></p>', '2017-03-15 14:42:12', 'fsd fsdf', 'http://localhost:8000/users_data/partner/uet/post/4/uet_4.jpg', '2', 'A', null);
INSERT INTO `post` VALUES ('5', '<p>&nbsp;aega ega ẻgaẻg aẻg&nbsp;</p>', '2017-03-15 14:42:20', 'g ửg aẻg ẻg', 'http://localhost:8000/users_data/partner/uet/post/5/uet_5.jpg', '2', 'A', null);
INSERT INTO `post` VALUES ('6', '<p>Rg ẻ gẻg ẻg ẻ g</p>', '2017-03-15 14:42:33', 'RƯ ẺG EG ẺG', 'http://localhost:8000/users_data/partner/uet/post/6/uet_6.jpg', '2', 'A', null);
INSERT INTO `post` VALUES ('7', '<p>aẻg aẻg aẻg ag ảega rg</p>', '2017-03-15 14:42:45', 'ả gaẻ gaẻ gaẻg', 'http://localhost:8000/users_data/partner/uet/post/7/uet_7.jpg', '2', 'D', null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL,
  `info_by_school_id` int(11) DEFAULT NULL,
  `internship_id` int(11) DEFAULT NULL,
  `student_info_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s73o9b50rrfpoxmvkbr8lxn34` (`comment_id`),
  KEY `FK_7ouh85p4t9w0ahwqtdtqrsunm` (`info_by_school_id`),
  KEY `FK_kv6v6q8gi7bepmkgte28i6kw6` (`internship_id`),
  KEY `FK_n01vd0b6ym77yi6y16iherj23` (`student_info_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', null, '1', null, '1');
INSERT INTO `student` VALUES ('2', null, '2', null, '2');
INSERT INTO `student` VALUES ('3', null, '3', null, '3');
INSERT INTO `student` VALUES ('4', null, '4', '1', '4');
INSERT INTO `student` VALUES ('5', null, '5', null, '5');
INSERT INTO `student` VALUES ('6', null, '6', null, '6');
INSERT INTO `student` VALUES ('7', null, '7', null, '7');
INSERT INTO `student` VALUES ('8', null, '8', null, '8');
INSERT INTO `student` VALUES ('9', null, '9', null, '9');
INSERT INTO `student` VALUES ('10', null, '10', null, '10');
INSERT INTO `student` VALUES ('11', null, '11', null, '11');
INSERT INTO `student` VALUES ('12', null, '12', null, '12');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `desire` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `skype` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1', 'Hà Nội', 'http://localhost:8000/users_data/student/13020226/13020226_avatar.jpg', '6/8/1995', 'không có', 'nhkhanh68@gmail.com', 'Nguyễn Hoàng Khánh', '435345435', 'không có');
INSERT INTO `student_info` VALUES ('2', null, null, null, null, null, 'Đinh Vũ Nam', null, null);
INSERT INTO `student_info` VALUES ('3', null, null, null, null, null, 'Nguyễn Anh Tú', null, null);
INSERT INTO `student_info` VALUES ('4', null, null, null, null, null, 'Cù Xuân Thắng', null, null);
INSERT INTO `student_info` VALUES ('5', null, null, null, null, null, 'Vũ Anh Tuấn', null, null);
INSERT INTO `student_info` VALUES ('6', null, null, null, null, null, 'Phan Khắc Vũ', null, null);
INSERT INTO `student_info` VALUES ('7', null, null, null, null, null, 'Đặng Quang Trung', null, null);
INSERT INTO `student_info` VALUES ('8', null, null, null, null, null, 'Nguyễn Duy Anh', null, null);
INSERT INTO `student_info` VALUES ('9', null, null, null, null, null, 'Lê Việt Hưng', null, null);
INSERT INTO `student_info` VALUES ('10', null, null, null, null, null, 'Mai Văn Chính', null, null);
INSERT INTO `student_info` VALUES ('11', null, null, null, null, null, 'Đinh Xuân Nam', null, null);
INSERT INTO `student_info` VALUES ('12', null, null, null, null, null, 'Nguyễn Khắc Thực', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expiry_time` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `partner_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h4ivmkbkxkh2ngoqn3i0tu3ky` (`partner_id`),
  KEY `FK_i1pkkkteed13wt581o8vanlx8` (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2017-03-23 16:59:33', '1', 'ADMIN', 'A', '05d85396-f4ba-49c2-9fe1-e8e4f5680ed6', 'admin', null, null);
INSERT INTO `user` VALUES ('2', null, '13020226', 'STUDENT', 'A', null, '13020226', null, '1');
INSERT INTO `user` VALUES ('3', null, '13020227', 'STUDENT', 'A', null, '13020227', null, '2');
INSERT INTO `user` VALUES ('4', null, '13020228', 'STUDENT', 'A', null, '13020228', null, '3');
INSERT INTO `user` VALUES ('5', null, '13020229', 'STUDENT', 'A', null, '13020229', null, '4');
INSERT INTO `user` VALUES ('6', null, '13020230', 'STUDENT', 'A', null, '13020230', null, '5');
INSERT INTO `user` VALUES ('7', null, '13020231', 'STUDENT', 'A', null, '13020231', null, '6');
INSERT INTO `user` VALUES ('8', null, '13020232', 'STUDENT', 'A', null, '13020232', null, '7');
INSERT INTO `user` VALUES ('9', null, '13020233', 'STUDENT', 'A', null, '13020233', null, '8');
INSERT INTO `user` VALUES ('10', null, '13020234', 'STUDENT', 'A', null, '13020234', null, '9');
INSERT INTO `user` VALUES ('11', null, '13020235', 'STUDENT', 'A', null, '13020235', null, '10');
INSERT INTO `user` VALUES ('12', null, '13020236', 'STUDENT', 'A', null, '13020236', null, '11');
INSERT INTO `user` VALUES ('13', null, '13020237', 'STUDENT', 'A', null, '13020237', null, '12');
INSERT INTO `user` VALUES ('14', null, 'fpt', 'VIP_PARTNER', 'A', null, 'fpt', '1', null);
INSERT INTO `user` VALUES ('15', null, 'uet', 'VIP_PARTNER', 'A', null, 'uet', '2', null);
