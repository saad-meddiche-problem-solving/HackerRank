SELECT co.CONTINENT as continent_name, FLOOR(AVG(ci.POPULATION)) as average
FROM COUNTRY As co INNER JOIN CITY As ci ON ci.COUNTRYCODE = co.CODE
GROUP BY continent_name;