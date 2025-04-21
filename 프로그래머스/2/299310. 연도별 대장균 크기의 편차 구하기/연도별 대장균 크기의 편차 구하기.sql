-- 코드를 작성해주세요
with max_size as(
    select year(DIFFERENTIATION_DATE) YEAR, max(SIZE_OF_COLONY) SIZE 
    from ECOLI_DATA
    group by YEAR
)

select year(ed.DIFFERENTIATION_DATE) as YEAR, (mx.SIZE-ed.SIZE_OF_COLONY) YEAR_DEV,ed.ID
from ECOLI_DATA ed
join max_size mx
on year(ed.DIFFERENTIATION_DATE)=mx.YEAR
order by YEAR asc, YEAR_DEV asc