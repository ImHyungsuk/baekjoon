-- 코드를 입력하세요
SELECT u.user_id,u.nickname,
concat(u.city,' ',u.street_address1," ",u.street_address2) 전체주소,
# concat(substr(u.tlno,1,3),'-',substr(u.tlno,4,4),'-',substr(u.tlno,8)) 전화번호
insert(insert(u.tlno,4,0,'-'),9,0,'-') 전화번호
from used_goods_user u
join (
    select writer_id,count(board_id) cnt
    from used_goods_board
    group by writer_id
) b
on u.user_id=b.writer_id
where b.cnt>=3
order by u.user_id desc