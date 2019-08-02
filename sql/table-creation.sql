CREATE TABLE IF NOT EXISTS products (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(120) NOT NULL,
  price DECIMAL (12, 2) NOT NULL,
  description VARCHAR(300) NULL,
  category VARCHAR (120) NOT NULL,
  discount DECIMAL (4, 2) NULL,
  discountPrice DECIMAL (12,2) NULL,
  created timestamp default current_timestamp,
  primary key (id));