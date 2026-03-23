-- 코드를 작성해주세요
select
e1.id,
count(e2.id) child_count
from ecoli_data e1
left join ecoli_data e2
on e1.id=e2.parent_id
group by e1.id
order by e1.id