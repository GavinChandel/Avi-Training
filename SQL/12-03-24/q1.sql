use chandelgavin1;
create table Accounts(account_id int primary key, income int);

insert into Accounts values(3,108939),(2,12747),(8,87709),(6,91796);

select 
    category.category as category,
    coalesce(accounts_count, 0) as accounts_count
from 
    (select 'Low Salary' as category
     union all
     select 'Average Salary' as category
     union all
     select 'High Salary' as category) as category
left join 
    (select 
         case 
             when income < 20000 then 'Low Salary'
             when income >= 20000 and income <= 50000 then 'Average Salary'
             when income > 50000 then 'High Salary'
         end as category,
         count(*) as accounts_count
     from 
         Accounts
     group by 
         category) as counts
on 
    category.category = counts.category
order by 
    case 
        when category.category = 'Low Salary' then 1
        when category.category = 'Average Salary' then 2
        when category.category = 'High Salary' then 3
    end;
