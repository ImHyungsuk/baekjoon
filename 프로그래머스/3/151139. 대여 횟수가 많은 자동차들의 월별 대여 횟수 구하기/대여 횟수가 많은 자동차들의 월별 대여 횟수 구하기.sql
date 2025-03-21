-- 코드를 입력하세요
SELECT month(START_DATE) MONTH,CAR_ID,count(CAR_ID) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in
(
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by CAR_ID
    having count(*)>=5
)
and month(START_DATE) between 8 and 10
group by month(START_DATE), CAR_ID
order by MONTH asc, CAR_ID desc