-- 코드를 작성해주세요
select
e.emp_no,
e.emp_name,
case
when avg(g.score)>=96 then 'S'
when avg(g.score) between 90 and 96 then 'A'
when avg(g.score) between 80 and 90 then 'B'
else 'C'
end grade,
case
when avg(g.score)>=96 then e.sal*20/100
when avg(g.score) between 90 and 96 then e.sal*15/100
when avg(g.score) between 80 and 90 then e.sal*10/100
else 0
end bonus
from hr_employees e
join hr_grade g
on e.emp_no=g.emp_no
group by e.emp_no
order by e.emp_no asc