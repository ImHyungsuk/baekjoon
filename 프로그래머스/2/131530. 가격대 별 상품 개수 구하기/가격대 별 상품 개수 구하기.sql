-- 코드를 입력하세요
SELECT
cast(truncate(price,-4)as signed) price_group,
count(product_id) products
from product
group by price_group
order by price_group