# Users schema
 
# --- !Ups
 
CREATE TABLE user (
    id int unsigned NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO user SET email='example1@example.com', name='foo';
INSERT INTO user SET email='example2@example.com', name='bar';
INSERT INTO user SET email='example3@example.com', name='bazz';

 
# --- !Downs
 
DROP TABLE user;
