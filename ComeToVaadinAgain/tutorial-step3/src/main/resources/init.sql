create table IF NOT EXISTS  'cfg_user'(
  'id' int(9) AUTO_INCREMENT,
  'username' VARCHAR2(20) not null,
  'password' VARCHAR2(50) not null,
  PRIMARY KEY  (`id`)
);