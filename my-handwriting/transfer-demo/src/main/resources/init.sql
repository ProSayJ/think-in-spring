drop table if exists account;
CREATE TABLE `account`
(
    `id`     int NOT NULL AUTO_INCREMENT,
    `cardNo` float        DEFAULT NULL,
    `name`   varchar(255) DEFAULT NULL,
    `money`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `spring`.`account`(`id`, `cardNo`, `name`, `money`)
VALUES (1, 6029621011001, '韩梅梅', '100');
INSERT INTO `spring`.`account`(`id`, `cardNo`, `name`, `money`)
VALUES (2, 6029621011000, '李大雷', '100');

