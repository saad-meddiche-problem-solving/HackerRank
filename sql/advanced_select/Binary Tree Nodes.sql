CREATE TABLE BST (
                     N INT,
                     P INT
);

INSERT INTO BST (N, P) VALUE (1,2);
INSERT INTO BST (N, P) VALUE (3,2);
INSERT INTO BST (N, P) VALUE (6,8);
INSERT INTO BST (N, P) VALUE (9,8);
INSERT INTO BST (N, P) VALUE (2,5);
INSERT INTO BST (N, P) VALUE (8,5);
INSERT INTO BST (N, P) VALUE (5,null);


# First query, but I realized that the sub query is expensive. Because each row will execute a new sub query.

SELECT
    main.N,
    CASE
        WHEN main.P IS NULL THEN 'Root'
        WHEN EXISTS (SELECT 1 FROM BST sub WHERE sub.P = main.N) THEN 'Inner'
        ELSE 'Leaf'
        END
FROM BST main
ORDER BY main.N;

# This one is better

SELECT
    main.N,
    CASE
        WHEN main.P IS NULL THEN 'Root'
        WHEN sub.P IS NOT NULL THEN 'Inner'
        ELSE 'Leaf'
        END
FROM BST main
         LEFT JOIN (SELECT DISTINCT P FROM BST) sub on sub.P = main.N
ORDER BY main.N;