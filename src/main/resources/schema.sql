drop table if exists post CASCADE;

CREATE TABLE post (
     id BIGINT(20) NOT NULL AUTO_INCREMENT,
     writer VARCHAR(255),
     title VARCHAR(255),
     content VARCHAR(255),
     localdatetime TIMESTAMP,
     primary key (id)
);

drop table if exists `user` CASCADE;

create table `user`
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    `name` VARCHAR(50),
    email VARCHAR(100),
    primary key (id)
);

drop table if exists reply CASCADE;

create table reply
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    post_id BIGINT(20) NOT NULL,
    writer VARCHAR(50) NOT NULL,
    contents VARCHAR(255) NOT NULL,
    create_time TIMESTAMP,
    primary key (id)
);
