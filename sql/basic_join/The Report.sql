SELECT CASE WHEN g.grade >= 8 THEN s.name ELSE null END AS name , g.grade As grade, s.marks As marks
FROM Students As s INNER JOIN Grades As g ON s.marks BETWEEN g.min_mark AND g.max_mark
ORDER BY grade desc,
CASE WHEN grade >= 8 THEN name ELSE marks END asc;