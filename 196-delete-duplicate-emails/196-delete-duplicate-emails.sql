/* 
 Please write a DELETE statement and DO NOT write a SELECT statement.
 Write your T-SQL query statement below
 */
delete B
from Person B
join
(
    select min(id) id, email
    from Person
    group by email
) A on B.email = A.email
where A.id != B.id;