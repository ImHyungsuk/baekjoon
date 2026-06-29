-- 코드를 입력하세요
SELECT
m.member_name,
r.review_text,
r.review_date
from member_profile m
join rest_review r
on m.member_id=r.member_id
join (
    select member_id, count(review_id) cnt
    from rest_review
    group by member_id
    order by cnt desc
    limit 1
) as rc
on r.member_id=rc.member_id
order by r.review_date asc, r.review_text asc