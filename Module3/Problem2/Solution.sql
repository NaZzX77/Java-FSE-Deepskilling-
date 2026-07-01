SET SERVEROUTPUT ON;

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  account_type VARCHAR2(20),
  balance NUMBER(12,2)
);

CREATE TABLE employees (
  employee_id NUMBER PRIMARY KEY,
  employee_name VARCHAR2(50),
  department_id NUMBER,
  salary NUMBER(12,2)
);

INSERT INTO accounts VALUES (1, 101, 'Savings', 10000);
INSERT INTO accounts VALUES (2, 102, 'Savings', 15000);
INSERT INTO accounts VALUES (3, 103, 'Current', 8000);

INSERT INTO employees VALUES (1, 'Arjun', 10, 50000);
INSERT INTO employees VALUES (2, 'Kavya', 10, 60000);
INSERT INTO employees VALUES (3, 'Vikram', 20, 55000);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE accounts
  SET balance = balance + (balance * 0.01)
  WHERE account_type = 'Savings';
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department_id IN NUMBER,
  p_bonus_percentage IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * p_bonus_percentage / 100)
  WHERE department_id = p_department_id;
  COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
  p_source_account_id IN NUMBER,
  p_target_account_id IN NUMBER,
  p_amount IN NUMBER
) IS
  v_balance accounts.balance%TYPE;
BEGIN
  SELECT balance
  INTO v_balance
  FROM accounts
  WHERE account_id = p_source_account_id
  FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  END IF;

  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_source_account_id;

  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_target_account_id;

  COMMIT;
END;
/

BEGIN
  ProcessMonthlyInterest;
  UpdateEmployeeBonus(10, 5);
  TransferFunds(1, 2, 1000);
END;
/
