-- 코드를 입력하세요
with review_count as(
    select member_id,count(*)as cnt
    from rest_review 
    group by member_id
),
max_count as(
    select max(cnt) as max_cnt from review_count
)
select
mp.member_name,
rr.review_text,
DATE_FORMAT(rr.review_date,"%Y-%m-%d")
from review_count rc
join max_count mc on rc.cnt=mc.max_cnt
join member_profile mp on rc.member_id=mp.member_id
join rest_review rr on rc.member_id=rr.member_id
order by rr.review_date ,rr.review_text asc