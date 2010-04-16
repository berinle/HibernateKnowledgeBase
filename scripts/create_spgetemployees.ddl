CREATE PROCEDURE sp_getemployees
(IN parm VARCHAR(20), IN parm2 VARCHAR(20))
BEGIN
  DECLARE v CHAR(10) DEFAULT 'Hello';
  SELECT * from employee;
END;