-- 코드를 작성해주세요
select fi.id,fn.fish_name,fi.length
from fish_info fi
join fish_name_info fn
on fi.fish_type=fn.fish_type
where(fi.fish_type,fi.length)
in (
    select fish_type,max(length)
    from fish_info
    group by fish_type
)
order by fi.id asc 