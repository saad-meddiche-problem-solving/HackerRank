WITH cte AS (
    SELECT
        h.hacker_id as id,
        h.name as name,
        s.challenge_id as c_id,
        MAX(s.score) as score
    FROM Hackers AS h LEFT JOIN Submissions as s on s.hacker_id = h.hacker_id
    GROUP BY h.hacker_id, h.name, s.challenge_id
)
SELECT id, name, SUM(score) as total_score FROM cte
GROUP BY id, name
HAVING SUM(score) > 0
ORDER BY SUM(score) desc, id asc;