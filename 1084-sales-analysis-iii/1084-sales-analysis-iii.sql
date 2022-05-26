/* Write your T-SQL query statement below */
select distinct product_id, product_name
from Product X
where X.product_id in (
select product_id
from
(select B.product_id, max(sale_date) max, min(sale_date) min
from Sales B
group by product_id) A
where min >= '2019-01-01' and max <= '2019-03-31' );