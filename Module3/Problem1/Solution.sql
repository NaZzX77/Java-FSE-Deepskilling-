SET SERVEROUTPUT ON;

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE loans';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  customer_name VARCHAR2(50),
  date_of_birth DATE,
  balance NUMBER(12,2),
  is_vip VARCHAR2(5)
);

CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  interest_rate NUMBER(5,2),
  due_date DATE
);

INSERT INTO customers VALUES (1, 'Ravi Kumar', DATE '1955-04-10', 15000, 'FALSE');
INSERT INTO customers VALUES (2, 'Anita Rao', DATE '1995-07-20', 7000, 'FALSE');
INSERT INTO customers VALUES (3, 'Meera Shah', DATE '1960-01-15', 12000, 'FALSE');

INSERT INTO loans VALUES (101, 1, 9.5, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 10.0, SYSDATE + 45);
INSERT INTO loans VALUES (103, 3, 8.75, SYSDATE + 20);

COMMIT;

BEGIN
  FOR customer_record IN (SELECT customer_id, date_of_birth FROM customers) LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, customer_record.date_of_birth) / 12) > 60 THEN
      UPDATE loans
      SET interest_rate = interest_rate - 1
      WHERE customer_id = customer_record.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/

BEGIN
  FOR customer_record IN (SELECT customer_id, balance FROM customers) LOOP
    IF customer_record.balance > 10000 THEN
      UPDATE customers
      SET is_vip = 'TRUE'
      WHERE customer_id = customer_record.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/

BEGIN
  FOR loan_record IN (
    SELECT c.customer_name, l.loan_id, l.due_date
    FROM customers c
    JOIN loans l ON c.customer_id = l.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || loan_record.customer_name || ', loan ' || loan_record.loan_id || ' is due on ' || TO_CHAR(loan_record.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/
