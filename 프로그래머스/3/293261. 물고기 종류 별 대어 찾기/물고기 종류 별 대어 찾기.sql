-- 코드를 작성해주세요
with max_length as(
    select FISH_TYPE,max(LENGTH)LENGTH
    from FISH_INFO
    group by FISH_TYPE
)

select f.ID,fn.FISH_NAME,f.LENGTH
from FISH_INFO f
join FISH_NAME_INFO fn
on f.FISH_TYPE=fn.FISH_TYPE
join max_length m
on m.FISH_TYPE=f.FISH_TYPE
where m.LENGTH=f.LENGTH
order by ID asc