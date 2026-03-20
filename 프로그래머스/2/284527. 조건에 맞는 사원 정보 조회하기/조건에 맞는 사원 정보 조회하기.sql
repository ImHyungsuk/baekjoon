-- 코드를 작성해주세요
with total as(
    select sum(g.score) total_score, g.emp_no
    from hr_grade g
    group by g.emp_no
)
select t.total_score score, e.emp_no,e.emp_name,e.position,e.email
from hr_employees e
join total t
on e.emp_no=t.emp_no
order by score desc
limit 1