# ------ First Solution

SELECT count(c.challenge_id) as max_count INTO @max_challenges_created_per_student
FROM Hackers as h LEFT JOIN Challenges as c on c.hacker_id = h.hacker_id
GROUP BY h.hacker_id
ORDER BY max_count desc limit 1;

WITH tb AS (
    SELECT h.hacker_id as id, h.name as name, count(c.challenge_id) as challenges_count
    FROM Hackers as h LEFT JOIN Challenges as c on c.hacker_id = h.hacker_id
    GROUP BY h.hacker_id, h.name
)
SELECT tb.id, tb.name, tb.challenges_count
FROM tb WHERE
    tb.challenges_count = @max_challenges_created_per_student
           OR
    tb.challenges_count in (
        SELECT tb.challenges_count FROM tb GROUP BY tb.challenges_count HAVING count(tb.challenges_count) = 1
    )
ORDER BY tb.challenges_count desc, tb.id;

# ------ Second Solution

WITH cte AS (
    SELECT
        h.hacker_id as id,
        h.name as name,
        count(c.challenge_id) as created_challenges_count,
        MAX(count(c.challenge_id)) OVER() as max_created_challenges_count,
        count(*) OVER(PARTITION BY count(c.challenge_id)) as matched_count
    FROM Hackers as h LEFT JOIN Challenges as c on c.hacker_id = h.hacker_id
    GROUP BY h.hacker_id, h.name
)
SELECT cte.id, cte.name, cte.created_challenges_count
FROM cte WHERE created_challenges_count = max_created_challenges_count OR matched_count = 1
ORDER BY cte.created_challenges_count desc, cte.id;