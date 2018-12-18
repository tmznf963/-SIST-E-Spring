CREATE TABLE Member
(
	userid	VARCHAR2(14),
	name		VARCHAR2(20) NOT NULL,
	age			NUMBER(3)	NOT NULL,
	gender	VARCHAR2(10)	NOT NULL,
	city		VARCHAR2(20)	NOT NULL,
	CONSTRAINT member_userid_pk PRIMARY KEY(userid),
	CONSTRAINT member_gender_ck CHECK(gender IN('여성','남성'))
)