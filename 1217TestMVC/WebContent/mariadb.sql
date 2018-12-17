CREATE TABLE Member
(
	userid	VARCHAR(20),
	name	VARCHAR(20)	NOT NULL,
	age	TINYINT NOT NULL,
	gender	VARCHAR(10)	NOT NULL,
	city	VARCHAR(20)	NOT NULL,
	CONSTRAINT member_userid_pk	primary key(userid)
);

INSERT INTO Member(userid,name,age,gender,city)
VALUES("javaman",'한지민',11,'여','서울');
commit;