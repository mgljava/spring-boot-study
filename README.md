# spring-boot-study
CREATE DATABASE springbootdb;

DROP TABLE IF EXISTS  `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT city VALUES (1 ,510100,'成都市','成都市又名天府之国');
INSERT city VALUES (2 ,510300,'自贡市','自贡市又名南国灯城');
INSERT city VALUES (3 ,510800,'宜宾市','自贡市又名江南之乡');

Swagger: http://localhost:8082/swagger-ui.html

Sonar: mvn sonar:sonar
