/* Write your T-SQL query statement below */
select customer_id, count(1) count_no_trans 
from
(select A.customer_id
from Visits A
left join Transactions B on A.visit_id = B.visit_id
where transaction_id is null) A
group by customer_id