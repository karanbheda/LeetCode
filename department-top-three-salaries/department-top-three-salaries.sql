/* Write your T-SQL query statement below */
select Employee, Department, Salary 
from
(select E.name as Employee, D.name as Department, E.salary as Salary, dense_rank() over (partition by E.departmentId order by salary desc) as rank
from Employee E
join Department D on E.departmentId = D.id) A
where rank <= 3;