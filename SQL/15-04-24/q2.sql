use march14;

select d.department_name, COUNT(e.employee_id) AS num_employees from departments1 d
left join employees e on d.department_id = e.department_id
group by d.department_name;