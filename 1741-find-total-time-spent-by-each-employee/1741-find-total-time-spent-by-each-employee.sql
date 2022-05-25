/* Write your T-SQL query statement below */
select event_day day, emp_id, sum(total) total_time
from
(
    select emp_id, event_day, out_time - in_time total
    from Employees
) A
group by emp_id, event_day;