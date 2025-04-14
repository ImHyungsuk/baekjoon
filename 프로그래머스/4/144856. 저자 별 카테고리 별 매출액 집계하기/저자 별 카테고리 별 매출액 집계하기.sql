-- 코드를 입력하세요
SELECT b.AUTHOR_ID,
a.AUTHOR_NAME,
b.CATEGORY,
sum(bs.SALES*b.PRICE) TOTAL_SALES
from BOOK_SALES bs
join BOOK b
on b.BOOK_ID=bs.BOOK_ID
join AUTHOR a
on a.AUTHOR_ID=b.AUTHOR_ID
where bs.SALES_DATE like '2022-01%'
group by b.CATEGORY,a.AUTHOR_ID
order by a.AUTHOR_ID asc, b.CATEGORY desc