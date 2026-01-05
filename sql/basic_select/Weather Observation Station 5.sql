SELECT s.City, LENGTH(s.City) as cityLength FROM STATION s ORDER BY cityLength ASC , s.City LIMIT 1;
SELECT s.City, LENGTH(s.City) as cityLength FROM STATION s ORDER BY cityLength DESC , s.City LIMIT 1;
