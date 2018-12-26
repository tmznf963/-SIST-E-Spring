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
    rec_board       OUT      SYS_REFCURSOR,
    v_start             IN          NUMBER,
	v_end               IN          NUMBER
)
AS
BEGIN
    OPEN  rec_board FOR
	SELECT B.idx, grp, name, email, title, writedate, readnum, lev, step
	FROM
		(SELECT rownum AS rnum, A.idx, A.grp, A.name, A.email, A.title, A.writedate, A.readnum, A.lev, A.step
	FROM
		(SELECT idx, grp, name, email, title, writedate, readnum, lev, step
			FROM Board ORDER BY grp DESC, step ASC) A
			WHERE rownum <= v_end) B
	WHERE B.rnum >= v_start;
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

--page total count | INTO는 select값을 변수(컬럼)에 할당해준다
CREATE OR REPLACE PROCEDURE sp_board_total_count
(
	v_count OUT Number
)
IS
BEGIN
	SELECT COUNT(*) INTO v_count
  FROM BOARD;
END;

--답글의 step증가
CREATE OR REPLACE PROCEDURE sp_board_answer_update
(
	v_grp IN board.grp%TYPE,
	v_step IN board.step%TYPE
)
IS
BEGIN
	UPDATE Board SET step = step + 1
	WHERE grp = v_grp AND step >= v_step;
	COMMIT;
END;

--답글 insert
CREATE OR REPLACE PROCEDURE sp_board_answer_insert
(
	v_name IN Board.name%TYPE,
	v_email IN Board.email%TYPE,
	v_title IN Board.title%TYPE,
	v_contents IN Board.contents%TYPE,
	v_grp IN Board.grp%TYPE,
	v_lev IN Board.lev%TYPE,
	v_step IN Board.step%TYPE
)
IS
BEGIN
	INSERT INTO Board(idx, name, email, title, contents, grp, lev, step)
	VALUES(seq_board_idx.NEXTVAL, v_name, v_email, v_title, v_contents, v_grp, v_lev, v_step);
	COMMIT;
END;

--댓글 시퀀스
CREATE SEQUENCE seq_reply_idx
MAXVALUE 9999

--댓글 테이블
CREATE TABLE Reply
(
	idx NUMBER(4),
	parent NUMBER(4) DEFAULT 0, --FK는 null이 가능하기 때문에,참조조건 = 프라이머리키&유니크키
	writer VARCHAR2(20) NOT NULL,
	text VARCHAR2(2000) NOT NULL,
	regdate DATE DEFAULT SYSDATE,
	updatedate DATE DEFAULT SYSDATE,
	CONSTRAINT reply_idx_pk PRIMARY KEY(idx),
	CONSTRAINT reply_idx_fk FOREIGN KEY(parent) REFERENCES Board(idx)
)

--댓글 insert
CREATE OR REPLACE PROCEDURE sp_reply_insert
(
	v_parent IN Reply.parent%TYPE,
	v_writer IN Reply.writer%TYPE,
	v_text IN Reply.text%TYPE
)
IS
BEGIN
	INSERT INTO Reply (idx, parent, writer, text)
	VALUES (seq_reply_idx.NEXTVAL, v_parent, v_writer, v_text);
	COMMIT;
END;

--댓글 select
CREATE OR REPLACE PROCEDURE sp_reply_select
(
	v_parent IN Reply.parent%TYPE,
	rec_reply  OUT  SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_reply FOR
  SELECT idx, parent, writer, text, regdate
  FROM Reply
  WHERE parent = v_parent
  ORDER BY idx ASC;
END;

--댓글 삭제
CREATE OR REPLACE PROCEDURE sp_reply_delete
(
	v_idx		IN   Reply.idx%TYPE,
)
IS
BEGIN
	DELETE FROM Reply WHERE idx = v_idx;
  COMMIT;
END;

--댓글 수정
CREATE OR REPLACE PROCEDURE sp_reply_update
(
	v_idx		IN   Reply.idx%TYPE,
  v_text	IN	 Reply.text%TYPE
)
IS
BEGIN
	UPDATE REPLY SET text=v_text, UPDATEDATE = SYSDATE
  WHERE idx = v_idx;
  COMMIT;
END;