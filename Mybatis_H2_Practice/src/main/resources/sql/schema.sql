CREATE TABLE IF NOT EXISTS `booking_record` (
  `id`             INT  NOT NULL  AUTO_INCREMENT
  COMMENT '自增id',
  `depcode`        VARCHAR(6)   NOT NULL  DEFAULT ''
  COMMENT '出发地三字码',
  `arrcode`        VARCHAR(6)   NOT NULL  DEFAULT ''
  COMMENT '目的地三字码',
  `pcc`            VARCHAR(20)  NOT NULL  DEFAULT ''
  COMMENT 'PCC',
  `gds_type`       VARCHAR(20)  NOT NULL  DEFAULT ''
  COMMENT 'GDS类型',
  `booking_result` TINYINT      NOT NULL  DEFAULT 0
  COMMENT '记录booking结果,1表示booking成功，2表示booking失败',
  `record_time`    TIMESTAMP    NOT NULL  DEFAULT '1990-01-01 00:00:01'
  COMMENT '记录的时间戳',
  PRIMARY KEY (`id`)
);