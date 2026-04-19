-- 코드를 작성해주세요
select
c.id,
c.genotype,
p.genotype parent_genotype
from ecoli_data c
join ecoli_data p
on c.parent_id=p.id
where p.genotype=(c.genotype&p.genotype)
order by c.id