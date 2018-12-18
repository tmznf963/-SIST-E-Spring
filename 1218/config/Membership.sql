CREATE TABLE Member
(
	userid	VARCHAR2(14),
  NAME		VARCHAR2(20) NOT NULL,
  age			NUMBER(3)	NOT NULL,
  gender	VARCHAR2(10)	NOT NULL,
  city		VARCHAR2(20)	NOT NULL,
  CONSTRAINT member_userid_pk PRIMARY KEY(userid),
  CONSTRAINT member_gender_ck CHECK(gender IN('여성','남성'))
)

CREATE OR REPLACE PROCEDURE sp_member_select_all
(
	rec_members	OUT	SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_members FOR
  SELECT userid, name, age, gender, city
	FROM Member
  ORDER BY userid DESC;
END;

INSERT INTO MEMBER VALUES('javaman','한지민',22,'여성','서울')
COMMIT;

CREATE OR REPLACE PROCEDURE sp_member_insert
(
    v_userid      IN     Member.userid%TYPE,
    v_name      IN       Member.name%TYPE,
    v_age      IN        Member.age%TYPE,
    v_gender      IN     Member.gender%TYPE,
    v_city      IN       Member.city%TYPE
)
IS
BEGIN
    INSERT INTO Member(userid, name, age, gender, city)
    VALUES(v_userid, v_name, v_age, v_gender, v_city);
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE sp_member_select_one
(
	p_userid		IN   Member.userid%TYPE,
  rec_member  OUT		SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_member FOR
  SELECT userid, NAME, age, gender, city
  FROM Member
  WHERE userid = p_userid;
END;
