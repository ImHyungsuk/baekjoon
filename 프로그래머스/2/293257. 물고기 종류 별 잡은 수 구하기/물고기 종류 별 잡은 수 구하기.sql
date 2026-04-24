-- 코드를 작성해주세요
select
count(*) FISH_COUNT,
n.fish_name FISH_NAME
from fish_info i
join fish_name_info n
on i.fish_type=n.fish_type
group by n.fish_name
order by FISH_COUNT desc
# SELECT COUNT(I.FISH_TYPE) AS FISH_COUNT, N.FISH_NAME
# FROM FISH_INFO AS I JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
# GROUP BY I.FISH_TYPE, N.FISH_NAME
# ORDER BY FISH_COUNT DESC