use march14;
select 
    e1.EMPLOYEE_ID as employee_id,
    e1.LAST_NAME as employee_name,
    e1.MANAGER_ID as manager_id,
    e2.LAST_NAME as manager_name
from 
    employees e1
join 
    employees e2 on e1.MANAGER_ID = e2.EMPLOYEE_ID
order by employee_id;
    
