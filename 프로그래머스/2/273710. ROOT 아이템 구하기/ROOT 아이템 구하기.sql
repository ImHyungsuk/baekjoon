-- 코드를 작성해주세요
select
t.item_id,
i.item_name
from item_tree t
join item_info i
on t.item_id=i.item_id
where t.parent_item_id is null
order by t.item_id asc