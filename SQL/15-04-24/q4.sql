use march14;

select d.department_id, d.department_name, e.first_name as manager_name from 
departments1 d join
employees e on d.manager_id = e.employee_id
order by department_id;