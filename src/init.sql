-- Drop schema if exists and create schema
DROP SCHEMA IF EXISTS dat109_project CASCADE;
CREATE SCHEMA dat109_project;

-- Set search path to the new schema
SET search_path TO dat109_project;

CREATE TABLE employee(
	employee_id serial primary key,
  first_name varchar(55),
  surname varchar(55),
  profession varchar(55),
  phone varchar(10) unique

);


Create table project(
	project_id serial primary key,
  project_name varchar(55),
  description text
);


CREATE TABLE project_participation(
    participation_id serial primary key,
    project_id int NOT NULL,
    employee_id int NOT NULL,
    role varchar(255),
    start_date date,
    end_date date,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
        REFERENCES project (project_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_employee
        FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


INSERT INTO employee (first_name, surname, profession, phone) VALUES ('John', 'Doe', 'Developer', 1000000001);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Jane', 'Smith', 'Designer', 1000000002);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Alice', 'Johnson', 'Manager', 1000000003);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Mike', 'Brown', 'Accountant', 1000000004);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Chris', 'Davis', 'Engineer', 1000000005);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Anna', 'Martinez', 'Analyst', 1000000006);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Robert', 'Garcia', 'Consultant', 1000000007);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Mary', 'Rodriguez', 'Lawyer', 1000000008);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('David', 'Hernandez', 'Architect', 1000000009);
INSERT INTO employee (first_name, surname, profession, phone) VALUES ('Emma', 'Moore', 'Salesperson', 1000000010);
