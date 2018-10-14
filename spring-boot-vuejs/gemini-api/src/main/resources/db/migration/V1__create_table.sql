-- テーブルが重複しないよう存在チェック、あれば削除します
DROP TABLE IF EXISTS currency;

-- 簡易なマスタテーブル
CREATE TABLE `currency` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `symbol` VARCHAR(10) NOT NULL,
  `amount` DECIMAL(40, 20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
