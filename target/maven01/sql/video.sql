CREATE TABLE `User` (
`id`  int(8) NOT NULL AUTO_INCREMENT ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  tinyint(1) NOT NULL DEFAULT 1 ,
`createAt`  datetime NULL DEFAULT NULL ,
`updateAt`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=13
ROW_FORMAT=COMPACT
;

CREATE TABLE `ZipFile` (
`id`  int(8) NOT NULL AUTO_INCREMENT ,
`userId`  int(8) NULL DEFAULT NULL ,
`originName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tempName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`downloadDate`  datetime NULL DEFAULT NULL ,
`status`  tinyint(1) UNSIGNED NULL DEFAULT 0 ,
`size`  double(8,0) NULL DEFAULT NULL ,
`createAt`  datetime NULL DEFAULT NULL ,
`updateAt`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=10
ROW_FORMAT=COMPACT
;

