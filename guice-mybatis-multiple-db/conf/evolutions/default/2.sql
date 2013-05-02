# Users schema
 
# --- !Ups
 
CREATE TABLE admin (
    id int unsigned NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO admin SET email='example-admin1@example.com', name='foo';
INSERT INTO admin SET email='example-admin2@example.com', name='bar';
INSERT INTO admin SET email='example-admin3@example.com', name='bazz';

 
# --- !Downs

DROP TABLE admin;
