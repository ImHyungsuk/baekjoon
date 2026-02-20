-- 코드를 입력하세요
SELECT
animal_type,
coalesce(name,'No name') name,
sex_upon_intake
from animal_ins a
order by animal_id