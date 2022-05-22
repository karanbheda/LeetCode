/* Write your T-SQL query statement below */
select name
from SalesPerson
except
select B.name
from Orders A
join SalesPerson B on A.sales_id = B.sales_id
join Company C on C.com_id = A.com_id and C.name = 'RED';