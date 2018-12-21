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

--insert
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

--selectAll
CREATE OR REPLACE PROCEDURE sp_board_select_all
(
	rec_board		OUT	SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_board FOR
  SELECT idx,name,email,title,TO_CHAR(writedate,'yyyy-mm-dd'),readnum,grp,lev,step
	FROM BOARD ORDER BY GRP DESC, step ASC;
END;

--selectOne
CREATE OR REPLACE PROCEDURE sp_board_select_one
(
	b_idx			IN		Board.idx%TYPE,
	rec_board		OUT	SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_board FOR
  SELECT idx,name,email,title,contents,TO_CHAR(writedate,'yyyy-mm-dd') AS writedate,readnum,grp,lev,step
	FROM BOARD 
  WHERE idx = b_idx;
END;

--delete
CREATE OR REPLACE PROCEDURE sp_board_delete
(
	b_idx 	IN 		Board.idx%TYPE
)
IS
BEGIN
	DELETE FROM BOARD
  WHERE idx = b_idx;
  COMMIT;
END;

--update
CREATE OR REPLACE PROCEDURE sp_board_update
(
	b_idx 	IN 		Board.idx%TYPE,
  b_email 	IN 		Board.email%TYPE,
  b_title 	IN 		Board.title%TYPE,
  b_contents 	IN 		Board.contents%TYPE
)
IS
BEGIN
	UPDATE Board
  SET email = b_email, title = b_title, CONTENTS = b_contents
  WHERE idx = b_idx;
  COMMIT;
END;