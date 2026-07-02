-- 코드를 작성해주세요
with front_codes as(
    select sum(code) codes
    from skillcodes
    where category='Front End'
)
select
d.id,
d.email,
d.first_name,
d.last_name
from developers d
join front_codes f
on d.skill_code & f.codes != 0
order by d.id asc