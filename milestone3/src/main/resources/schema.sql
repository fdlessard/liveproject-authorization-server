DROP TABLE IF EXISTS authority cascade;
DROP TABLE IF EXISTS user cascade;
DROP TABLE IF EXISTS client_grant_types cascade;
DROP TABLE IF EXISTS client cascade;


CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL,
    algorithm VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS authority (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    user INT NOT NULL,
    PRIMARY KEY (id)
);

create table client(
  id int NOT NULL AUTO_INCREMENT,
  client_id VARCHAR(255) ,
  secret VARCHAR(255),
  scope VARCHAR(255),
  redirect_uri VARCHAR(255),
  PRIMARY KEY (id)
);

create table client_grant_type (
  id int NOT NULL AUTO_INCREMENT,
  grant_type VARCHAR(255),
  client_id int,
  PRIMARY KEY (id),
  foreign key (client_id) references client(id)
)
