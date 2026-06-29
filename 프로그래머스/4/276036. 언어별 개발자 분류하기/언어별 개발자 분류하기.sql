-- 코드를 작성해주세요
select
case
when d.skill_code & (select sum(s.code) from skillcodes s where s.category='Front End') !=0
and d.skill_code & (select s.code from skillcodes s where s.name='Python')!=0
then 'A'
when d.skill_code & (select s.code from skillcodes s where s.name='C#')!=0
then 'B'
when d.skill_code & (select sum(s.code) from skillcodes s where s.category='Front End') !=0
then 'C'
end grade,
d.id,
d.email
from developers d
having grade is not null
order by grade, d.id asc