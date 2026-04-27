
# ------ SAMPLES

CREATE TABLE employees (
                           employee_id INT PRIMARY KEY,
                           name VARCHAR(50),
                           months INT,
                           salary INT
);

INSERT INTO employees (employee_id, name, months, salary) VALUES
                                                              (12228, 'Rose', 15, 1968),
                                                              (33645, 'Angela', 1, 3443),
                                                              (45692, 'Frank', 17, 1608),
                                                              (56118, 'Patrick', 7, 1345),
                                                              (59725, 'Lisa', 11, 2330),
                                                              (74197, 'Kimberly', 16, 4372),
                                                              (78454, 'Bonnie', 8, 1771),
                                                              (83565, 'Michael', 6, 2017),
                                                              (98607, 'Todd', 5, 3396),
                                                              (99989, 'Joe', 9, 3573);

# ------ Solution
SELECT months * salary as earnings , count(*) as employees
FROM employees GROUP BY earnings ORDER BY earnings desc
LIMIT 1;