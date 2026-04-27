SELECT ci.NAME FROM CITY As ci
                        INNER JOIN COUNTRY As co on ci.COUNTRYCODE = co.CODE
WHERE co.CONTINENT = 'Africa';