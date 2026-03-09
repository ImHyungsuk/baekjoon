-- 코드를 입력하세요
with recursive hours as(
    select 0 hour
    
    union all
    
    select hour+1 from hours where hour<23
)

select
h.hour,
count(o.animal_id)
from hours h
left join animal_outs o
on h.hour=hour(o.datetime)
group by h.hour
order by h.hour