-- 1. Crear esquema
DROP DATABASE IF EXISTS test_nach;
CREATE DATABASE test_nach;
USE test_nach;

-- 2. Catálogo de géneros
CREATE TABLE genders (
  id INT         NOT NULL,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- 3. Catálogo de puestos (jobs) con salario
CREATE TABLE jobs (
  id     INT           NOT NULL,
  name   VARCHAR(100)  NOT NULL,
  salary DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
);

-- 4. Empleados
CREATE TABLE employees (
  id         INT         NOT NULL AUTO_INCREMENT,
  gender_id  INT         NOT NULL,
  job_id     INT         NOT NULL,
  name       VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  birthdate  DATE        NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uniq_employee_name (name, last_name),
  CONSTRAINT fk_emp_gender FOREIGN KEY (gender_id)
    REFERENCES genders (id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT fk_emp_job FOREIGN KEY (job_id)
    REFERENCES jobs (id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

-- 5. Horas trabajadas
CREATE TABLE worked_hours (
  id           INT  NOT NULL AUTO_INCREMENT,
  employee_id  INT  NOT NULL,
  worked_hours INT  NOT NULL,
  worked_date  DATE NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uniq_hours_per_day (employee_id, worked_date),
  CONSTRAINT fk_wh_employee FOREIGN KEY (employee_id)
    REFERENCES employees (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

-- 6. Pagos
CREATE TABLE payments (
  id           INT           NOT NULL AUTO_INCREMENT,
  employee_id  INT           NOT NULL,
  amount       DECIMAL(10,2) NOT NULL,
  payment_date DATE          NOT NULL,
  PRIMARY KEY (id),
  INDEX idx_pay_emp_date (employee_id, payment_date),
  CONSTRAINT fk_pay_employee FOREIGN KEY (employee_id)
    REFERENCES employees (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
