SELECT h.hacker_id as id, h.name as name
FROM Hackers AS h
         JOIN Submissions As s on h.hacker_id = s.hacker_id
         JOIN Challenges As c on c.challenge_id = s.challenge_id
         JOIN Difficulty As d on d.difficulty_level = c.difficulty_level and s.score = d.score
GROUP BY id, name
HAVING count(id) > 1
ORDER BY count(id) desc, id asc