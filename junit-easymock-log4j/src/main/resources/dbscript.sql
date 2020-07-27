create table logs(
  method varchar(256) NOT NULL,
  dated DATETIME NOT NULL,
  logger varchar(256) NOT NULL,
  level varchar(10) NOT NULL,
  message varchar(256) NOT NULL
);
/*%M  %d  %C %P %m*/