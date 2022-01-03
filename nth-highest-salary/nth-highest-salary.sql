CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
   
        /* Write your T-SQL query statement below. */
        declare @ans int = null;
        
        select @ans = salary from
        (
            select salary, dense_rank() over (order by salary desc) rank
            from Employee
        ) A
        where A.rank = @N
        
        return @ans;
    
END