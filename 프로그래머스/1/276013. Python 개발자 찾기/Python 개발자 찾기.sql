-- 코드를 작성해주세요
select id,email,first_name,last_name
from developer_infos
where skill_1='PYTHON' or skill_2='PYTHON'or skill_3='PYTHON'
order by id