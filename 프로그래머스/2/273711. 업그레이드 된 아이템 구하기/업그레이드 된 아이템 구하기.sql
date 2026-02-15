-- 코드를 작성해주세요
select ii1.item_id, ii1.item_name,ii1.rarity
from item_info ii1
join item_tree it on ii1.item_id=it.item_id
join item_info ii2 on it.parent_item_id=ii2.item_id
where ii2.rarity='RARE'
order by ii1.item_id desc