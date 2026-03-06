-- 코드를 입력하세요
with recursive hours as(
    select 0 as hour
    union all
    select hour+1 from hours where hour<23
)
SELECT
h.hour,
coalesce(count(animal_id),0)count
from hours h
left join animal_outs a
on h.hour=hour(a.datetime)
group by hour
order by hour