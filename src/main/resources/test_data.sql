INSERT INTO `user` (user_id, password, `name`, email) VALUES ('test1', 'password1', 'name1', 'email1');
INSERT INTO `user` (user_id, password, `name`, email) VALUES ('test2', 'password2', 'name2', 'email2');
INSERT INTO `user` (user_id, password, `name`, email) VALUES ('test3', 'password3', 'name3', 'email3');

INSERT INTO post (writer, title, content, localdatetime) VALUES ('test1', 'title1', 'content1', '2011-11-12 09:11:09');
INSERT INTO post (writer, title, content, localdatetime) VALUES ('test2', 'title2', 'content2', '2011-11-12 09:11:09');
INSERT INTO post (writer, title, content, localdatetime) VALUES ('test3', 'title3', 'content3', '2011-11-12 09:11:09');

INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('1', 'test1', 'reply1', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('1', 'test2', 'reply2', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('1', 'test3', 'reply3', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('2', 'test1', 'reply4', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('2', 'test2', 'reply5', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('2', 'test3', 'reply6', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('3', 'test1', 'reply7', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('3', 'test2', 'reply8', '2011-11-12 09:11:09');
INSERT INTO reply (post_id, writer, contents, create_time) VALUES ('3', 'test3', 'reply9', '2011-11-12 09:11:09');
