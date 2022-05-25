/* Write your T-SQL query statement below */
select stock_name, sum(price) capital_gain_loss
from (
    select stock_name, case when operation = 'Buy' then -price else price end price from Stocks
)A
group by stock_name;