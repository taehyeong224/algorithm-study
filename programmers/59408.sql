SELECT distinct count(*) as count
FROM (
    SELECT distinct name
    FROM ANIMAL_INS
    WHERE name is not null
) as A
