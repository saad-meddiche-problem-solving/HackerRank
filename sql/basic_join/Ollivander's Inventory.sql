# ------ First Solution

SELECT w.id, p.age, w.coins_needed, w.power
FROM Wands as w JOIN Wands_Property as p on w.code = p.code
WHERE p.is_evil = 0
  AND w.coins_needed = (
    SELECT MIN(w1.coins_needed) FROM Wands as w1
    JOIN Wands_Property as p1 on w1.code = p1.code
    WHERE p1.age = p.age AND w1.power = w.power
)
ORDER BY w.power desc, p.age desc;

# ------ Second Solution
# I believe this solution is better, but the problem hackerrank do not accept it, maybe due to an old version of MySQL
WITH RankedWands AS (
    SELECT
        w.id,
        p.age,
        w.coins_needed,
        w.power,
        RANK() OVER (
            PARTITION BY p.age, w.power
            ORDER BY w.coins_needed ASC
            ) as price_rank
    FROM Wands w
             JOIN Wands_Property p ON w.code = p.code
    WHERE p.is_evil = 0
)
SELECT id, age, coins_needed, power
FROM RankedWands
WHERE price_rank = 1
ORDER BY power DESC, age DESC;