CREATE TABLE if not exists comment (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  comment NVARCHAR(250) NOT NULL
);

CREATE TABLE if not exists log_pass (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  login NVARCHAR(50) NOT NULL,
  password NVARCHAR(50) NOT NULL,
  comment_id INTEGER,
  FOREIGN KEY(comment_id) REFERENCES comment(id)
);

CREATE TABLE if not exists status (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  comment NVARCHAR(50) NOT NULL
);

CREATE TABLE if not exists question (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  question NVARCHAR(250) NOT NULL
);

CREATE TABLE if not exists user_p4j (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  login NVARCHAR(50) NOT NULL,
  password NVARCHAR(50) NOT NULL,
  question_id INTEGER,
  answer NVARCHAR(50) NOT NULL,
  FOREIGN KEY(question_id) REFERENCES question(id)
);

CREATE TABLE if not exists table_p4j (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  user_id INTEGER NOT NULL,
  log_pass_id INTEGER NOT NULL,
  FOREIGN KEY(user_id) REFERENCES user_p4j(id),
  FOREIGN KEY(log_pass_id) REFERENCES log_pass(id)
);