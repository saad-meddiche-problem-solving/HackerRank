SELECT w.id, p.age, w.coins_needed, w.power
FROM Wands as w JOIN Wands_Property as p on w.code = p.code
WHERE p.is_evil = 0
  AND w.coins_needed = (
    SELECT MIN(w1.coins_needed) FROM Wands as w1
    JOIN Wands_Property as p1 on w1.code = p1.code
    WHERE p1.age = p.age AND w1.power = w.power
)
ORDER BY w.power desc, p.age desc;