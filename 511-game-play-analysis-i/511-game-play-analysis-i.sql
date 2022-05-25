/* Write your T-SQL query statement below */
select player_id, event_date first_login
from
(select player_id, event_date, row_number() over (partition by player_id order by event_date asc) rank
from Activity ) A
where rank = 1;
