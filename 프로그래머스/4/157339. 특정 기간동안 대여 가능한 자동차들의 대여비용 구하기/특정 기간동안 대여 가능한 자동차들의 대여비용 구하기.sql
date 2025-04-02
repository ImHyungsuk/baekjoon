-- 코드를 입력하세요
SELECT distinct c.CAR_ID,c.CAR_TYPE, round(c.DAILY_FEE * 30 * (1 - dp.DISCOUNT_RATE / 100)) FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
on c.CAR_ID=rh.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp
on dp.CAR_TYPE=c.CAR_TYPE
where (c.CAR_TYPE='세단' or c.CAR_TYPE='SUV') and rh.END_DATE<'2022-11-01'and dp.DURATION_TYPE='30일 이상'
and round(c.DAILY_FEE * 30 * (1 - dp.DISCOUNT_RATE / 100)) between 500000 and 2000000
and c.CAR_ID not in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY where END_DATE >='2022-11-01' and START_DATE <='2022-11-30')
order by FEE desc, CAR_ID desc