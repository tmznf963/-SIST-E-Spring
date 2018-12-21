CREATE SEQUENCE seq_board_idx
MAXVALUE 9999;
--NUMBER(4)

CREATE TABLE Board
(
	idx NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	email VARCHAR2(100),
	title VARCHAR2(100) NOT NULL,
	contents VARCHAR2(2000) NOT NULL,
	writedate DATE DEFAULT SYSDATE,
	readnum NUMBER(4) DEFAULT 0,
	grp NUMBER(4) NOT NULL,
	lev NUMBER(2) DEFAULT 0,
	step NUMBER(2) DEFAULT 0,
	CONSTRAINT board_idx_pk PRIMARY KEY(idx)
);

CREATE OR REPLACE PROCEDURE sp_board_insert
(
	b_name		IN 			Board.NAME%TYPE,
 	 b_email		IN			Board.EMAIL%TYPE,
 	 b_title		IN			Board.title%TYPE,
 	 b_contents	IN			Board.contents%TYPE
)
IS
BEGIN
	INSERT INTO Board(idx,name,email,title,CONTENTS,grp)
  VALUES (SEQ_BOARD_IDX.NEXTVAL, b_name, b_email,b_title,b_contents,SEQ_BOARD_IDX.CURRVAL);
  COMMIT;
END;
--DEFAULT값은 자동적으로 들어감.