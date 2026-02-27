-- 코드를 입력하세요
SELECT
year(sales_date) year,
month(sales_date) month,
gender,
count(distinct o.user_id)users
from online_sale o
join user_info u
on o.user_id=u.user_id
group by year, month, gender
having gender is not null
order by year,month,gender