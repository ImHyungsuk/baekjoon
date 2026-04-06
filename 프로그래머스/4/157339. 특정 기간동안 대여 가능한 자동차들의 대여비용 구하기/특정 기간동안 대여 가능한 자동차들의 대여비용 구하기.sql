-- 코드를 입력하세요
SELECT
distinct c.car_id,
c.car_type,
round(c.daily_fee*30*(1-d.discount_rate/100)) fee
from car_rental_company_car c
join car_rental_company_discount_plan d
on c.car_type=d.car_type
join car_rental_company_rental_history h
on c.car_id=h.car_id
where c.car_type in('세단','SUV') and d.duration_type like '30%'
and round(c.daily_fee*30*(1-d.discount_rate/100)) between 500000 and 2000000
and c.car_id not in(select car_id from car_rental_company_rental_history where end_date>='2022-11-01' and start_date<='2022-11-30')
order by fee desc, car_type asc, car_id desc