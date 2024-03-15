use march14;

select d.department_name, concat(e.first_name,' ',e.last_name) as ManagerName, l.city
from departments1 d join employees e on d.manager_id = e.employee_id
join locations l on d.location_id = l.location_id;