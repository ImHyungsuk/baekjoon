-- 코드를 입력하세요
SELECT fh.FLAVOR from FIRST_HALF fh
join ICECREAM_INFO ii
on fh.FLAVOR=ii.FLAVOR
where TOTAL_ORDER>3000
and INGREDIENT_TYPE='fruit_based'
order by TOTAL_ORDER desc;