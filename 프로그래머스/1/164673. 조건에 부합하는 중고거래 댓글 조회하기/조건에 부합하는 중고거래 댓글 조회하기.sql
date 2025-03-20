-- 코드를 입력하세요
SELECT ugb.TITLE,ugr.BOARD_ID,ugr.REPLY_ID,ugr.WRITER_ID,ugr.CONTENTS,DATE_FORMAT(ugr.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_REPLY as ugr
inner join USED_GOODS_BOARD as ugb
on ugr.BOARD_ID=ugb.BOARD_ID
where YEAR(ugb.CREATED_DATE)=2022 and MONTH(ugb.CREATED_DATE)=10
order by ugr.CREATED_DATE asc, ugb.TITLE asc;