SELECT
    CASE
        WHEN A = B AND B = C THEN 'Equilateral'
        WHEN A + b <= C  OR A + C <= B OR B + C <= A THEN 'Not A Triangle'
        WHEN A = B OR A = C OR B = C THEN 'Isosceles'
        WHEN A <> B AND A <> C AND C <> B THEN 'Scalene'
    END
FROM TRIANGLES;