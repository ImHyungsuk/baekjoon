-- 코드를 입력하세요
SELECT
category,
sum(sales) total_sales
from book_sales bs
join book b
on bs.book_id=b.book_id
where year(bs.sales_date)=2022
and month(bs.sales_date)=1
group by b.category
order by category