use march14;
select j.job_title, (round((j.min_salary+j.max_salary)/2, 2)) as AverageSalary from jobs j;