/* Write your T-SQL query statement below */
select max(salary) as SecondHighestSalary
from
(
    select salary, dense_rank() over (order by salary desc) as [rank]
    from Employee
) A
where A.[rank] = 2
