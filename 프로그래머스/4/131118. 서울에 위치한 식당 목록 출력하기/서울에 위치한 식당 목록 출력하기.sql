-- 코드를 입력하세요
SELECT ri.REST_ID,ri.REST_NAME,ri.FOOD_TYPE,ri.FAVORITES,ri.ADDRESS,round(avg(rr.REVIEW_SCORE),2)SCORE
from REST_INFO ri
join REST_REVIEW rr
on ri.REST_ID=rr.REST_ID
group by ri.REST_ID
having ri.ADDRESS like "서울%"
order by SCORE desc,ri.FAVORITES desc