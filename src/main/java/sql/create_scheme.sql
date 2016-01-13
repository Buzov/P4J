CREATE SCHEMA `p4j` DEFAULT CHARACTER SET utf8;

CREATE TABLE if not exists `p4j`.`login_password` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `login` NVARCHAR(50) NOT NULL,
  `password` NVARCHAR(50) NOT NULL,
  `comment_id` INTEGER,
   FOREIGN KEY(comment_id) REFERENCES comment(id),
);

CREATE TABLE if not exists `p4j`.`comment` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `comment` NVARCHAR(50) NOT NULL,
);

CREATE TABLE if not exists `p4j`.`status` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `comment` NVARCHAR(50) NOT NULL,
);