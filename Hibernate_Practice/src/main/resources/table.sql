CREATE DATABASE IF NOT EXISTS mydb default charset utf8 COLLATE utf8_general_ci;
use mydb;
create table stock (
            `STOCK_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
            `STOCK_CODE` VARCHAR(10) NOT NULL,
            `STOCK_NAME` VARCHAR(20) NOT NULL,
            PRIMARY KEY (`STOCK_ID`) USING BTREE,
            UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
            UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
         ) ENGINE=InnoDB DEFAULT CHARSET=utf8;