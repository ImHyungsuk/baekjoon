-- 코드를 입력하세요
SELECT
hour(datetime) hour,
count(distinct animal_id) count
from animal_outs
group by hour
having hour<=19
and hour>=9
order by hour asc