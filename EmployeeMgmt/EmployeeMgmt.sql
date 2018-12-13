CREATE OR REPLACE PROCEDURE sp_employee_select
(
	rec_employees  OUT   SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_employees FOR
	SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
	FROM emp
	ORDER BY empno ASC;
END;

CREATE OR REPLACE PROCEDURE sp_employee_select_one
(
	v_empno		IN		emp.empno%TYPE,
	rec_employees  OUT   SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_employees FOR
	SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
	FROM emp
	WHERE empno = v_empno;
END;

CREATE OR REPLACE PROCEDURE sp_employee_select_loc
(
	v_loc                       IN           dept.loc%TYPE,
	rec_employees            OUT            SYS_REFCURSOR
)
AS
BEGIN
	OPEN rec_employees FOR
	SELECT empno, ename, deptno, dname, loc
	FROM emp  JOIN dept
	USING (deptno)
	WHERE loc = UPPER(v_loc);
END;
