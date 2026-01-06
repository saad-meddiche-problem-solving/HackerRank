CREATE TABLE Employee
(
    employee_code       VARCHAR(255),
    manager_code        VARCHAR(255),
    senior_manager_code VARCHAR(255),
    lead_manager_code   VARCHAR(255),
    company_code        VARCHAR(255)
);

INSERT INTO Employee (employee_code, manager_code, senior_manager_code, lead_manager_code, company_code)
VALUES ('E1','M1','SM1','LM1','C1');

INSERT INTO Employee (employee_code, manager_code, senior_manager_code, lead_manager_code, company_code)
VALUES ('E2','M1','SM2','LM1','C1');

INSERT INTO Employee (employee_code, manager_code, senior_manager_code, lead_manager_code, company_code)
VALUES ('E3','M2','SM3','LM2','C2');

INSERT INTO Employee (employee_code, manager_code, senior_manager_code, lead_manager_code, company_code)
VALUES ('E4','M3','SM3','LM2','C2');

CREATE TABLE Company
(
    company_code VARCHAR(255),
    fonder       VARCHAR(255)
);

INSERT INTO Company (company_code, fonder) VALUES('C1','Monika');
INSERT INTO Company (company_code, fonder) VALUES('C2','Samantha');

# Response
SELECT
    employee.company_code,
    company.fonder,
    COUNT(DISTINCT employee.lead_manager_code) as lead_manager_code,
    COUNT(DISTINCT employee.senior_manager_code) as senior_manager_code,
    COUNT(DISTINCT employee.manager_code) as manager_count,
    COUNT(DISTINCT employee.employee_code) as employee_count
FROM Employee employee
    LEFT JOIN Company company on company.company_code = employee.company_code
GROUP BY employee.company_code, company.fonder
ORDER BY employee.company_code;